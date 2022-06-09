package domain;

public class AccountBeforeEod {
    private Integer id;
    private Double balanced;
    private Double previousBalanced;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalanced(Double balanced) {
        this.balanced = balanced;
    }

    public void setPreviousBalanced(Double previousBalanced) {
        this.previousBalanced = previousBalanced;
    }

    public Double countAverageBalanced() {
        return (this.balanced + this.previousBalanced) / 2;
    }

    public boolean isFreeTransferEligible() {
        return balanced.compareTo(100.0) >= 0 && balanced.compareTo(150.0) <= 0;
    }

    public boolean isBonusBalancedEligible() {
        return balanced.compareTo(150.0) > 0;
    }

    public boolean isFirstOneHundredAccount() {
        return id >= 1 && id <= 100;
    }
}
