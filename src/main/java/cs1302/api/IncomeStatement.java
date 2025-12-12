package cs1302.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an income statement, including details about the symbol and its annual reports.
 */
public class IncomeStatement {

    private String symbol;
    private List<IncomeStatementAnnualReport> annualReports;

    /**
     * Constructs an empty {@code IncomeStatement} object.
     */
    public IncomeStatement() {
        this.annualReports = new ArrayList<>();
    } // constructor

    /**
     * Gets the symbol associated with the income statement.
     *
     * @return the symbol as a String
     */
    public String getSymbol() {
        return symbol;
    } // getSymbol

    /**
     * Sets the symbol for the income statement.
     *
     * @param symbol the symbol as a String
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    } // setSymbol

    /**
     * Gets the list of annual reports associated with the income statement.
     *
     * @return a list of {@code IncomeStatementAnnualReport} objects
     */
    public List<IncomeStatementAnnualReport> getAnnualReports() {
        return annualReports;
    } // getAnnualReports

    /**
     * Sets the list of annual reports for the income statement.
     *
     * @param annualReports a list of {@code IncomeStatementAnnualReport} objects
     */
    public void setAnnualReports(List<IncomeStatementAnnualReport> annualReports) {
        if (annualReports == null) {
            this.annualReports = new ArrayList<>();
        } else {
            this.annualReports = annualReports;
        } // if else
    } // setAnnualReports

    @Override
    public String toString() {
        return "IncomeStatement{" +
            "symbol='" + symbol + '\'' +
            ", annualReports=" + (annualReports != null ? annualReports : "null")  +
            '}';
    } // toString

} // IncomeStatement
