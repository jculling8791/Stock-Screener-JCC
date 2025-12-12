package cs1302.api;

/**
 * Represents detailed information about the current price and related
 * metrics for a specific stock or ticker.
 */
public class CurrentPriceDetails {
    private String ticker;
    private String name;
    private String exchangeShort;
    private String exchangeLong;
    private String micCode;
    private String currency;
    private double price;
    private double dayHigh;
    private double dayLow;
    private double dayOpen;
    private double week52High;
    private double week52Low;
    private String marketCap;
    private double previousClosePrice;
    private String previousClosePriceTime;
    private double dayChange;
    private long volume;
    private boolean isExtendedHoursPrice;
    private String lastTradeTime;

    /**
     * Gets the ticker symbol of the stock.
     *
     * @return the ticker symbol
     */
    public String getTicker() {
        return ticker;
    } // getTicker

    /**
     * Gets the name of the stock.
     *
     * @return the name of the stock
     */
    public String getName() {
        return name;
    } // getName

    /**
     * Gets the short name of the exchange where the stock is traded.
     *
     * @return the short exchange name
     */
    public String getExchangeShort() {
        return exchangeShort;
    } // getExchangeShort

    /**
     * Gets the long name of the exchange where the stock is traded.
     *
     * @return the long exchange name
     */
    public String getExchangeLong() {
        return exchangeLong;
    } // getExchangeLong

    /**
     * Gets the Market Identifier Code (MIC) of the exchange.
     *
     * @return the MIC code
     */
    public String getMicCode() {
        return micCode;
    } // getMicCode

    /**
     * Gets the currency in which the stock is traded.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    } // getCurrency

    /**
     * Gets the current price of the stock.
     *
     * @return the current price
     */
    public double getPrice() {
        return price;
    } // getPrice

     /**
     * Gets the highest price of the stock for the current day.
     *
     * @return the day's high price
     */
    public double getDayHigh() {
        return dayHigh;
    } // getDayHigh

    /**
     * Gets the lowest price of the stock for the current day.
     *
     * @return the day's low price
     */
    public double getDayLow() {
        return dayLow;
    } // getDayLow

    /**
     * Gets the opening price of the stock for the current day.
     *
     * @return the day's opening price
     */
    public double getDayOpen() {
        return dayOpen;
    } // getDayOpen

     /**
     * Gets the highest price of the stock in the last 52 weeks.
     *
     * @return the 52-week high price
     */
    public double getWeek52High() {
        return week52High;
    } // getWeek52High

    /**
     * Gets the lowest price of the stock in the last 52 weeks.
     *
     * @return the 52-week low price
     */
    public double getWeek52Low() {
        return week52Low;
    } // getWeek52Low

    /**
     * Gets the market capitalization of the stock.
     *
     * @return the market capitalization
     */
    public String getMarketCap() {
        return marketCap;
    } // getMarketCap

    /**
     * Gets the previous closing price of the stock.
     *
     * @return the previous close price
     */
    public double getPreviousClosePrice() {
        return previousClosePrice;
    } // getPreviousClosePrice

    /**
     * Gets the timestamp of the previous close price.
     *
     * @return the previous close price time
     */
    public String getPreviousClosePriceTime() {
        return previousClosePriceTime;
    } // getPreviousClosePriceTime

     /**
     * Gets the change in price for the current day.
     *
     * @return the day's price change
     */
    public double getDayChange() {
        return dayChange;
    } // getDayChange

    /**
     * Gets the trading volume of the stock.
     *
     * @return the trading volume
     */
    public long getVolume() {
        return volume;
    } // getVolume

     /**
     * Checks if the current price reflects extended hours trading.
     *
     * @return {@code true} if the price is from extended hours trading, {@code false} otherwise
     */
    public boolean isExtendedHoursPrice() {
        return isExtendedHoursPrice;
    } // isExtendedHoursPrice

