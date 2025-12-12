package cs1302.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a utility class for generating a mock balance sheet. This class is useful
 * for testing and development purposes where actual data retrieval is not necessary.
 */
public class MockBalanceSheet {

    /**
     * Generates a mock balance sheet for testing or demonstration purposes.
     * @return A {@link BalanceSheet} object filled with sample data.
     */
    public static BalanceSheet getMockBalanceSheet() {
        BalanceSheet balanceSheet = new BalanceSheet();
        balanceSheet.setSymbol("MO");
        List<BalanceSheetAnnualReport> reports = new ArrayList<>();
        BalanceSheetAnnualReport report2023 = new BalanceSheetAnnualReport();
        report2023.setFiscalDateEnding("2023-12-31");
        report2023.setReportedCurrency("USD");
        report2023.setTotalAssets(38570000000L);
        report2023.setTotalCurrentAssets(5585000000L);
        report2023.setCashAndCashEquivalentsAtCarryingValue(3686000000L);
        report2023.setCashAndShortTermInvestments(3686000000L);
        report2023.setInventory(1215000000L);
        report2023.setCurrentNetReceivables(71000000L);
        report2023.setTotalNonCurrentAssets(23004000000L);
        report2023.setPropertyPlantEquipment(1652000000L);
        report2023.setAccumulatedDepreciationAmortizationPPE(2930000000L);
        report2023.setIntangibleAssets(20477000000L);
        report2023.setIntangibleAssetsExcludingGoodwill(13686000000L);
        report2023.setGoodwill(6791000000L);
        report2023.setInvestments(10011000000L);
        report2023.setLongTermInvestments(10011000000L);
        report2023.setShortTermInvestments(-5000000L);
        report2023.setOtherCurrentAssets(117000000L);
        report2023.setOtherNonCurrentAssets(845000000L);
        report2023.setTotalLiabilities(42060000000L);
        report2023.setTotalCurrentLiabilities(11319000000L);
        report2023.setCurrentAccountsPayable(582000000L);
        report2023.setDeferredRevenue(258000000L);
        report2023.setCurrentDebt(1121000000L);
        report2023.setShortTermDebt(0L);
        report2023.setTotalNonCurrentLiabilities(30741000000L);
        report2023.setCapitalLeaseObligations(null);
        report2023.setLongTermDebt(26233000000L);
        report2023.setCurrentLongTermDebt(1121000000L);
        report2023.setLongTermDebtNoncurrent(25112000000L);
        report2023.setShortLongTermDebtTotal(26233000000L);
        report2023.setOtherCurrentLiabilities(9616000000L);
        report2023.setOtherNonCurrentLiabilities(1621000000L);
        report2023.setTotalShareholderEquity(-3540000000L);
        report2023.setTreasuryStock(38802000000L);
        report2023.setRetainedEarnings(31094000000L);
        report2023.setCommonStock(935000000L);
        report2023.setCommonStockSharesOutstanding(1763461775L);

        reports.add(report2023);
        balanceSheet.setAnnualReports(reports);
        return balanceSheet;
    } // getMockBalanceSheet
} // MockBalanceSheet
