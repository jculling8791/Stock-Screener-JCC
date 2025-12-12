package cs1302.api;

/**
 * Represents the current price data, including metadata and detailed price information.
 */
public class CurrentPrice {
    private Meta meta;
    private CurrentPriceDetails[] data;

    /**
     * Gets the metadata associated with the current price data.
     *
     * @return a {@code Meta} object containing metadata information
     */
    public Meta getMeta() {
        return meta;
    } // getMeta

    /**
     * Sets the metadata associated with the current price data.
     *
     * @param meta a {@code Meta} object containing metadata information
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    } // setMeta

    /**
     * Gets the array of detailed current price information.
     *
     * @return an array of {@code CurrentPriceDetails} objects containing price details
     */
    public CurrentPriceDetails[] getData() {
        return data;
    } // getData

    /**
     * Sets the array of detailed current price information.
     *
     * @param data an array of {@code CurrentPriceDetails} objects containing price details
     */
    public void setData(CurrentPriceDetails[] data) {
        this.data = data;
    } // setData

} // CurrentPrice
