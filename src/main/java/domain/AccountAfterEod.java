package domain;

public class AccountAfterEod {
    private Integer id;
    private String nama;
    private Integer age;
    private Double balanced;
    private Integer thread2b;
    private Integer thread3;
    private Double previousBalanced;
    private Double averageBalanced;
    private Integer thread1;
    private Integer freeTransfer;
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
}
