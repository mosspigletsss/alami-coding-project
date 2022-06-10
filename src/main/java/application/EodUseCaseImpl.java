package application;

import domain.AccountAfterEod;
import domain.AccountBeforeEod;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class EodUseCaseImpl implements EodUseCase {
    @Override
    public void executeEodTask(String beforeEodPath, String afterEodPath) {
        CsvUtil<AccountBeforeEod> beforeEodCsvUtil = new CsvUtil<>(AccountBeforeEod.class);
        CsvUtil<AccountAfterEod> afterEodCsvUtil = new CsvUtil<>(AccountAfterEod.class);

        List<AccountBeforeEod> accountBeforeEods = beforeEodCsvUtil.readCsv(beforeEodPath);
        List<AccountAfterEod> accountAfterEods = afterEodCsvUtil.readCsv(afterEodPath);

        int csvRows = accountBeforeEods.size();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(csvRows);
        for (int index = 0; index < csvRows; index++) {
            AccountBeforeEod accountBeforeEod = accountBeforeEods.get(index);
            AccountAfterEod accountAfterEod = accountAfterEods.get(index);
            EodTask eodTaskExecutor = new EodTask(accountBeforeEod, accountAfterEod, latch);

            threadPoolExecutor.execute(eodTaskExecutor);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Writing...");
        for (int index = 0; index < csvRows; index++) {
            afterEodCsvUtil.writeCsv(accountAfterEods, afterEodPath);
        }

        System.out.println("FINISH!");
    }
}
