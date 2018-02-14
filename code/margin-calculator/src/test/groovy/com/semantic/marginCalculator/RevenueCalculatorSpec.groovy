package com.semantic.marginCalculator

import spock.lang.Specification
import spock.lang.Subject


class RevenueCalculatorSpec extends Specification {

    @Subject
    private RevenueCalculator subject

    void setup() {
        subject = new RevenueCalculatorImpl()
    }

    def "Calculate Reveneu"() {
        when:
        def result = subject.calculateRevenue marginpercentage, costOfGoods

        then:
        result == reveneu

        where:
        marginpercentage | costOfGoods | reveneu
        20               | 400         | 500
        95               | 400         | 8000
        0                | 400         | 400
    }
}