      /**
     * Gets the last trade time for the stock.
     *
     * @return the last trade time
     */
    public String getLastTradeTime() {
        return lastTradeTime;
    } // getLastTradeTime


    /**
     * Sets the ticker symbol of the stock.
     *
     * @param ticker the ticker symbol
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    } // setTicker

    /**
     * Sets the name of the stock.
     *
     * @param name the name of the stock
     */
    public void setName(String name) {
        this.name = name;
    } // setName

    /**
     * Sets the short name of the exchange where the stock is traded.
     *
     * @param exchangeShort the short exchange name
     */
    public void setExchangeShort(String exchangeShort) {
        this.exchangeShort = exchangeShort;
    } // setExchangeShort

     /**
     * Sets the long name of the exchange where the stock is traded.
     *
     * @param exchangeLong the long exchange name
     */
    public void setExchangeLong(String exchangeLong) {
        this.exchangeLong = exchangeLong;
    } // setExchangeLong

    /**
     * Sets the Market Identifier Code (MIC) of the exchange.
     *
     * @param micCode the MIC code
     */
    public void setMicCode(String micCode) {
        this.micCode = micCode;
    } // setMicCode

     /**
     * Sets the currency in which the stock is traded.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    } // setCurrency

    /**
     * Sets the current price of the stock.
     *
     * @param price the current price
     */
    public void setPrice(double price) {
        this.price = price;
    } // setPrice

    /**
     * Sets the highest price of the stock for the current day.
     *
     * @param dayHigh the day's high price
     */
    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    } // setDayHigh

     /**
     * Sets the lowest price of the stock for the current day.
     *
     * @param dayLow the day's low price
     */
    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    } // setDayLow

     /**
     * Sets the opening price of the stock for the current day.
     *
     * @param dayOpen the day's opening price
     */
    public void setDayOpen(double dayOpen) {
        this.dayOpen = dayOpen;
    } // setDayOpen

      /**
     * Sets the highest price of the stock in the last 52 weeks.
     *
     * @param week52High the 52-week high price
     */
    public void setWeek52High(double week52High) {
        this.week52High = week52High;
    } // setWeek52High

    /**
     * Sets the lowest price of the stock in the last 52 weeks.
     *
     * @param week52Low the 52-week low price
     */
    public void setWeek52Low(double week52Low) {
        this.week52Low = week52Low;
    } // setWeek52Low

    /**
     * Sets the market capitalization of the stock.
     *
     * @param marketCap the market capitalization
     */
    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    } //setMarketCap

    /**
     * Sets the previous closing price of the stock.
     *
     * @param previousClosePrice the previous close price
     */
    public void setPreviousClosePrice(double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    } // setPreviousClosePrice

    /**
     * Sets the timestamp of the previous close price.
     *
     * @param previousClosePriceTime the previous close price time
     */
    public void setPreviousClosePriceTime(String previousClosePriceTime) {
        this.previousClosePriceTime = previousClosePriceTime;
    } // setPreviousClosePriceTime

    /**
     * Sets the change in price for the current day.
     *
     * @param dayChange the day's price change
     */
    public void setDayChange(double dayChange) {
        this.dayChange = dayChange;
    } // setDayChange

    /**
     * Sets the trading volume of the stock.
     *
     * @param volume the trading volume
     */
    public void setVolume(long volume) {
        this.volume = volume;
    } // setVolume

    /**
     * Sets whether the current price reflects extended hours trading.
     *
     * @param isExtendedHoursPrice {@code true} if the price is from
     * extended hours trading, {@code false} otherwise
     */
    public void setExtendedHoursPrice(boolean isExtendedHoursPrice) {
        this.isExtendedHoursPrice = isExtendedHoursPrice;
    } // setExtendedHoursPrice

    /**
     * Sets the last trade time for the stock.
     *
     * @param lastTradeTime the last trade time
     */
    public void setLastTradeTime(String lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    } // setLastTradeTime
} //  CurrentPriceDetails
