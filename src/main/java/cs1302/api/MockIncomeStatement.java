package cs1302.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a utility class for generating a mock income statement. This class is useful
 * for testing and development purposes where actual data retrieval is not necessary.
 */
public class MockIncomeStatement {

    /**
     * Generates a mock income statement for testing or demonstration purposes.
     *
     * @return An {@link IncomeStatement} object filled with sample data.
     */
    public static IncomeStatement getMockIncomeStatement() {
        IncomeStatement incomeStatement = new IncomeStatement();
        incomeStatement.setSymbol("MO");
        List<IncomeStatementAnnualReport> reports = new ArrayList<>();
        IncomeStatementAnnualReport report2023 = new IncomeStatementAnnualReport();
        report2023.setFiscalDateEnding("2023-12-31");
        report2023.setReportedCurrency("USD");
        report2023.setGrossProfit(14284000000L);
        report2023.setTotalRevenue(23494000000L);
        report2023.setCostOfRevenue(10200000000L);
        report2023.setCostOfGoodsAndServicesSold(6218000000L);
        report2023.setOperatingIncome(11547000000L);
        report2023.setSellingGeneralAndAdministrative(2768000000L);
        report2023.setResearchAndDevelopment(220000000L);
        report2023.setOperatingExpenses(348000000L);
        report2023.setInvestmentIncomeNet(null);
        report2023.setNetInterestIncome(-989000000L);
        report2023.setInterestIncome(160000000L);
        report2023.setInterestExpense(1149000000L);
        report2023.setDepreciation(144000000L);
        report2023.setDepreciationAndAmortization(128000000L);
        report2023.setIncomeBeforeTax(10928000000L);
        report2023.setIncomeTaxExpense(2798000000L);
        report2023.setNetIncomeFromContinuingOperations(8130000000L);
        report2023.setComprehensiveIncomeNetOfTax(8228000000L);
        report2023.setEbit(12077000000L);
        report2023.setEbitda(12205000000L);
        report2023.setNetIncome(8130000000L);

        reports.add(report2023);
        incomeStatement.setAnnualReports(reports);
        return incomeStatement;
    } // getMockIncomeStatement
} // mockIncomeStatement
