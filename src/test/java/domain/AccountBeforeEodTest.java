package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountBeforeEodTest {

    public static final int DUMMY_ID = 1;
    private AccountBeforeEod accountBeforeEod;

    @BeforeEach
    public void before() {
        accountBeforeEod = new AccountBeforeEod();
        accountBeforeEod.setId(DUMMY_ID);
    }

    @Test
    public void When_BalancedAndPreviousBalancedExists_Expect_CountAverageBalancedWorks() {
        accountBeforeEod.setBalanced(100.0);
        accountBeforeEod.setPreviousBalanced(200.0);

        Assertions.assertEquals(150.0, accountBeforeEod.countAverageBalanced());
    }

    @Test
    public void When_BalancedInRangeOf100And150_Expect_EligibleForFreeTransfer() {
        accountBeforeEod.setBalanced(120.0);

        Assertions.assertEquals(true, accountBeforeEod.isFreeTransferEligible());
    }

    @Test
    public void When_BalancedUnder100_Expect_NotEligibleForFreeTransfer() {
        accountBeforeEod.setBalanced(99.0);

        Assertions.assertEquals(false, accountBeforeEod.isFreeTransferEligible());
    }

    @Test
    public void When_BalancedMoreThan150_Expect_EligibleForBonusBalanced() {
        accountBeforeEod.setBalanced(151.0);

        Assertions.assertEquals(true, accountBeforeEod.isBonusBalancedEligible());
    }

    @Test
    public void When_IdInRangeOf1And100_Expect_FirstOneHundredAccount() {
        Assertions.assertEquals(true, accountBeforeEod.isFirstOneHundredAccount());
    }

    @Test
    public void When_IdMoreThan100_Expect_NotFirstOneHundredAccount() {
        accountBeforeEod.setId(101);

        Assertions.assertEquals(false, accountBeforeEod.isFirstOneHundredAccount());
    }
}
