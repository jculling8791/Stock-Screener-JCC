package cs1302.api;

import java.util.ArrayList;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * A service class for interacting with APIs to fetch financial data.
 */
public class ApiService {

    private static ApiService instance;
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();
    public boolean useMockData = true; // using mock data set for Balance Sheet & Income Statement
    private final String alphaVantageBaseUrl = "https://www.alphavantage.co/query";
    private final String stockDataBaseUrl = "https://api.stockdata.org/v1/data/quote";
    private final String alphaVantageApiKey = "CQ3874PRX46CHQYR";
    private final String stockDataApiKey = "TUsCclPdicKerPrDXzGnpEF7qGvKJBsnLnQZosES";

    /**
     * Returns the singleton instance of the ApiService class.
     *
     * @return the singleton instance of ApiService
     */
    public static ApiService getInstance() {
        if (instance == null) {
            synchronized (ApiService.class) {
                if (instance == null) {
                    instance = new ApiService();
                } // if
            } // synchronized
        } // if
        return instance;
    } // getInstance

    /**
     * Checks if the application is using mock data.
     *
     * @return true if using mock data, false otherwise
     */
    public boolean isUseMockData() {
        return useMockData;
    } // isUseMockData

    /**
     * Fetches data for the top gainers and losers from the API.
     *
     * @return a {@code TopGainersLosers} object containing data about the top gainers and losers
     * @throws IOException          if an I/O error occurs during the API call
     * @throws InterruptedException if the API call is interrupted
     * @throws URISyntaxException   if the API endpoint URI is malformed
     */
    public TopGainersLosers fetchTopGainersLosers()
        throws IOException, InterruptedException, URISyntaxException {
        if (useMockData) {
            return MockDataTopGainersLosers.getMockTopGainersLosers();
        } // if
        String endpoint = alphaVantageBaseUrl
            + "?function=TOP_GAINERS_LOSERS"
            + "&apikey=" + alphaVantageApiKey;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), TopGainersLosers.class);
    } // fetchTopGainersLosers

    /**
     * Fetches the income statement for a given symbol.
     * @param symbol the stock ticker symbol
     * @return IncomeStatement object populated with data
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the request is interrupted
     * @throws URISyntaxException   if the endpoint URI is invalid
     */
    public IncomeStatement fetchIncomeStatement(String symbol)
        throws IOException, InterruptedException, URISyntaxException {
        if (useMockData) {
            return MockIncomeStatement.getMockIncomeStatement();
        } // if Mock needed
        String endpoint = alphaVantageBaseUrl
            + "?function=INCOME_STATEMENT&symbol=" + symbol
            + "&apikey=" + alphaVantageApiKey;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Raw income statement JSON response: " + response.body());
        IncomeStatement incomeStatement = gson.fromJson(response.body(), IncomeStatement.class);
        if (incomeStatement.getAnnualReports() == null) {
            incomeStatement.setAnnualReports(new ArrayList<>());
            System.err.println("Daily Limit Reached :(");
        } // if null
        return incomeStatement;
    } // fetchIncomeStatement

    /**
     * Fetches the balance sheet for a given symbol.
     * @param symbol the stock ticker symbol
     * @return BalanceSheet object populated with data
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the request is interrupted
     * @throws URISyntaxException   if the endpoint URI is invalid
     */
    public BalanceSheet fetchBalanceSheet(String symbol)
        throws IOException, InterruptedException, URISyntaxException {
        if (useMockData) {
            return MockBalanceSheet.getMockBalanceSheet();
        } // if mock needed
        String endpoint = alphaVantageBaseUrl
            + "?function=BALANCE_SHEET&symbol=" + symbol
            + "&apikey=" + alphaVantageApiKey;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Raw balance sheet JSON response: " + response.body());
        BalanceSheet balanceSheet = gson.fromJson(response.body(), BalanceSheet.class);
        if (balanceSheet.getAnnualReports() == null) {
            balanceSheet.setAnnualReports(new ArrayList<>());
            System.err.println("Daily Limit Reached :(");
        } // if null
        return balanceSheet;
    } // fetchBalanceSheet

    /**
     * Fetches the current price details for a given stock symbol from the API.
     *
     * @param symbol the stock symbol for which to fetch the current price
     * @return a {@code CurrentPrice} object containing the current price details
     * @throws IOException          if an I/O error occurs during the API call
     * @throws InterruptedException if the API call is interrupted
     * @throws URISyntaxException   if the API endpoint URI is malformed
     */
    public CurrentPrice fetchCurrentPrice(String symbol)
        throws IOException, InterruptedException, URISyntaxException {
        String endpoint = stockDataBaseUrl
            + "?symbols=" + symbol
            + "&extended_hours=true"
            + "&api_token=" + stockDataApiKey;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(endpoint))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), CurrentPrice.class);
    } // fetchCurrentPrice

    /**
     * Retrieves the balance sheet annual report for a specific year.
     *
     * @param balanceSheet the BalanceSheet object containing annual reports
     * @param year         the year for which the balance sheet report is required
     * @return the BalanceSheetAnnualReport for the specified year, or {@code null} if not found
     */
    public BalanceSheetAnnualReport getBalanceSheetForYear(BalanceSheet balanceSheet, int year) {
        if (balanceSheet == null || balanceSheet.getAnnualReports() == null) {
            System.err.println("Daily Limit Reached :(");
            return null;
        } // if null
        for (BalanceSheetAnnualReport report : balanceSheet.getAnnualReports()) {
            if (report.getFiscalDateEnding() != null &&
                report.getFiscalDateEnding().startsWith(String.valueOf(year))) {
                return report;
            } // if the year in question
        } // for each AnnualReport
        System.err.println("No balance sheet found for year " + year);
        return null;
    } // getBalanceSheetForYear

    /**
     * Fetches the income statement report for a given year.
     *
     * @param incomeStatement the IncomeStatement object containing annual reports
     * @param year the year for which the income statement report is required
     * @return the IncomeStatementAnnualReport for the specified year, or null if not found
     */
    public IncomeStatementAnnualReport getIncomeStatementForYear(
        IncomeStatement incomeStatement, int year) {
        if (incomeStatement == null || incomeStatement.getAnnualReports() == null) {
            System.err.println("IncomeStatement or AnnualReports is null.");
            return null;
        } // if
        for (IncomeStatementAnnualReport report : incomeStatement.getAnnualReports()) {
            if (report.getFiscalDateEnding() != null &&
                report.getFiscalDateEnding().startsWith(String.valueOf(year))) {
                return report;
            } // if
        } // for

        System.err.println("No income statement found for year: " + year);
        return null;
    } // getIncomeStatementForYear

} // ApiService
