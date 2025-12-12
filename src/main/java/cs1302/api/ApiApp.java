package cs1302.api;

import java.util.Arrays;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.layout.ColumnConstraints;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Check DEADLINE.md Part 1.1 for my app description!
 */
public class ApiApp extends Application {
    Stage stage;
    Scene scene;
    VBox root;

    private final MockDataTopGainersLosers mockData = new MockDataTopGainersLosers();
    private final ApiService apiService = new ApiService();

    /**
     * Constructs an {@code ApiApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public ApiApp() {
        root = new VBox(10);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
    } // ApiApp

    /** {@inheritDoc} */
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setHgap(125);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 0, 0, 0));
        ColumnConstraints symbolColumn = new ColumnConstraints();
        symbolColumn.setHalignment(HPos.LEFT);
        ColumnConstraints priceColumn = new ColumnConstraints();
        priceColumn.setHalignment(HPos.CENTER);
        ColumnConstraints percentChangeColumn = new ColumnConstraints();
        percentChangeColumn.setHalignment(HPos.CENTER);
        ColumnConstraints volumeColumn = new ColumnConstraints();
        volumeColumn.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().addAll(symbolColumn, priceColumn,
                                           percentChangeColumn, volumeColumn);
        Text symbolHeader = new Text("Symbol");
        symbolHeader.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text volumeHeader = new Text("Volume");
        volumeHeader.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text percentChangeHeader = new Text("% Change Today");
        percentChangeHeader.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text priceHeader = new Text("Security Price");
        priceHeader.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        grid.add(symbolHeader, 0, 0);
        grid.add(priceHeader, 1, 0);
        grid.add(percentChangeHeader, 2, 0);
        grid.add(volumeHeader, 3, 0);
        TopGainersLosers topGainersLosers = MockDataTopGainersLosers.getMockTopGainersLosers();
        List<TopGainersLosers.TickerInfo> tickers = topGainersLosers.getMostActivelyTraded();
        tickers.sort((a, b) -> Long.compare(Long.parseLong(b.getVolume()),
                                            Long.parseLong(a.getVolume())));
        populateGridWithTickers(grid, tickers, primaryStage);
        Text titleText = new Text("Most Actively Traded on the Day:");
        titleText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        Text lastUpdatedText = new Text("(Last Updated " + topGainersLosers.getLastUpdated() + ")");
        lastUpdatedText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
        VBox textContainer = new VBox(1, titleText, lastUpdatedText);
        textContainer.setAlignment(Pos.TOP_CENTER);
        Text instructionsText = new Text(
            "Click on your desired symbol to see valuation on a new window. (Limit to 25 per day)");
        instructionsText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        VBox topContainer = new VBox(0, textContainer, grid, instructionsText);
        topContainer.setAlignment(Pos.TOP_CENTER);
        topContainer.setPadding(new Insets(0));
        topContainer.setStyle("-fx-background-color: white;");
        topContainer.prefWidthProperty().bind(primaryStage.widthProperty());
        grid.prefWidthProperty().bind(primaryStage.widthProperty());
        this.stage = primaryStage;
        Scene initialScene = new Scene(topContainer, 800, 600);
        primaryStage.setTitle("Stock Screener ");
        primaryStage.setScene(initialScene);
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> Platform.exit());
    } // start

    /**
     * Populates a grid with ticker information.
     *
     * @param grid         the {@code GridPane} to populate
     * @param tickers      the list of {@code TopGainersLosers.TickerInfo} objects to display
     * @param primaryStage the primary stage of the application
     */
    private void populateGridWithTickers(GridPane grid, List<TopGainersLosers.TickerInfo>
                                         tickers, Stage primaryStage) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        for (int i = 0; i < Math.min(tickers.size(), 20); i++) {
            TopGainersLosers.TickerInfo ticker = tickers.get(i);

            Label stockLabel = new Label(ticker.getTicker());
            stockLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
            stockLabel.setTextFill(Color.BLACK);
            stockLabel.setUnderline(true);
            stockLabel.setOnMouseClicked(e -> {
                showForecastingFinancialStatements(primaryStage, ticker);
            });
            grid.add(stockLabel, 0, i + 1); // Column 0, Row (i+1)
            double price = Double.parseDouble(ticker.getPrice());
            double changeAmount = Double.parseDouble(ticker.getChangeAmount());
            double changePercentage = Double.parseDouble(ticker.
                                                         getChangePercentage().replace("%", ""));
            Color textColor = (changeAmount < 0) ? Color.RED : Color.GREEN;
            String priceWithChange = String.format("%.2f (%+.2f)", price, changeAmount);
            Label priceLabel = new Label(priceWithChange);
            priceLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
            priceLabel.setTextFill(textColor);
            grid.add(priceLabel, 1, i + 1);
            String percentChange = String.format("%+.2f%%", changePercentage);
            Label percentChangeLabel = new Label(percentChange);
            percentChangeLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
            percentChangeLabel.setTextFill(textColor);
            grid.add(percentChangeLabel, 2, i + 1);

            String formattedVolume = numberFormat.format(Long.parseLong(ticker.getVolume()));
            Label volumeLabel = new Label(formattedVolume);
            volumeLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
            volumeLabel.setTextFill(Color.BLACK);
            grid.add(volumeLabel, 3, i + 1);
        } // for i
    } // populateGridWithTickers

    /**
     * Displays the valuation window for a specific ticker.
     *
     * @param owner  the owner stage for the valuation window
     * @param ticker the {@code TopGainersLosers.TickerInfo} object representing the ticker
     */
    public void showValuationWindow(Stage owner, TopGainersLosers.TickerInfo ticker) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(owner);
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Text stockTitle = new Text("Loading stock data...");
        stockTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        HBox titleBox = new HBox(10, stockTitle);
        VBox.setVgrow(titleBox, Priority.NEVER);
        VBox valuationContainer = new VBox(10);
        setupValuationBoxes(valuationContainer);
        VBox.setVgrow(valuationContainer, Priority.ALWAYS);
        root.getChildren().addAll(titleBox, valuationContainer);
        Task<CurrentPrice> fetchPriceTask = new Task<CurrentPrice>() {
                @Override
                protected CurrentPrice call() throws Exception {
                    return apiService.fetchCurrentPrice(ticker.getTicker());
                } // call()
            }; // fetchPriceTask
        fetchPriceTask.setOnSucceeded(event -> {
            CurrentPrice currentPrice = fetchPriceTask.getValue();
            CurrentPriceDetails details = currentPrice.getData()[0];
            Platform.runLater(() -> {
                stockTitle.setText(details.getName() + " (" +
                                   details.getTicker() + ") - $" + details.getPrice());
            }); // seperate thread
        }); // fetchPriceTask
        handleTaskFailure(fetchPriceTask);
        new Thread(fetchPriceTask).start();
        Scene scene = new Scene(root, 800, 600);
        newStage.setScene(scene);
        newStage.setTitle("Valuation Details for " + ticker.getTicker());
        newStage.showAndWait();
    } // showValuationWindow

    /**
     * Displays the Forecasting Financial Statements window for a specific ticker.
     * The window includes the Forecasted Income Statement, Balance Sheet, and FCF/EVA
     * grid panes side by side, along with input fields for sales growth projections
     * and navigation buttons.
     *
     * @param owner the {@link Stage} representing the parent stage of the new window.
     * @param ticker the {@link TopGainersLosers.TickerInfo} object representing the
     *               selected stock ticker to display information for.
     */
    private void showForecastingFinancialStatements(Stage owner, TopGainersLosers.TickerInfo
                                                    ticker) {
        ForecastingFinancialStatements forecastingStatements = new
            ForecastingFinancialStatements(this);
        // forecastingStatements.setSalesGrowthRates(growthRates);
        forecastingStatements.showForecastingFinancialStatementsWindow(owner, ticker);
        Button goToValuationsButton = new Button("Go to Valuations");
        goToValuationsButton.setOnAction(event -> showValuationWindow(owner, ticker));
    } // showForecastingFinancialStatementsWindow

    /**
     * Sets up valuation boxes in the given container.
     *
     * @param valuationContainer the {@code VBox} container to populate with valuation boxes
     */
    private void setupValuationBoxes(VBox valuationContainer) {
        String[] titles = {
            "EVA Valuation Approach: (Enterprise Value)",
            "FCF Valuation Approach: (Enterprise Value)",
            "DDM Valuation Approach: (Market Value of Equity)"
        };  // titles
        for (String title : titles) {
            Text titleText = new Text(title);
            titleText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
            HBox hbox = new HBox(titleText);
            hbox.setMinHeight(60);
            VBox.setVgrow(hbox, Priority.ALWAYS);
            valuationContainer.getChildren().add(hbox);
        } // for i
    } // setupValuationBoxes

    /**
     * Displays the assumptions window for a specific ticker.
     *
     * @param owner  the owner stage for the assumptions window
     * @param ticker the {@code TopGainersLosers.TickerInfo} object representing the ticker
     */
    public void displayAssumptions(Stage owner, TopGainersLosers.TickerInfo ticker) {
        Task<Void> loadAndDisplayTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    Map<String, Double> mockData = Assumptions.getData();

                    double cogsToSalesRatio = mockData.getOrDefault("cogsToSalesRatio", Double.NaN);
                    double sgaToSalesRatio = mockData.getOrDefault("sgaToSalesRatio", Double.NaN);
                    double nonOperatingIncomeRatio = mockData.getOrDefault(
                        "nonOperatingIncomeRatio", Double.NaN);
                    double depreciationToNetPPERatio = mockData.getOrDefault(
                        "depreciationToNetPPERatio", Double.NaN);
                    double interestExpenseToDebtRatio = mockData.getOrDefault(
                        "interestExpenseToDebtRatio", Double.NaN);
                    double taxRate = mockData.getOrDefault("taxRate", Double.NaN);
                    double netPpeToSalesRatio = mockData.getOrDefault(
                        "netPpeToSalesRatio", Double.NaN);
                    double totalAssetsToSalesRatio = mockData.getOrDefault(
                        "totalAssetsToSalesRatio", Double.NaN);
                    double operatingLiabilitiesRatio = mockData.getOrDefault(
                        "operatingLiabilitiesRatio", Double.NaN);
                    double totalDebtRatio = mockData.getOrDefault("totalDebtRatio", Double.NaN);
                    double commonEquityRatio = mockData.getOrDefault(
                        "commonEquityRatio", Double.NaN);
                    double riskFreeRate = mockData.getOrDefault("riskFreeRate", Double.NaN);
                    double beta = mockData.getOrDefault("beta", Double.NaN);
                    double marketRiskPremium = mockData.getOrDefault(
                        "marketRiskPremium", Double.NaN);

                    Platform.runLater(() -> setupAssumptionsWindow(owner, root, ticker,
                                                                   cogsToSalesRatio,
                                                                   sgaToSalesRatio,
                                                                   nonOperatingIncomeRatio,
                                                                   depreciationToNetPPERatio,
                                                                   interestExpenseToDebtRatio,
                                                                   taxRate, netPpeToSalesRatio,
                                                                   totalAssetsToSalesRatio,
                                                                   operatingLiabilitiesRatio,
                                                                   totalDebtRatio,
                                                                   commonEquityRatio, riskFreeRate,
                                                                   beta, marketRiskPremium));
                    return null;
                } // call
            }; // loadAndDisplayTask
        handleTaskFailure(loadAndDisplayTask);
        new Thread(loadAndDisplayTask).start();
        //assumptionsStage.setScene(scene);
        //assumptionsStage.showAndWait();
    } // displayAssumptions

    /**
     * Handles the failure of a background task.
     *
     * @param task the {@code Task} that failed
     */
    private void handleTaskFailure(Task<?> task) {
        task.setOnFailed(event -> {
            Throwable error = task.getException();
            String errorMessage = (error != null) ? error.getMessage() :
                "Error occurred";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Task Failure");
            alert.setHeaderText("Failed to Load Assumptions");
            alert.setContentText("Error Details: " + errorMessage);
            alert.showAndWait();
        }); // setOnFailed
    } // handleTaskFailure

    /**
     * Sets up the assumptions window with various parameters.
     *
     * @param owner                      the owner stage for the window
     * @param root                       the root {@code VBox} for the window
     * @param ticker                     the {@code TopGainersLosers.TickerInfo} object
     * @param cogsToSalesRatio           the COGS to Sales ratio
     * @param sgaToSalesRatio            the SG&A to Sales ratio
     * @param nonOperatingIncomeRatio    the Non-Operating Income to Sales ratio
     * @param depreciationToNetPPERatio  the Depreciation to Net PPE ratio
     * @param interestExpenseToDebtRatio the Interest Expense to Debt ratio
     * @param taxRate                    the tax rate
     * @param netPpeToSalesRatio         the Net PPE to Sales ratio
     * @param totalAssetsToSalesRatio    the Total Assets to Sales ratio
     * @param operatingLiabilitiesRatio  the Operating Liabilities to Sales ratio
     * @param totalDebtRatio             the Total Debt ratio
     * @param commonEquityRatio          the Common Equity ratio
     * @param riskFreeRate               the risk-free rate
     * @param beta                       the beta coefficient
     * @param marketRiskPremium          the market risk premium
     */
    private void setupAssumptionsWindow(Stage owner, VBox root, TopGainersLosers.TickerInfo ticker,
                                        double cogsToSalesRatio, double sgaToSalesRatio,
                                        double nonOperatingIncomeRatio,
                                        double depreciationToNetPPERatio,
                                        double interestExpenseToDebtRatio,
                                        double taxRate, double netPpeToSalesRatio,
                                        double totalAssetsToSalesRatio,
                                        double operatingLiabilitiesRatio, double totalDebtRatio,
                                        double commonEquityRatio,
                                        double riskFreeRate, double beta,
                                        double marketRiskPremium) {
        VBox mainContainer = new VBox(10);
        mainContainer.setAlignment(Pos.TOP_LEFT);
        mainContainer.setPadding(new Insets(20));
        mainContainer.getChildren().addAll(
            constructISAssumptions(cogsToSalesRatio, sgaToSalesRatio, nonOperatingIncomeRatio,
                                   depreciationToNetPPERatio, interestExpenseToDebtRatio, taxRate),
            constructBSAssumptions(netPpeToSalesRatio, totalAssetsToSalesRatio,
                                   operatingLiabilitiesRatio, totalDebtRatio, commonEquityRatio),
            constructCAPM(riskFreeRate, beta, marketRiskPremium)
        ); // addingAll children
        setupNewWindow(owner, "Assumptions for " + ticker.getTicker(), mainContainer);
    } // setupAssumptionsWindow

    /**
     * Constructs a {@code VBox} containing income statement assumptions.
     *
     * @param cogsToSalesRatio           the COGS to Sales ratio
     * @param sgaToSalesRatio            the SG&A to Sales ratio
     * @param nonOperatingIncomeRatio    the Non-Operating Income to Sales ratio
     * @param depreciationToNetPPERatio  the Depreciation to Net PPE ratio
     * @param interestExpenseToDebtRatio the interest expense to debt ratio
     * @param taxRate                    the tax rate
     * @return a {@code VBox} containing income statement assumptions
     */
    private VBox constructISAssumptions(double cogsToSalesRatio, double sgaToSalesRatio,
                                        double nonOperatingIncomeRatio,
                                        double depreciationToNetPPERatio,
                                        double interestExpenseToDebtRatio, double taxRate) {
        VBox isBox = new VBox(5);
        Text isTitle = new Text("I/S Assumptions");
        isTitle.setUnderline(true);
        isTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        Text isAsPercentageOfSales = new Text("As a Percentage of Sales");
        isAsPercentageOfSales.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        Text percentageOfNetPPE = new Text("As a Percentage of Net P&E (t-1)");
        percentageOfNetPPE.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        Text percentageOfDebt = new Text ("As a Percentage of Debt (t-1)");
        percentageOfDebt.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        isBox.getChildren().addAll(
            isTitle,
            isAsPercentageOfSales,
            createAssumptionLabel("Cost of Goods Sold:", cogsToSalesRatio),
            createAssumptionLabel("Selling, General and Administrative Expense:", sgaToSalesRatio),
            createAssumptionLabel("Nonoperating Income:", nonOperatingIncomeRatio),
            percentageOfNetPPE,
            createAssumptionLabel("Depreciation and Amortization:", depreciationToNetPPERatio),
            percentageOfDebt,
            createAssumptionLabel("Interest and Related Expense - Total:",
                                  interestExpenseToDebtRatio),
            createAssumptionLabelBold("Tax Rate:", taxRate)
        );
        return isBox;
    } // contructISAssumptions

    /**
     * Constructs a {@code VBox} containing balance sheet assumptions.
     *
     * @param netPpeToSalesRatio        the Net PPE to Sales ratio
     * @param totalAssetsToSalesRatio   the Total Assets to Sales ratio
     * @param operatingLiabilitiesRatio the Operating Liabilities to Sales ratio
     * @param totalDebtRatio            the Total Debt ratio
     * @param commonEquityRatio         the Common Equity ratio
     * @return a {@code VBox} containing balance sheet assumptions
     */
    private VBox constructBSAssumptions(double netPpeToSalesRatio, double totalAssetsToSalesRatio,
                                        double operatingLiabilitiesRatio, double totalDebtRatio,
                                        double commonEquityRatio) {
        VBox bsBox = new VBox(5);
        Text bsTitle = new Text("B/S Assumptions");
        bsTitle.setUnderline(true);
        bsTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        Text bsAsPercentageOfSales = new Text("As a Percentage of Sales");
        bsAsPercentageOfSales.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        Text bsAsPercentageOfCapital = new Text("As a Percentage of Investor Supplied Capital");
        bsAsPercentageOfCapital.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        bsBox.getChildren().addAll(
            bsTitle,
            bsAsPercentageOfSales,
            createAssumptionLabel("Property, Plant and Equipment - Total (Net):",
                                  netPpeToSalesRatio),
            createAssumptionLabel("Total Assets:", totalAssetsToSalesRatio),
            createAssumptionLabel("Operating Liabilities (Current + LT + NonControlling):",
                                  operatingLiabilitiesRatio),
            bsAsPercentageOfCapital,
            createAssumptionLabel("Total Debt:", totalDebtRatio),
            createAssumptionLabel("Common Equity:", commonEquityRatio)
        );
        return bsBox;
    } // constructBSAssumptions

    /**
     * Constructs a {@code VBox} containing CAPM (Capital Asset Pricing Model) assumptions.
     *
     * @param riskFreeRate      the risk-free rate
     * @param beta              the beta coefficient
     * @param marketRiskPremium the market risk premium
     * @return a {@code VBox} containing CAPM assumptions
     */
    private VBox constructCAPM(double riskFreeRate, double beta, double marketRiskPremium) {
        VBox capmBox = new VBox(5);
        Text capmTitle = new Text("CAPM");
        capmTitle.setUnderline(true);
        capmTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        capmBox.getChildren().addAll(
            capmTitle,
            createAssumptionLabel("Risk-Free Rate:", riskFreeRate),
            createAssumptionLabelWithoutPercent("Beta:", beta),
            createAssumptionLabel("Market Risk Premium:", marketRiskPremium)
        );
        return capmBox;
    } // constructCAPM

    /**
     * Creates an {@code HBox} displaying an assumption with a percentage value.
     *
     * @param text  the label text
     * @param value the assumption value
     * @return an {@code HBox} containing the assumption label and value
     */
    private HBox createAssumptionLabel(String text, double value) {
        Label labelText = new Label(text);
        labelText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 14));
        Text valueText = new Text(String.format("%.2f%%", value * 100));
        valueText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 14));
        valueText.setUnderline(true);
        HBox hbox = new HBox(labelText, new Region(), valueText);
        HBox.setHgrow(hbox.getChildren().get(1), Priority.ALWAYS);
        return hbox;
    } // createAssumptionLabel

    /**
     * Creates an {@code HBox} displaying an assumption with bold styling and a percentage value.
     *
     * @param text  the label text
     * @param value the assumption value
     * @return an {@code HBox} containing the assumption label with bold styling
     */
    private HBox createAssumptionLabelBold(String text, double value) {
        Text labelText = new Text(text);
        labelText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text valueText = new Text(String.format("%.2f%%", value * 100));
        valueText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 14));
        valueText.setUnderline(true);
        HBox hbox = new HBox(labelText, new Region(), valueText);
        HBox.setHgrow(hbox.getChildren().get(1), Priority.ALWAYS);
        return hbox;
    } // createAssumptionLabelBold

    /**
     * Creates an {@code HBox} displaying an assumption without a percentage value.
     *
     * @param text  the label text
     * @param value the assumption value
     * @return an {@code HBox} containing the assumption label and value without a percentage
     */
    private HBox createAssumptionLabelWithoutPercent(String text, double value) {
        Label labelText = new Label(text);
        labelText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 14));
        Text valueText = new Text(String.format("%.2f", value));
        valueText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 14));
        valueText.setUnderline(true);
        HBox hbox = new HBox(labelText, new Region(), valueText);
        HBox.setHgrow(hbox.getChildren().get(1), Priority.ALWAYS);
        return hbox;
    } // createAssumptionLabelWithoutPercent

    /**
     * Sets up a new window with the specified content.
     *
     * @param owner  the owner stage for the new window
     * @param title  the title of the new window
     * @param content the content to display in the window
     */
    private void setupNewWindow(Stage owner, String title, Node content) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(owner);
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().add(content);
        Scene scene = new Scene(root, 800, 600);
        newStage.setScene(scene);
        newStage.setTitle(title + " ");
        newStage.show();
    } // setupNewWindow


    /**
    private void showGrowthRatesInputWindow(Stage owner, TopGainersLosers.TickerInfo ticker) {
        //String tickerSymbol = ticker.getTicker();
        //SalesGrowthInput input = getUserInputForTicker(tickerSymbol);
        growthRatesStage.initOwner(owner);
        growthRatesStage.initModality(Modality.APPLICATION_MODAL);
        growthRatesStage.setTitle("Enter Sales Growth Rates for " + ticker.getTicker());
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        for (int year = 2024; year <= 2028; year++) {
            int col = year - 2024;
            TextField inputField = new TextField();
            inputField.setPromptText("XX.XX%");

            inputField.setOnAction(event -> {
                    try {
                        double value = Double.parseDouble(inputField.getText().replace("%", ""));
                        //              input.setGrowthRate(year, value);
                        System.out.println("Updated growth rate for " + year + ": " + value);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input for " + year);
                    }
                });

            grid.add(inputField, col, 0);
        }

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(event -> {
                growthRatesStage.close();
                showForecastingFinancialStatementsWindow(owner, ticker);
            });

        VBox root = new VBox(10, grid, confirmButton);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 400, 200);
        growthRatesStage.setScene(scene);
        growthRatesStage.showAndWait();
    } // showGrowthRatesInputWindow
    */

    /**
    private SalesGrowthInput getUserInputForTicker(String ticker) {
        return userInputs.computeIfAbsent(ticker, k -> new SalesGrowthInput());
    } // getUserInputForTicker
    */

} // ApiApp
