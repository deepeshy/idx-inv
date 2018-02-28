package com.dy.inv.model;

import com.dy.inv.utils.Utils;
import org.joda.time.DateTime;

import java.text.ParseException;

public class DayVal {
    private DateTime date;
    private Double val;
    private Double prevDataVal;

    public double getUnits(double investment) {
        return 1.00 * investment / val;
    }

    public DateTime getDate() {
        return date;
    }

    public DayVal(String dateString, double val) throws ParseException {
        this.date = Utils.getDateFromString(dateString);
        this.val = val;
        this.prevDataVal = prevDataVal;
    }

    public Double gain() {
        if (prevDataVal == null || prevDataVal == 0.00) return null;
        else return 100.00 * (val - prevDataVal) / prevDataVal;
    }

    public boolean moreLossThan(double threshold) {
        if (gain() == null) return false;
        return gain() < threshold;
    }

    public Double getVal() {
        return val;
    }

    public void setPrevDataVal(Double prevDataVal) {
        this.prevDataVal = prevDataVal;
    }

    @Override
    public String toString() {
        return date + "," + val + "," + prevDataVal + ',' + gain();
    }
}
