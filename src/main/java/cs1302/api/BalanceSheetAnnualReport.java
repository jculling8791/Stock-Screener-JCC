package cs1302.api;

/**
 * Represents an annual report of a balance sheet, containing financial information
 * such as assets, liabilities, and equity for a specific fiscal year.
 */
public class BalanceSheetAnnualReport {
    private String fiscalDateEnding;
    private String reportedCurrency;
    private Long totalAssets;
    private Long totalCurrentAssets;
    private Long cashAndCashEquivalentsAtCarryingValue;
    private Long cashAndShortTermInvestments;
    private Long inventory;
    private Long currentNetReceivables;
    private Long totalNonCurrentAssets;
    private Long propertyPlantEquipment;
    private Long accumulatedDepreciationAmortizationPPE;
    private Long intangibleAssets;
    private Long intangibleAssetsExcludingGoodwill;
    private Long goodwill;
    private Long investments;
    private Long longTermInvestments;
    private Long shortTermInvestments;
    private Long otherCurrentAssets;
    private Long otherNonCurrentAssets;
    private Long totalLiabilities;
    private Long totalCurrentLiabilities;
    private Long currentAccountsPayable;
    private Long deferredRevenue;
    private Long currentDebt;
    private Long shortTermDebt;
    private Long totalNonCurrentLiabilities;
    private Long capitalLeaseObligations;
    private Long longTermDebt;
    private Long currentLongTermDebt;
    private Long longTermDebtNoncurrent;
    private Long shortLongTermDebtTotal;
    private Long otherCurrentLiabilities;
    private Long otherNonCurrentLiabilities;
    private Long totalShareholderEquity;
    private Long treasuryStock;
    private Long retainedEarnings;
    private Long commonStock;
    private Long commonStockSharesOutstanding;

    /**
     * gets the value.
     * @return the fiscal date ending for this report.
     */
    public String getFiscalDateEnding() {
        return fiscalDateEnding;
    } // getFiscalDateEnding

    /**
     * gets the value.
     * @return the reported currency for this report.
     */
    public String getReportedCurrency() {
        return reportedCurrency;
    } // getReportedCurrency

    /**
     * gets the value.
     * @return the total assets value.
     */
    public Long getTotalAssets() {
        return totalAssets;
    } // getTotalAssets

    /**
     * gets the value.
     * @return the total current assets value.
     */
    public Long getTotalCurrentAssets() {
        return totalCurrentAssets;
    } // getTotalCurrentAssets

    /**
     * gets the value.
     * @return the value of cash and cash equivalents at carrying value.
     */
    public Long getCashAndCashEquivalentsAtCarryingValue() {
        return cashAndCashEquivalentsAtCarryingValue;
    } // getCashAndCashEquivalentsAtCarryingValue

    /**
     * gets the value.
     * @return the value of cash and short-term investments.
     */
    public Long getCashAndShortTermInvestments() {
        return cashAndShortTermInvestments;
    } // getCashAndShortTermInvestments

    /**
     * gets the value.
     * @return the inventory value.
     */
    public Long getInventory() {
        return inventory;
    } // getInventory

    /**
     * gets the value.
     * @return the current net receivables value.
     */
    public Long getCurrentNetReceivables() {
        return currentNetReceivables;
    } // getCurrentNetReceivables

    /**
     * gets the value.
     * @return the total non-current assets value.
     */
    public Long getTotalNonCurrentAssets() {
        return totalNonCurrentAssets;
    } // getTotalNonCurrentAssets

    /**
     * gets the value.
     * @return the property, plant, and equipment value.
     */
    public Long getPropertyPlantEquipment() {
        return propertyPlantEquipment;
    } // getPropertyPlantEquipment

    /**
     * gets the value.
     * @return the accumulated depreciation and amortization of PPE value.
     */
    public Long getAccumulatedDepreciationAmortizationPPE() {
        return accumulatedDepreciationAmortizationPPE;
    } // getAccumulatedDepreciationAmortizationPPE

    /**
     * gets the value.
     * @return the intangible assets value.
     */
    public Long getIntangibleAssets() {
        return intangibleAssets;
    } // getIntangibleAssets

    /**
     * gets the value.
     * @return the intangible assets excluding goodwill value.
     */
    public Long getIntangibleAssetsExcludingGoodwill() {
        return intangibleAssetsExcludingGoodwill;
    } // getIntangibleAssetsExcludingGoodwill

    /**
     * gets the value.
     * @return the goodwill value.
     */
    public Long getGoodwill() {
        return goodwill;
    } // getGoodwill

    /**
     * gets the value.
     * @return the investments value.
     */
    public Long getInvestments() {
        return investments;
    } // getInvestments

