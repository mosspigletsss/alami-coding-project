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
        return false;
    }

    public boolean isBonusBalancedEligible() {
        return false;
    }

    public boolean isFirstOneHundredAccount() {
        return false;
    }
}
