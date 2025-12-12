package cs1302.api;

/**
 * Represents an annual income statement report with various financial details.
 */
public class IncomeStatementAnnualReport {
    private String fiscalDateEnding;
    private String reportedCurrency;
    private Long grossProfit;
    private Long totalRevenue;
    private Long costOfRevenue;
    private Long costofGoodsAndServicesSold;
    private Long operatingIncome;
    private Long sellingGeneralAndAdministrative;
    private Long researchAndDevelopment;
    private Long operatingExpenses;
    private Long investmentIncomeNet;
    private Long netInterestIncome;
    private Long interestIncome;
    private Long interestExpense;
    private Long depreciation;
    private Long depreciationAndAmortization;
    private Long incomeBeforeTax;
    private Long incomeTaxExpense;
    private Long netIncomeFromContinuingOperations;
    private Long comprehensiveIncomeNetOfTax;
    private Long ebit;
    private Long ebitda;
    private Long netIncome;

    /**
     * gets the ebit.
     * @return the ebit
     */
    public Long getEbit() {
        return ebit;
    } // getEbit

    /** sets the ebit.
     * @param ebit the value to set.
     */
    public void setEbit(Long ebit) {
        this.ebit = ebit;
    } // setEbit

    /**
     * gets the depreciation and amortization.
     * @return the depreciation and amortization
     */
    public Long getDepreciationAndAmortization() {
        return depreciationAndAmortization;
    } // getDepreciationAndAmortization

    /**
     * sets the depreciation and amortization.
     * @param depreciationAndAmortization the value to set.
     */
    public void setDepreciationAndAmortization(Long depreciationAndAmortization) {
        this.depreciationAndAmortization = depreciationAndAmortization;
    } // setDepreciationAndAmortization

    /**
     * Gets the fiscal date ending.
     *
     * @return the fiscal date ending
     */
    public String getFiscalDateEnding() {
        return fiscalDateEnding;
    } // fiscalDateEnding

    /**
     * Gets the reported currency.
     *
     * @return the reported currency
     */
    public String getReportedCurrency() {
        return reportedCurrency;
    } // reportedCurrency

    /**
     * Gets the gross profit.
     *
     * @return the gross profit
     */
    public Long getGrossProfit() {
        return grossProfit;
    } // grossProfit

    /**
     * Gets the total revenue.
     *
     * @return the total revenue
     */
    public Long getTotalRevenue() {
        return totalRevenue;
    } // totalRevenue

    /**
     * Gets the cost of revenue.
     *
     * @return the cost of revenue
     */
    public Long getCostOfRevenue() {
        return costOfRevenue;
    } // costOfRevenue

    /**
     * Gets the cost of goods and services sold.
     *
     * @return the cost of goods and services sold
     */
    public Long getCostOfGoodsAndServicesSold() {
        return costofGoodsAndServicesSold;
    } // costOfGoodsAndServicesSold

    /**
     * Gets the operating income.
     *
     * @return the operating income
     */
    public Long getOperatingIncome() {
        return operatingIncome;
    } // operatingIncome

    /**
     * Gets the selling, general, and administrative expenses.
     *
     * @return the selling, general, and administrative expenses
     */
    public Long getSellingGeneralAndAdministrative() {
        return sellingGeneralAndAdministrative;
    } // sellingGeneralAndAdministrative

    /**
     * Gets the research and development expenses.
     *
     * @return the research and development expenses
     */
    public Long getResearchAndDevelopment() {
        return researchAndDevelopment;
    } // researchAndDevelopment

    /**
     * Gets the operating expenses.
     *
     * @return the operating expenses
     */
    public Long getOperatingExpenses() {
        return operatingExpenses;
    } // operatingExpenses

    /**
     * Gets the investment income net.
     *
     * @return the investment income net
     */
    public Long getInvestmentIncomeNet() {
        return investmentIncomeNet;
    } // investmentIncomeNet

    /**
     * Gets the net interest income.
     *
     * @return the net interest income
     */
    public Long getNetInterestIncome() {
        return netInterestIncome;
    } // netInterestIncome

    /**
     * Gets the interest income.
     *
     * @return the interest income
     */
    public Long getInterestIncome() {
        return interestIncome;
    } // interestIncome

    /**
     * Gets the interest expense.
     *
     * @return the interest expense
     */
    public Long getInterestExpense() {
        return interestExpense;
    } // interestExpense

    /**
     * Gets the depreciation value.
     *
     * @return the depreciation value
     */
    public Long getDepreciation() {
        return depreciation;
    } // depreciation

    /**
     * Gets the income before tax.
     *
     * @return the income before tax
     */
    public Long getIncomeBeforeTax() {
        return incomeBeforeTax;
    } // incomeBeforeTax

    /**
     * Gets the income tax expense.
     *
     * @return the income tax expense
     */
    public Long getIncomeTaxExpense() {
        return incomeTaxExpense;
    } // incomeTaxExpense

    /**
     * Gets the net income from continuing operations.
     *
     * @return the net income from continuing operations
     */
    public Long getNetIncomeFromContinuingOperations() {
        return netIncomeFromContinuingOperations;
    } // netIncomeFromContinuingOperations

    /**
     * Gets the comprehensive income net of tax.
     *
     * @return the comprehensive income net of tax
     */
    public Long getComprehensiveIncomeNetOfTax() {
        return comprehensiveIncomeNetOfTax;
    } // comprehensiveIncomeNetOfTax

    /**
     * Gets the EBITDA value.
     *
     * @return the EBITDA value
     */
    public Long getEbitda() {
        return ebitda;
    } // ebitda