    /**
     * gets the value.
     * @return the long term investments value.
     */
    public Long getLongTermInvestments() {
        return longTermInvestments;
    } // getLongTermInvestments

    /**
     * gets the value.
     * @return the short term investments value.
     */
    public Long getShortTermInvestments() {
        return shortTermInvestments;
    } // getShortTermInvestments

    /**
     * gets the value.
     * @return the other current assets value.
     */
    public Long getOtherCurrentAssets() {
        return otherCurrentAssets;
    } // getOtherCurrentAssets

    /**
     * gets the value.
     * @return the other non current assets value.
     */
    public Long getOtherNonCurrentAssets() {
        return otherNonCurrentAssets;
    } // getOtherNonCurrentAssets

    /**
     * gets the value.
     * @return the total liabilities value.
     */
    public Long getTotalLiabilities() {
        return totalLiabilities;
    } // getTotalLiabilities

    /**
     * gets the value.
     * @return the total current liabilities value.
     */
    public Long getTotalCurrentLiabilities() {
        return totalCurrentLiabilities;
    } // getTotalCurrentLiabilities

    /**
     * gets the value.
     * @return the current accounts payable value.
     */
    public Long getCurrentAccountsPayable() {
        return currentAccountsPayable;
    } // getCurrentAccountsPayable

    /**
     * gets the value.
     * @return the deferred revenue value.
     */
    public Long getDeferredRevenue() {
        return deferredRevenue;
    } // getDeferredRevenue

    /**
     * gets the value.
     * @return the current debt value.
     */
    public Long getCurrentDebt() {
        return currentDebt;
    } // getCurrentDebt

    /**
     * gets the value.
     * @return the short term debt value.
     */
    public Long getShortTermDebt() {
        return shortTermDebt;
    } // getShortTermDebt

    /**
     * gets the value.
     * @return the total non current liabilities value.
     */
    public Long getTotalNonCurrentLiabilities() {
        return totalNonCurrentLiabilities;
    } // getTotalNonCurrentLiabilities

    /**
     * gets the value.
     * @return the capital lease obligations value.
     */
    public Long getCapitalLeaseObligations() {
        return capitalLeaseObligations;
    } // getCapitalLeaseObligations

    /**
     * gets the value.
     * @return the long term debt value.
     */
    public Long getLongTermDebt() {
        return longTermDebt;
    } // getLongTermDebt

    /**
     * gets the value.
     * @return the current long term debt value.
     */
    public Long getCurrentLongTermDebt() {
        return currentLongTermDebt;
    } // getCurrentLongTermDebt

    /**
     * gets the value.
     * @return the long term debt non current value.
     */
    public Long getLongTermDebtNoncurrent() {
        return longTermDebtNoncurrent;
    } // getLongTermDebtNoncurrent

    /**
     * gets the value.
     * @return the short long term debt total value.
     */
    public Long getShortLongTermDebtTotal() {
        return shortLongTermDebtTotal;
    } // getShortLongTermDebtTotal

    /**
     * gets the value.
     * @return the other current liabilities value.
     */
    public Long getOtherCurrentLiabilities() {
        return otherCurrentLiabilities;
    } // getOtherCurrentLiabilities

    /**
     * gets the value.
     * @return the other non current liabilities value.
     */
    public Long getOtherNonCurrentLiabilities() {
        return otherNonCurrentLiabilities;
    } // getOtherNonCurrentLiabilities

    /**
     * gets the value.
     * @return the total shareholder equity value.
     */
    public Long getTotalShareholderEquity() {
        return totalShareholderEquity;
    } // getTotalShareholderEquity

    /**
     * gets the value.
     * @return the treasury stock value.
     */
    public Long getTreasuryStock() {
        return treasuryStock;
    } // getTreasuryStock

    /**
     * gets the value.
     * @return the retained earnings value.
     */
    public Long getRetainedEarnings() {
        return retainedEarnings;
    } // getRetainedEarnings

    /**
     * gets the value.
     * @return the common stock value.
     */
    public Long getCommonStock() {
        return commonStock;
    } // getCommonStock

    /**
     * gets the value.
     * @return the common stock shares outstanding value.
     */
    public Long getCommonStockSharesOutstanding() {
        return commonStockSharesOutstanding;
    } // getCommonStockSharesOutstanding

    /**
     * sets the value.
     * @param fiscalDateEnding the fiscal date ending to set.
     */
    public void setFiscalDateEnding(String fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    } // setFiscalDateEnding

    /**
     * sets the value.
     * @param reportedCurrency the reported currency to set.
     */
    public void setReportedCurrency(String reportedCurrency) {
        this.reportedCurrency = reportedCurrency;
    } // setReportedCurrency

    /**
     * sets the value.
     * @param totalAssets the total assets value to set.
     */
    public void setTotalAssets(Long totalAssets) {
        this.totalAssets = totalAssets;
    } // setTotalAssets

