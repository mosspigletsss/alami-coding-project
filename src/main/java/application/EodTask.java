package application;

import domain.AccountAfterEod;
import domain.AccountBeforeEod;

import java.util.concurrent.CountDownLatch;

public class EodTask implements Runnable {

    private AccountBeforeEod accountBeforeEod;
    private AccountAfterEod accountAfterEod;
    private CountDownLatch countDownLatch;

    public EodTask(AccountBeforeEod accountBeforeEod, AccountAfterEod accountAfterEod, CountDownLatch countDownLatch) {
        this.accountBeforeEod = accountBeforeEod;
        this.accountAfterEod = accountAfterEod;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            accountAfterEod.setAverageBalanced(accountBeforeEod.countAverageBalanced());

            if (accountBeforeEod.isFreeTransferEligible()) {
                accountAfterEod.setFreeTransfer(5);
            } else if (accountBeforeEod.isBonusBalancedEligible()) {
                Double newBalanced = accountBeforeEod.getBalanced() + 25.0;
                accountAfterEod.setBalanced(newBalanced);
                accountBeforeEod.setBalanced(newBalanced);
            }

            if (accountBeforeEod.isFirstOneHundredAccount()) {
                Double newBalanced = accountBeforeEod.getBalanced() + 10.0;
                accountAfterEod.setBalanced(newBalanced);
                accountBeforeEod.setBalanced(newBalanced);
            }

            Long threadId = Thread.currentThread().getId();
            accountAfterEod.setThread1(threadId);
            accountAfterEod.setThread2a(threadId);
            accountAfterEod.setThread2b(threadId);
            accountAfterEod.setThread3(threadId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
