package domain;

import com.opencsv.bean.CsvBindByName;

public class AccountBeforeEod {
    @CsvBindByName(column = "id")
    private Integer id;

    @CsvBindByName(column = "Balanced")
    private Double balanced;

    @CsvBindByName(column = "Previous Balanced")
    private Double previousBalanced;

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