    /**
     * sets the value.
     * @param totalCurrentAssets the total current assets value to set.
     */
    public void setTotalCurrentAssets(Long totalCurrentAssets) {
        this.totalCurrentAssets = totalCurrentAssets;
    } // setTotalCurrentAssets

    /**
     * sets the value.
     * @param cashAndCashEquivalentsAtCarryingValue the value of cash and cash equivalents to set.
     */
    public void setCashAndCashEquivalentsAtCarryingValue(Long
                                                         cashAndCashEquivalentsAtCarryingValue) {
        this.cashAndCashEquivalentsAtCarryingValue = cashAndCashEquivalentsAtCarryingValue;
    } // setCashAndCashEquivalentsAtCarryingValue

    /**
     * sets the value.
     * @param cashAndShortTermInvestments the value of cash and short-term investments to set.
     */
    public void setCashAndShortTermInvestments(Long
                                               cashAndShortTermInvestments) {
        this.cashAndShortTermInvestments = cashAndShortTermInvestments;
    } // setCashAndShortTermInvestments

    /**
     * sets the value.
     * @param inventory the inventory value to set.
     */
    public void setInventory(Long inventory) {
        this.inventory = inventory;
    } // setInventory

    /**
     * sets the value.
     * @param currentNetReceivables the current net receivables value to set.
     */
    public void setCurrentNetReceivables(Long currentNetReceivables) {
        this.currentNetReceivables = currentNetReceivables;
    } // setCurrentNetReceivables

    /**
     * sets the value.
     * @param totalNonCurrentAssets the total non-current assets value to set.
     */
    public void setTotalNonCurrentAssets(Long totalNonCurrentAssets) {
        this.totalNonCurrentAssets = totalNonCurrentAssets;
    } // setTotalNonCurrentAssets

    /**
     * sets the value.
     * @param propertyPlantEquipment the property, plant, and equipment value to set.
     */
    public void setPropertyPlantEquipment(Long propertyPlantEquipment) {
        this.propertyPlantEquipment = propertyPlantEquipment;
    } // setPropertyPlantEquipment

    /**
     * sets the value.
     * @param accumulatedDepreciationAmortizationPPE the accumulated depreciation
     * and amortization of PPE value to set.
     */
    public void setAccumulatedDepreciationAmortizationPPE(Long
                                                          accumulatedDepreciationAmortizationPPE) {
        this.accumulatedDepreciationAmortizationPPE = accumulatedDepreciationAmortizationPPE;
    } // setAccumulatedDepreciationAmortizationPPE

    /**
     * sets the value.
     * @param intangibleAssets the intangible assets value to set.
     */
    public void setIntangibleAssets(Long intangibleAssets) {
        this.intangibleAssets = intangibleAssets;
    } // setIntangibleAssets

    /**
     * sets the value.
     * @param intangibleAssetsExcludingGoodwill the intangible assets
     * excluding goodwill value to set.
     */
    public void setIntangibleAssetsExcludingGoodwill(Long
                                                     intangibleAssetsExcludingGoodwill) {
        this.intangibleAssetsExcludingGoodwill = intangibleAssetsExcludingGoodwill;
    } // setIntangibleAssetsExcludingGoodwill

    /**
     * sets the value.
     * @param goodwill the goodwill value to set.
     */
    public void setGoodwill(Long goodwill) {
        this.goodwill = goodwill;
    } // setGoodwill

    /**
     * sets the value.
     * @param investments the value to set.
     */
    public void setInvestments(Long investments) {
        this.investments = investments;
    } // setInvestments

    /**
     * sets the value.
     * @param longTermInvestments the value to set.
     */
    public void setLongTermInvestments(Long longTermInvestments) {
        this.longTermInvestments = longTermInvestments;
    } // setLongTermInvestments

    /**
     * sets the value.
     * @param shortTermInvestments the value to set.
     */
    public void setShortTermInvestments(Long shortTermInvestments) {
        this.shortTermInvestments = shortTermInvestments;
    } // setShortTermInvestments

    /**
     * sets the value.
     * @param otherCurrentAssets the value to set.
     */
    public void setOtherCurrentAssets(Long otherCurrentAssets) {
        this.otherCurrentAssets = otherCurrentAssets;
    } // setOtherCurrentAssets

    /**
     * sets the value.
     * @param otherNonCurrentAssets the value to set.
     */
    public void setOtherNonCurrentAssets(Long otherNonCurrentAssets) {
        this.otherNonCurrentAssets = otherNonCurrentAssets;
    } // setOtherNonCurrentAssets

    /**
     * sets the value.
     * @param totalLiabilities the value to set.
     */
    public void setTotalLiabilities(Long totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    } // setTotalLiabilities

