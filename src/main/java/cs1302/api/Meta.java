package cs1302.api;

/**
 * Represents metadata information about the requested and returned data.
 */
public class Meta {
    private int requested;
    private int returned;

    /**
     * Gets the number of requested items.
     *
     * @return the number of items requested
     */
    public int getRequested() {
        return requested;
    } // getRequested

    /**
     * Gets the number of returned items.
     *
     * @return the number of items returned
     */
    public int getReturned() {
        return returned;
    } // getReturned

    /**
     * Sets the number of requested items.
     *
     * @param requested the number of items requested
     */
    public void setRequested(int requested) {
        this.requested = requested;
    } // setRequested

    /**
     * Sets the number of returned items.
     *
     * @param returned the number of items returned
     */
    public void setReturned(int returned) {
        this.returned = returned;
    } // setReturned
} // Meta
