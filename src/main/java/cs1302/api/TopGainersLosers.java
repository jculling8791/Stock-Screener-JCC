package cs1302.api;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a utility class for managing information about top gainers and losers.
 */
public class TopGainersLosers {
    private String metadata;
    private String lastUpdated;
    private List<TickerInfo> mostActivelyTraded = new ArrayList<>();

    /**
     * Represents information about a specific ticker.
     */
    public static class TickerInfo {
        private String ticker;
        private String price;
        private String changeAmount;
        private String changePercentage;
        private String volume;

        /**
         * Constructs a {@code TickerInfo} object with the specified details.
         *
         * @param ticker           the ticker symbol
         * @param price            the current price of the ticker
         * @param changeAmount     the change amount in the ticker's price
         * @param changePercentage the percentage change in the ticker's price
         * @param volume           the trading volume of the ticker
         */
        public TickerInfo(String ticker, String price, String changeAmount,
                          String changePercentage, String volume) {
            this.ticker = ticker;
            this.price = price;
            this.changeAmount = changeAmount;
            this.changePercentage = changePercentage;
            this.volume = volume;
        } // constructor

        /**
         * Gets the ticker symbol.
         *
         * @return the ticker symbol as a String
         */
        public String getTicker() {
            return ticker;
        } // getTicker

        /**
         * Gets the current price of the ticker.
         *
         * @return the current price as a String
         */
        public String getPrice() {
            return price;
        } // getPrice

        /**
         * Gets the change amount for the ticker.
         *
         * @return the change amount as a String
         */
        public String getChangeAmount() {
            return changeAmount;
        } // getChangeAmount

        /**
         * Gets the change percentage for the ticker.
         *
         * @return the change percentage as a String
         */
        public String getChangePercentage() {
            return changePercentage;
        } // getChangePercentage

        /**
         * Gets the trading volume for the ticker.
         *
         * @return the trading volume as a String
         */
        public String getVolume() {
            return volume;
        } // getVolume
    } // TickerInfo


    /**
     * Gets additional metadata related to the ticker.
     *
     * @return the metadata as a String
     */
    public String getMetadata() {
        return metadata;
    } // getMetaData

    /**
     * Gets the last updated timestamp for the ticker data.
     *
     * @return the last updated timestamp as a String
     */
    public String getLastUpdated() {
        return lastUpdated;
    } // getLastUpdated

    /**
     * Sets the last updated timestamp for the ticker data.
     *
     * @param lastUpdated the last updated timestamp as a String
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    } // setLastUpdated

    /**
     * Sets the list of most actively traded tickers.
     *
     * @param mostActivelyTraded a list of {@code TickerInfo} objects representing
     *                           the most actively traded tickers
     */
    public void setMostActivelyTraded(List<TickerInfo> mostActivelyTraded) {
        this.mostActivelyTraded = mostActivelyTraded;
    } // setMostActivelyTraded

    /**
     * Gets the list of most actively traded tickers.
     *
     * @return a list of {@code TickerInfo} objects representing the most actively traded tickers
     */
    public List<TickerInfo> getMostActivelyTraded() {
        return mostActivelyTraded != null ? mostActivelyTraded : new ArrayList<>();
    } // getMostActivelyTraded

} // TopGainersLosers