    /**
     * Gets the net income.
     *
     * @return the net income
     */
    public Long getNetIncome() {
        return netIncome;
    } // netIncome

    /**
     * Sets the fiscal date ending.
     *
     * @param fiscalDateEnding the fiscal date ending
     */
    public void setFiscalDateEnding(String fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    } // fiscalDateEnding

    /**
     * Sets the reported currency.
     *
     * @param reportedCurrency the reported currency
     */
    public void setReportedCurrency(String reportedCurrency) {
        this.reportedCurrency = reportedCurrency;
    } // reportedCurrency

    /**
     * Sets the gross profit.
     *
     * @param grossProfit the gross profit
     */
    public void setGrossProfit(Long grossProfit) {
        this.grossProfit = grossProfit;
    } // grossProfit

    /**
     * Sets the total revenue.
     *
     * @param totalRevenue the total revenue
     */
    public void setTotalRevenue(Long totalRevenue) {
        this.totalRevenue = totalRevenue;
    } // totalRevenue

    /**
     * Sets the cost of revenue.
     *
     * @param costOfRevenue the cost of revenue
     */
    public void setCostOfRevenue(Long costOfRevenue) {
        this.costOfRevenue = costOfRevenue;
    } // costOfRevenue

    /**
     * Sets the cost of goods and services sold.
     *
     * @param costOfGoodsAndServicesSold the cost of goods and services sold
     */
    public void setCostOfGoodsAndServicesSold(Long costOfGoodsAndServicesSold) {
        this.costofGoodsAndServicesSold = costOfGoodsAndServicesSold;
    } // costOfGoodsAndServicesSold

    /**
     * Sets the operating income.
     *
     * @param operatingIncome the operating income
     */
    public void setOperatingIncome(Long operatingIncome) {
        this.operatingIncome = operatingIncome;
    } // operatingIncome

    /**
     * Sets the selling, general, and administrative expenses.
     *
     * @param sellingGeneralAndAdministrative the selling, general, and administrative expenses
     */
    public void setSellingGeneralAndAdministrative(Long sellingGeneralAndAdministrative) {
        this.sellingGeneralAndAdministrative = sellingGeneralAndAdministrative;
    } // sellingGeneralAndAdministrative

    /**
     * Sets the research and development expenses.
     *
     * @param researchAndDevelopment the research and development expenses
     */
    public void setResearchAndDevelopment(Long researchAndDevelopment) {
        this.researchAndDevelopment = researchAndDevelopment;
    } // researchAndDevelopment

    /**
     * Sets the operating expenses.
     *
     * @param operatingExpenses the operating expenses
     */
    public void setOperatingExpenses(Long operatingExpenses) {
        this.operatingExpenses = operatingExpenses;
    } // operatingExpenses

    /**
     * Sets the investment income net.
     *
     * @param investmentIncomeNet the investment income net
     */
    public void setInvestmentIncomeNet(Long investmentIncomeNet) {
        this.investmentIncomeNet = investmentIncomeNet;
    } // investmentIncomeNet

    /**
     * Sets the net interest income.
     *
     * @param netInterestIncome the net interest income
     */
    public void setNetInterestIncome(Long netInterestIncome) {
        this.netInterestIncome = netInterestIncome;
    } // netInterestIncome

    /**
     * Sets the interest income.
     *
     * @param interestIncome the interest income
     */
    public void setInterestIncome(Long interestIncome) {
        this.interestIncome = interestIncome;
    } // interestIncome

    /**
     * Sets the interest expense.
     *
     * @param interestExpense the interest expense
     */
    public void setInterestExpense(Long interestExpense) {
        this.interestExpense = interestExpense;
    } // interestExpense

    /**
     * Sets the depreciation value.
     *
     * @param depreciation the depreciation value
     */
    public void setDepreciation(Long depreciation) {
        this.depreciation = depreciation;
    } // depreciation

    /**
     * Sets the income before tax.
     *
     * @param incomeBeforeTax the income before tax
     */
    public void setIncomeBeforeTax(Long incomeBeforeTax) {
        this.incomeBeforeTax = incomeBeforeTax;
    } // incomeBeforeTax

    /**
     * Sets the income tax expense.
     *
     * @param incomeTaxExpense the income tax expense
     */
    public void setIncomeTaxExpense(Long incomeTaxExpense) {
        this.incomeTaxExpense = incomeTaxExpense;
    } // incomeTaxExpense

    /**
     * Sets the net income from continuing operations.
     *
     * @param netIncomeFromContinuingOperations the net income from continuing operations
     */
    public void setNetIncomeFromContinuingOperations(Long netIncomeFromContinuingOperations) {
        this.netIncomeFromContinuingOperations = netIncomeFromContinuingOperations;
    } // netIncomeFromContinuingOperations

    /**
     * Sets the comprehensive income net of tax.
     *
     * @param comprehensiveIncomeNetOfTax the comprehensive income net of tax
     */
    public void setComprehensiveIncomeNetOfTax(Long comprehensiveIncomeNetOfTax) {
        this.comprehensiveIncomeNetOfTax = comprehensiveIncomeNetOfTax;
    } // comprehensiveIncomeNetOfTax

    /**
     * Sets the EBITDA value.
     *
     * @param ebitda the EBITDA value
     */
    public void setEbitda(Long ebitda) {
        this.ebitda = ebitda;
    } // ebitda

    /**
     * Sets the net income.
     *
     * @param netIncome the net income
     */
    public void setNetIncome(Long netIncome) {
        this.netIncome = netIncome;
    } // netIncome

} // IncomeStatementAnnualReport
