package domain;

import com.opencsv.bean.CsvBindByPosition;

public class AccountAfterEod {

    @CsvBindByPosition(position = 0)
    private Integer id;

    @CsvBindByPosition(position = 1)
    private String nama;

    @CsvBindByPosition(position = 2)
    private Integer age;

    @CsvBindByPosition(position = 3)
    private Double balanced;

    @CsvBindByPosition(position = 4)
    private Long thread2b;

    @CsvBindByPosition(position = 5)
    private Long thread3;

    @CsvBindByPosition(position = 6)
    private Double previousBalanced;

    @CsvBindByPosition(position = 7)
    private Double averageBalanced;

    @CsvBindByPosition(position = 8)
    private Long thread1;

    @CsvBindByPosition(position = 9)
    private Integer freeTransfer;

    @CsvBindByPosition(position = 10)
    private Long thread2a;

    public void setAverageBalanced(Double averageBalanced) {
        this.averageBalanced = averageBalanced;
    }

    public void setBalanced(Double balanced) {
        this.balanced = balanced;
    }

    public void setFreeTransfer(Integer freeTransfer) {
        this.freeTransfer = freeTransfer;
    }

    public void setThread1(Long thread1) {
        this.thread1 = thread1;
    }

    public void setThread2a(Long thread2a) {
        this.thread2a = thread2a;
    }

    public void setThread2b(Long thread2b) {
        this.thread2b = thread2b;
    }

    public void setThread3(Long thread3) {
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