    /**
     * sets the value.
     * @param totalCurrentLiabilities the value to set.
     */
    public void setTotalCurrentLiabilities(Long totalCurrentLiabilities) {
        this.totalCurrentLiabilities = totalCurrentLiabilities;
    } // setTotalCurrentLiabilities

    /**
     * sets the value.
     * @param currentAccountsPayable the value to set.
     */
    public void setCurrentAccountsPayable(Long currentAccountsPayable) {
        this.currentAccountsPayable = currentAccountsPayable;
    } // setCurrentAccountsPayable

    /**
     * sets the value.
     * @param deferredRevenue the value to set.
     */
    public void setDeferredRevenue(Long deferredRevenue) {
        this.deferredRevenue = deferredRevenue;
    } // setDeferredRevenue

    /**
     * sets the value.
     * @param currentDebt the value to set.
     */
    public void setCurrentDebt(Long currentDebt) {
        this.currentDebt = currentDebt;
    } // setCurrentDebt

    /**
     * sets the value.
     * @param shortTermDebt the value to set.
     */
    public void setShortTermDebt(Long shortTermDebt) {
        this.shortTermDebt = shortTermDebt;
    } /// setShortTermDebt

    /**
     * sets the value.
     * @param totalNonCurrentLiabilities the value to set.
     */
    public void setTotalNonCurrentLiabilities(Long totalNonCurrentLiabilities) {
        this.totalNonCurrentLiabilities = totalNonCurrentLiabilities;
    } // setTotalNonCurrentLiabilities

    /**
     * sets the value.
     * @param capitalLeaseObligations the value to set.
     */
    public void setCapitalLeaseObligations(Long capitalLeaseObligations) {
        this.capitalLeaseObligations = capitalLeaseObligations;
    } // setCapitalLeaseObligations

    /**
     * sets the value.
     * @param longTermDebt the value to set.
     */
    public void setLongTermDebt(Long longTermDebt) {
        this.longTermDebt = longTermDebt;
    } // setLongTermDebt

    /**
     * sets the value.
     * @param currentLongTermDebt the value to set.
     */
    public void setCurrentLongTermDebt(Long currentLongTermDebt) {
        this.currentLongTermDebt = currentLongTermDebt;
    } // setCurrentLongTermDebt

    /**
     * sets the value.
     * @param longTermDebtNoncurrent the value to set.
     */
    public void setLongTermDebtNoncurrent(Long longTermDebtNoncurrent) {
        this.longTermDebtNoncurrent = longTermDebtNoncurrent;
    } // setLongTermDebtNoncurrent

    /**
     * sets the value.
     * @param shortLongTermDebtTotal the value to set.
     */
    public void setShortLongTermDebtTotal(Long shortLongTermDebtTotal) {
        this.shortLongTermDebtTotal = shortLongTermDebtTotal;
    } // setShortLongTermDebtTotal

    /**
     * sets the value.
     * @param otherCurrentLiabilities the value to set.
     */
    public void setOtherCurrentLiabilities(Long otherCurrentLiabilities) {
        this.otherCurrentLiabilities = otherCurrentLiabilities;
    } // setOtherCurrentLiabilities

    /**
     * sets the value.
     * @param otherNonCurrentLiabilities the value to set.
     */
    public void setOtherNonCurrentLiabilities(Long otherNonCurrentLiabilities) {
        this.otherNonCurrentLiabilities = otherNonCurrentLiabilities;
    } // setOtherNonCurrentLiabilities

    /**
     * sets the value.
     * @param totalShareholderEquity the value to set.
     */
    public void setTotalShareholderEquity(Long totalShareholderEquity) {
        this.totalShareholderEquity = totalShareholderEquity;
    } // setTotalShareholderEquity

    /**
     * sets the value.
     * @param treasuryStock the value to set.
     */
    public void setTreasuryStock(Long treasuryStock) {
        this.treasuryStock = treasuryStock;
    } // setTreasuryStock

    /**
     * sets the value.
     * @param retainedEarnings the value to set.
     */
    public void setRetainedEarnings(Long retainedEarnings) {
        this.retainedEarnings = retainedEarnings;
    } // setRetainedEarnings

    /**
     * sets the value.
     * @param commonStock the value to set.
     */
    public void setCommonStock(Long commonStock) {
        this.commonStock = commonStock;
    } // setCommonStock

    /**
     * sets the value.
     * @param commonStockSharesOutstanding the value to set.
     */
    public void setCommonStockSharesOutstanding(Long commonStockSharesOutstanding) {
        this.commonStockSharesOutstanding = commonStockSharesOutstanding;
    } // setCommonStockSharesOutstanding
} // BalanceSheetAnnualReport
