package cs1302.api;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class that provides mock data for testing purposes related to top gainers and losers.
 */
public class MockDataTopGainersLosers {

    /**
     * Generates and returns mock data for top gainers and losers.
     *
     * @return a {@code TopGainersLosers} object containing mock data for top gainers and losers
     */
    public static TopGainersLosers getMockTopGainersLosers() {
        TopGainersLosers mockData = new TopGainersLosers();
        mockData.setLastUpdated("2024-11-29 16:15:59 US/Eastern");
        List<TopGainersLosers.TickerInfo> tickers = new ArrayList<>();
        tickers.add(new TopGainersLosers.TickerInfo("AAPL", "175.96", "1.29", "0.73%", "35000000"));
        tickers.add(new TopGainersLosers.TickerInfo("MSFT", "300.24", "0.78", "0.26%", "22000000"));
        tickers.add(new TopGainersLosers.TickerInfo("GOOG", "120.44", "2.10", "1.75%", "18000000"));
        tickers.add(new TopGainersLosers.TickerInfo("AMZN", "140.50", "0.50", "0.36%", "30000000"));
        tickers.add(new TopGainersLosers.TickerInfo("META", "350.76", "5.42", "1.57%", "56549723"));
        tickers.add(new TopGainersLosers.TickerInfo("TSLA", "900.76", "3.42", "0.38%", "40000000"));
        tickers.add(new TopGainersLosers.TickerInfo("NFLX", "380.30", "5.60", "1.48%", "8000000"));
        tickers.add(new TopGainersLosers.TickerInfo("INTC", "48.76", "0.35", "0.72%", "25000000"));
        tickers.add(new TopGainersLosers.TickerInfo("CSCO", "43.55", "0.65", "1.51%", "20000000"));
        tickers.add(new TopGainersLosers.TickerInfo("ORCL", "88.00", "1.25", "1.41%", "12000000"));
        tickers.add(new TopGainersLosers.TickerInfo("IBM", "134.22", "0.88", "0.66%", "5000000"));
        tickers.add(new TopGainersLosers.TickerInfo("NVDA", "289.40", "4.99", "1.74%", "35000000"));
        tickers.add(new TopGainersLosers.TickerInfo("PYPL", "104.77", "0.56", "0.54%", "10000000"));
        tickers.add(new TopGainersLosers.TickerInfo("ADBE", "450.19", "5.42", "1.21%", "6000000"));
        tickers.add(new TopGainersLosers.TickerInfo("CRM", "225.50", "-3.30", "-1.45%", "9000000"));
        tickers.add(new TopGainersLosers.TickerInfo("UBER", "44.07", "0.74", "1.70%", "15000000"));
        tickers.add(new TopGainersLosers.TickerInfo("LYFT", "16.50", "-0.30", "-1.79%", "8000000"));
        tickers.add(new TopGainersLosers.TickerInfo("V", "210.77", "-0.99", "-0.47%", "12000000"));
        tickers.add(new TopGainersLosers.TickerInfo("MA", "365.22", "-2.15", "-0.59%", "7000000"));
        tickers.add(new TopGainersLosers.TickerInfo("DIS", "105.25", "-1.15", "-1.08%", "1400000"));
        mockData.setMostActivelyTraded(tickers);
        return mockData;
    } // getMockTopGainersLosers
} // MockDataService
