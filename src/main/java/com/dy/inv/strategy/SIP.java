package com.dy.inv.strategy;

import org.joda.time.DateTime;

public class SIP {
    private double investment;
    private DateTime investmentStartDate;
    private DateTime investmentEndDate;
    private DateTime comparisonDate;


    public SIP(double investment, DateTime startDate, DateTime endDate) {
        this.investment = investment;
        this.investmentStartDate = startDate;
        this.investmentEndDate = endDate;

        // Work out number of periods
        // Divide the investment amount
        // For every month find the first day available to invest
        // Get a map of dates and units
        // Work out the final units and calculate return
        // Annualize the return

    }

    public double getUnits() {
        return 0.0;
    }

}
