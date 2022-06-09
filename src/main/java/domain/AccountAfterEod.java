package domain;

import com.opencsv.bean.CsvBindByName;

public class AccountAfterEod {

    @CsvBindByName(column = "id")
    private Integer id;

    @CsvBindByName(column = "Nama")
    private String nama;

    @CsvBindByName(column = "Age")
    private Integer age;

    @CsvBindByName(column = "Balanced")
    private Double balanced;

    @CsvBindByName(column = "No 2b Thread-No")
    private Integer thread2b;

    @CsvBindByName(column = "No 3 Thread-No")
    private Integer thread3;

    @CsvBindByName(column = "Previous Balanced")
    private Double previousBalanced;

    @CsvBindByName(column = "Average Balanced")
    private Double averageBalanced;

    @CsvBindByName(column = "No 1 Thread-No")
    private Integer thread1;

    @CsvBindByName(column = "Free Transfer")
    private Integer freeTransfer;

    @CsvBindByName(column = "No 2a Thread-No")
    private Integer thread2a;

    public void setAverageBalanced(Double averageBalanced) {
        this.averageBalanced = averageBalanced;
    }

    public void setBalanced(Double balanced) {
        this.balanced = balanced;
    }

    public Double getBalanced() {
        return balanced;
    }

    public void setFreeTransfer(Integer freeTransfer) {
        this.freeTransfer = freeTransfer;
    }

    public void setThread1(Integer thread1) {
        this.thread1 = thread1;
    }

    public void setThread2a(Integer thread2a) {
        this.thread2a = thread2a;
    }

    public void setThread2b(Integer thread2b) {
        this.thread2b = thread2b;
    }

    public void setThread3(Integer thread3) {
        this.thread3 = thread3;
    }

    @Override
    public String toString() {
        return "AccountAfterEod{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", age=" + age +
                ", balanced=" + balanced +
                ", thread2b=" + thread2b +
                ", thread3=" + thread3 +
                ", previousBalanced=" + previousBalanced +
                ", averageBalanced=" + averageBalanced +
                ", thread1=" + thread1 +
                ", freeTransfer=" + freeTransfer +
                ", thread2a=" + thread2a +
                '}';
    }
}
