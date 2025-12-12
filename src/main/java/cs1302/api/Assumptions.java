package cs1302.api;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class for calculating financial assumptions and ratios.
 */
public class Assumptions {

    private static final double TERMINAL_SALES = 0.03;
    private static final double RISK_FREE_RATE = 0.04;
    private static final double BETA = 1.28;
    private static final double MARKET_RISK_PREMIUM = 0.05;
    private static final double TAX_RATE = 0.0991;
    private static final double DEBT_CAPITAL_RATIO = 0.30;
    private static final double EQUITY_CAPITAL_RATIO = 0.70;
    private static final int YEARS = 5;
    private static final double COGS_TO_SALES_RATIO = 0.264;
    private static final double SG_A_TO_SALES_RATIO = 0.118;
    private static final double NON_OPERATING_INCOME_RATIO = 0.05;
    private static final double DEPRECIATION_TO_NET_PPE_RATIO = 0.10;
    private static final double INTEREST_EXPENSE_TO_DEBT_RATIO = 0.08;
    private static final double NET_PPE_TO_SALES_RATIO = 1.7915;
    private static final double TOTAL_ASSETS_TO_SALES_RATIO = 3.5327;
    private static final double OPERATING_LIABILITIES_TO_SALES_RATIO = 0.6691;

    /**
     * Retrieves the risk-free rate assumption, typically representing the return
     * of a risk-free investment.
     *
     * @return the risk-free rate as a percentage (e.g., 0.03 for 3%).
     */
    public static double getRiskFreeRate() {
        return RISK_FREE_RATE;
    } // getRiskFreeRate

    /**
     * Retrieves the beta value, which measures the volatility of a stock compared to the market.
     *
     * @return the beta value as a double.
     */
    public static double getBeta() {
        return BETA;
    } // getBeta

    /**
     * Retrieves the market risk premium, which represents the expected excess return of the market
     * minus the risk-free rate.
     *
     * @return the market risk premium as a percentage (e.g., 0.05 for 5%).
     */
    public static double getMarketRiskPremium() {
        return MARKET_RISK_PREMIUM;
    } // getMarketRiskPremium

