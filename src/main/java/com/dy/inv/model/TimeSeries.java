package com.dy.inv.model;

import com.dy.inv.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TimeSeries {
    private Map<String, DayVal> indexSeries;
    public static String START_OF_TIME = "03-Apr-79";
    public static int PREV_DAY_LIMIT = 5;

    public TimeSeries() throws IOException, ParseException {
        indexSeries = new HashMap<>();
        BufferedReader fr =
                Files.newBufferedReader(Paths.get("C:\\Developer\\idx-inv\\src\\main\\resources\\bse_history.csv"));
        String line = null;
        while ((line = fr.readLine()) != null) {
            String[] tokens = line.split(",");
            Double val = Double.valueOf(tokens[1]);
            indexSeries.put(tokens[0], new DayVal(tokens[0], val));
        }
        // Set previous day's close
        for (Map.Entry<String, DayVal> close : indexSeries.entrySet()) {


            if (close.getKey().equals(START_OF_TIME)) {
                close.getValue().setPrevDataVal(null);
            } else {
                int loopCounter = 0;
                String prev = Utils.getPreviousDay(close.getKey());

                while (loopCounter < PREV_DAY_LIMIT) {
                    loopCounter++;// Safeguarding against an infinite loop
                    if (loopCounter == PREV_DAY_LIMIT) {
                        System.out.println("possibly missing data, it won't help to go that far");
                    }
                    if (indexSeries.get(prev) != null) {
                        close.getValue().setPrevDataVal(indexSeries.get(prev).getVal());
                        break;
                    }
                    prev = Utils.getPreviousDay(prev);
                }
            }
        }
    }

    public Map<String, DayVal> getIndexSeries() {
        return indexSeries;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        indexSeries.values().stream().forEach(v -> sb.append(v).append("\n"));
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(new TimeSeries());
    }
}
