package cs1302.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a balance sheet, including details about the symbol and its annual reports.
 */
public class BalanceSheet {

    private String symbol;
    private List<BalanceSheetAnnualReport> annualReports;

    /**
     * Constructs an empty {@code BalanceSheet} object.
     */
    public BalanceSheet() {
        this.annualReports = new ArrayList<>();
    } // constructor

    /**
     * Gets the symbol associated with the balance sheet.
     *
     * @return the symbol as a String
     */
    public String getSymbol() {
        return symbol;
    } // getSymbol

    /**
     * Sets the symbol for the balance sheet.
     *
     * @param symbol the symbol as a String
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    } // setSymbol

    /**
     * Gets the list of annual reports associated with the balance sheet.
     *
     * @return a list of {@code BalanceSheetAnnualReport} objects
     */
    public List<BalanceSheetAnnualReport> getAnnualReports() {
        return annualReports;
    } // getAnnualReports

    /**
     * Sets the list of annual reports for the balance sheet.
     *
     * @param annualReports a list of {@code BalanceSheetAnnualReport} objects
     */
    public void setAnnualReports(List<BalanceSheetAnnualReport> annualReports) {
        if (annualReports == null) {
            this.annualReports = new ArrayList<>();
        } else {
            this.annualReports = annualReports;
        } // if else
    } // setAnnualReports

    @Override
    public String toString() {
        return "BalanceSheet{" +
            "symbol='" + symbol + '\'' +
            ", annualReports=" + (annualReports != null ? annualReports : "null") +
            '}';
    } // toString

} // BalanceSheet