    /**
     * Retrieves the cost of goods sold (COGS) to sales ratio, which represents the proportion
     * of sales used for producing goods.
     *
     * @return the COGS to sales ratio as a decimal (e.g., 0.25 for 25%).
     */
    public static double getCogsToSalesRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return COGS_TO_SALES_RATIO;
            //} // if
        //return calculateCOGStoSalesRatio();
    } // getCogsToSalesRatio

    /**
     * Retrieves the selling, general, and administrative (SG&A) expenses to sales ratio,
     * which represents the proportion of sales allocated to operational expenses.
     *
     * @return the SG&A to sales ratio as a decimal (e.g., 0.10 for 10%).
     */
    public static double getSgaToSalesRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return SG_A_TO_SALES_RATIO;
            //} // if
        // return calculateSgaToSalesRatio;
    } // getSgaToSalesRatio

    /**
     * Retrieves the non-operating income to sales ratio, which represents the proportion of sales
     * derived from non-operating income.
     *
     * @return the non-operating income to sales ratio as a decimal (e.g., 0.05 for 5%).
     */
    public static double getNonOperatingIncomeRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return NON_OPERATING_INCOME_RATIO;
            //} // if
        // return calculateNonOperatingIncomeRatio();
    } // getNonOperatingIncomeRatio

    /**
     * Retrieves the depreciation to net property, plant, and equipment (Net PPE) ratio,
     * which represents the proportion of depreciation relative to Net PPE.
     *
     * @return the depreciation to Net PPE ratio as a decimal (e.g., 0.10 for 10%).
     */
    public static double getDepreciationToNetPpeRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return DEPRECIATION_TO_NET_PPE_RATIO;
            //} // if
        // return calculateDepreciationToNetPpeRatio();
    } // getDepreciationToNetPpeRatio

    /**
     * Retrieves the interest expense to debt ratio, which represents the proportion of interest
     * expenses relative to total debt.
     *
     * @return the interest expense to debt ratio as a decimal (e.g., 0.08 for 8%).
     */
    public static double getInterestExpenseToDebtRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return INTEREST_EXPENSE_TO_DEBT_RATIO;
            //} // if
        //return calculateInterestExpenseToDebtRatio();
    } // getInterestExpenseToDebtRatio

    /**
     * Retrieves the net property, plant, and equipment (Net PPE) to sales ratio,
     * which represents the proportion of sales allocated to Net PPE.
     *
     * @return the Net PPE to sales ratio as a decimal (e.g., 0.15 for 15%).
     */
    public static double getNetPPEtoSalesRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return NET_PPE_TO_SALES_RATIO;
            // } // if
        //return calculateNetPPEtoSalesRatio;
    } // getNetPPEtoSalesRatio

    /**
     * Retrieves the total assets to sales ratio, which represents the proportion of sales
     * allocated to total assets.
     *
     * @return the total assets to sales ratio as a decimal (e.g., 0.50 for 50%).
     */
    public static double getTotalAssetsToSalesRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return TOTAL_ASSETS_TO_SALES_RATIO;
            //} // if
        //return calculateTotalAssetsToSalesRatio;
    } // getTotalAssetsToSalesRatio

    /**
     * Retrieves the operating liabilities to sales ratio, which represents the proportion of sales
     * allocated to operating liabilities.
     *
     * @return the operating liabilities to sales ratio as a decimal (e.g., 0.30 for 30%).
     */
    public static double getOperatingLiabilitiesRatio() {
        //if (ApiService.getInstance().isUseMockData()) {
        return OPERATING_LIABILITIES_TO_SALES_RATIO;
            //} // if
        //return calculateOperatingLiabilitiesToSalesRatio;
    } // getOperatingLiabilitiesRatio

    /**
     * Calculates the average of an array of values.
     *
     * @param values an array of double values
     * @return the average value
     */
    private static double calculateAverage(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        } // for each
        return sum / values.length;
    } // calculateAverage

    /**
     * Calculates the Cost of Goods Sold (COGS) to Sales ratio.
     *
     * @param cogs  an array of COGS values
     * @param sales an array of sales values
     * @return the COGS to Sales ratio
     */
    public static double calculateCOGStoSalesRatio(double[] cogs, double[] sales) {
        double[] ratios = new double[cogs.length];
        for (int i = 0; i < cogs.length; i++) {
            ratios[i] = cogs[i] / sales[i];
        } // for i
        return calculateAverage(ratios);
    } // calculateCOGStoSalesRatio

     /**
     * Calculates the Non-Operating Income to Sales ratio.
     *
     * @param sga an array of SG&A values
     * @param sales              an array of sales values
     * @return the SG&A to Sales ratio
     */
    public static double calculateSGAtoSalesRatio(double[] sga, double[] sales) {
        double[] ratios = new double[sga.length];
        for (int i = 0; i < sga.length; i++) {
            ratios[i] = sga[i] / sales[i];
        } // for i
        return calculateAverage(ratios);
    } // calculateSGAtoSalesRatio

     /**
     * Calculates the Non-Operating Income to Sales ratio.
     *
     * @param nonOperatingIncome an array of non-operating income values
     * @param sales              an array of sales values
     * @return the Non-Operating Income to Sales ratio
     */
    public static double calculateNonOperatingIncomeToSalesRatio(
        double[] nonOperatingIncome, double[] sales) {
        double[] ratios = new double[nonOperatingIncome.length];
        for (int i = 0; i < nonOperatingIncome.length; i++) {
            ratios[i] = nonOperatingIncome[i] / sales[i];
        } // for i
        return calculateAverage(ratios);
    } // calculateNonOperatingIncomeToSalesRatio

     /**
     * Calculates the Depreciation to Net Property, Plant, and Equipment (PPE) ratio.
     *
     * @param depreciation an array of depreciation values
     * @param netPPE       an array of net PPE values
     * @return the Depreciation to Net PPE ratio
     */
    public static double calculateDepreciationToNetPPE(double[] depreciation, double[] netPPE) {
        if (depreciation == null || netPPE == null || depreciation.length == 0
            || netPPE.length == 0 || depreciation.length != netPPE.length) {
            throw new IllegalArgumentException("Arrays cannot be null");
        } // if
        double[] ratios = new double[depreciation.length - 1];
        for (int i = 1; i < depreciation.length; i++) {
            if (netPPE[i - 1] == 0) {
                throw new IllegalArgumentException("Net PP&E for the previous year cannot be zero");
            } // if 0
            ratios[i - 1] = depreciation[i] / netPPE[i - 1]; // Use Net PP&E from the previous year
        } // for i
        return calculateAverage(ratios);
    } // calculateDepreciationToNetPPE

    /**
     * Calculates the Interest Expense to Debt ratio.
     *
     * @param interestExpense an array of interest expense values
     * @param debt            an array of debt values
     * @return the Interest Expense to Debt ratio
     */
    public static double calculateInterestExpenseToDebtRatio(
        double[] interestExpense, double[] debt) {
        if (interestExpense == null || debt == null || interestExpense.length == 0
            || debt.length == 0 || interestExpense.length != debt.length) {
            throw new IllegalArgumentException("Arrays cannot be null");
        } // if

        double[] ratios = new double[interestExpense.length - 1];
        for (int i = 1; i < interestExpense.length; i++) {
            if (debt[i - 1] == 0) {
                throw new IllegalArgumentException("Debt for the previous year cannot be zero");
            } // if 0
            ratios[i - 1] = interestExpense[i] / debt[i - 1]; // Use debt from the previous year
        } // for i
        return calculateAverage(ratios);
    } // calculateInterestExpenseToDebtRatio

    /**
     * Calculates the Net Property, Plant, and Equipment (PPE) to Sales ratio.
     *
     * @param netPPE an array of net PPE values
     * @param sales  an array of sales values
     * @return the Net PPE to Sales ratio
     */
    public static double calculateNetPPEToSalesRatio(double[] netPPE, double[] sales) {
        double[] ratios = new double[netPPE.length];
        for (int i = 0; i < netPPE.length; i++) {
            ratios[i] = netPPE[i] / sales[i];
        } // for i
        return calculateAverage(ratios);
    } // calculateNetPPEToSalesRatio

    /**
     * Calculates the Total Assets to Sales ratio.
     *
     * @param totalAssets an array of total asset values
     * @param sales       an array of sales values
     * @return the Total Assets to Sales ratio
     */
    public static double calculateTotalAssetsToSalesRatio(double[] totalAssets, double[] sales) {
        double[] ratios = new double[totalAssets.length];
        for (int i = 0; i < totalAssets.length; i++) {
            ratios[i] = totalAssets[i] / sales[i];
        } // for i
        return calculateAverage(ratios);
    } // calculateTotalAssetsToSalesRatio

    /**
     * Calculates the Operating Liabilities to Sales ratio.
     *
     * @param operatingLiabilities an array of operating liability values
     * @param sales                an array of sales values
     * @return the Operating Liabilities to Sales ratio
     */
    public static double calculateOperatingLiabilitiesToSalesRatio(
        double[] operatingLiabilities, double[] sales) {
        double[] ratios = new double[operatingLiabilities.length];
        for (int i = 0; i < operatingLiabilities.length; i++) {
            ratios[i] = operatingLiabilities[i] / sales[i];
        } // for i
        return calculateAverage(ratios);
    } // calculateOperatingLiabilitiesToSalesRatio

    /**
     * Gets the tax rate.
     *
     * @return the tax rate as a double
     */
    public static double getTaxRate() {
        return TAX_RATE;
    } // getTaxRate

    /**
     * Gets the Debt to Capital ratio.
     *
     * @return the Debt to Capital ratio as a double
     */
    public static double getDebtCapitalRatio() {
        return DEBT_CAPITAL_RATIO;
    } // getDebtCapitalRatio

    /**
     * Gets the Equity to Capital ratio.
     *
     * @return the Equity to Capital ratio as a double
     */
    public static double getEquityCapitalRatio() {
        return EQUITY_CAPITAL_RATIO;
    } // getEquityCapitalRatio

    /**
     * Generates and returns mock data for financial assumptions.
     *
     * @return a map where keys are assumption names and values
     * are their corresponding ratios or values
     */
    public static Map<String, Double> getData() {
        Map<String, Double> mockData = new HashMap<>();
        mockData.put("cogsToSalesRatio", getCogsToSalesRatio());
        mockData.put("sgaToSalesRatio", getSgaToSalesRatio());
        mockData.put("nonOperatingIncomeRatio", getNonOperatingIncomeRatio());
        mockData.put("depreciationToNetPPERatio", getDepreciationToNetPpeRatio());
        mockData.put("interestExpenseToDebtRatio", getInterestExpenseToDebtRatio());
        mockData.put("taxRate", getTaxRate());
        mockData.put("netPpeToSalesRatio", getNetPPEtoSalesRatio());
        mockData.put("totalAssetsToSalesRatio", getTotalAssetsToSalesRatio());
        mockData.put("operatingLiabilitiesRatio", getOperatingLiabilitiesRatio());
        mockData.put("totalDebtRatio", getDebtCapitalRatio());
        mockData.put("commonEquityRatio", getEquityCapitalRatio());
        mockData.put("riskFreeRate", getRiskFreeRate());
        mockData.put("beta", getBeta());
        mockData.put("marketRiskPremium", getMarketRiskPremium());
        return mockData;
    } // getMockData

    /**
     * Gets the terminal sales growth rate (e.g., Q3 2024 US GDP Growth Rate).
     * @return the terminal sales growth rate as a percentage.
     */
    public static double getTerminalSalesGrowth() {
        return TERMINAL_SALES;
    } // getTerminalSalesGrowth
} // Assumptions
