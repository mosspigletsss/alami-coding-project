package domain;

import com.opencsv.bean.CsvBindByPosition;

public class AccountBeforeEod {

    @CsvBindByPosition(position = 0)
    private Integer id;

    @CsvBindByPosition(position = 3)
    private Double balanced;

    @CsvBindByPosition(position = 4)
    private Double previousBalanced;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPreviousBalanced(Double previousBalanced) {
        this.previousBalanced = previousBalanced;
    }

    public Double getBalanced() {
        return balanced;
    }

    public void setBalanced(Double balanced) {
        this.balanced = balanced;
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

    @Override
    public String toString() {
        return "AccountBeforeEod{" +
                "id=" + id +
                ", balanced=" + balanced +
                ", previousBalanced=" + previousBalanced +
                '}';
    }
}
