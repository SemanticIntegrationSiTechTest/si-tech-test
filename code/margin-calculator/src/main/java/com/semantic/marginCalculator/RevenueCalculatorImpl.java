package com.semantic.marginCalculator;

import java.math.BigDecimal;

public class RevenueCalculatorImpl implements RevenueCalculator {
    @Override
    public BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {
        //interface doesn't consider exceptions for 100 marginPercentage or over.
        return costOfGoods.divide(BigDecimal.ONE.subtract(marginPercentage.movePointLeft(2)));
    }
}
