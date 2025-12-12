package cs1302.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import javafx.scene.Node;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Represents the forecasting financial statements window, which displays the income statement,
 * balance sheet, and FCF/EVA grid panes for a selected ticker. This class handles the creation
 * and population of these grid panes with editable fields and calculations.
 */
public class ForecastingFinancialStatements {

    ApiService apiService = new ApiService();
    IncomeStatement incomeStatement = null;
    IncomeStatementAnnualReport incomeStatement2023 = null;
    BalanceSheet balanceSheet = null;
    BalanceSheetAnnualReport balanceSheet2023 = null;
    Assumptions assumptions = new Assumptions();
    double totalPPE2023 = 0.0;
    double totalDebt2023 = 0.0;
    private final ApiApp apiApp;
    private static final int ROWS = 12;
    private static final int COLS = 8;
    private TextField[] salesGrowthFields = new TextField[5];

    /**
     * Constructs a new {@code ForecastingFinancialStatements} instance.
     *
     * @param apiApp the {@link ApiApp} instance that initializes and manages the application.
     */
    public ForecastingFinancialStatements(ApiApp apiApp) {
        this.apiApp = apiApp;
    } // constructor

    /**
     * Displays the combined Forecasted Financial Statements window.
     *
     * @param owner  the stage owner
     * @param ticker the ticker symbol for the forecast
     */
    public void showForecastingFinancialStatementsWindow(Stage owner, TopGainersLosers
                                                         .TickerInfo ticker) {
        Stage financialStatementsStage = new Stage();
        financialStatementsStage.initOwner(owner);
        financialStatementsStage.initModality(Modality.APPLICATION_MODAL);
        financialStatementsStage.setTitle("Forecasting Financial Statements for " +
                                          ticker.getTicker());
        GridPane incomeStatementGrid = createIncomeStatementGridPane();
        populateIncomeStatementGrid(incomeStatementGrid, ticker.getTicker());
        GridPane balanceSheetGrid = createBalanceSheetGridPane();
        populateBalanceSheetGrid(balanceSheetGrid, ticker.getTicker());
        GridPane fcfEvaGrid = createFcfEvaGridPane();
        populateFcfEvaGrid(fcfEvaGrid);
        Text incomeStatementTitle = new Text("Forecasted I/S");
        incomeStatementTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        incomeStatementTitle.setTextAlignment(TextAlignment.CENTER);
        Text balanceSheetTitle = new Text("Forecasted B/S (Assuming ST Invts & PS = 0)");
        balanceSheetTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        balanceSheetTitle.setTextAlignment(TextAlignment.CENTER);
        Text fcfEvaTitle = new Text("Forecasting FCF/EVA");
        fcfEvaTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        fcfEvaTitle.setTextAlignment(TextAlignment.CENTER);
        VBox incomeStatementContainer = new VBox(5, incomeStatementTitle, incomeStatementGrid);
        incomeStatementContainer.setAlignment(Pos.TOP_CENTER);
        VBox balanceSheetContainer = new VBox(5, balanceSheetTitle, balanceSheetGrid);
        balanceSheetContainer.setAlignment(Pos.TOP_CENTER);
        VBox fcfEvaContainer = new VBox(5, fcfEvaTitle, fcfEvaGrid);
        fcfEvaContainer.setAlignment(Pos.TOP_CENTER);
        HBox gridsContainer = new HBox(20, incomeStatementContainer,
                                       balanceSheetContainer, fcfEvaContainer);
        gridsContainer.setAlignment(Pos.CENTER);
        Text instructionText = new Text("Fill in a projection for " + ticker.getTicker()
                                        + "'s growth in sales for each of the next 5 years.");
        instructionText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        Button assumptionsButton = new Button("Assumptions");
        assumptionsButton.setOnAction(event -> apiApp.displayAssumptions(financialStatementsStage,
                                                                         ticker));
        HBox top = new HBox(20, instructionText, assumptionsButton);
        ScrollPane scrollPane = new ScrollPane(gridsContainer);
        scrollPane.setFitToWidth(true);
        Text millions = new Text("In Millions (USD)");
        millions.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        Button populateButton = new Button("Populate!");
        //        populateButton.setOnAction(event -> populateAllGrids(incomeStatementGrid,
        // balanceSheetGrid,
        // fcfEvaGrid, ticker.getTicker()));
        Button goToValuations = new Button("Go to Valuations");
        goToValuations.setOnAction(event -> apiApp.showValuationWindow(
                                       financialStatementsStage, ticker));
        HBox bottom = new HBox(20, millions, populateButton, goToValuations);
        incomeStatementGrid.requestLayout();
        incomeStatementGrid.setVisible(false);
        incomeStatementGrid.setVisible(true);
        Scene scene = new Scene(new VBox(top, scrollPane, bottom), 1280, 720);
        financialStatementsStage.setScene(scene);
        financialStatementsStage.showAndWait();
    } // showForecastingFinancialStatementsWindow

    /**
     * Creates the Income Statement GridPane structure.
     *
     * @return the configured GridPane
     */
    private GridPane createIncomeStatementGridPane() {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        for (int col = 0; col < COLS; col++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            if (col == 0) {
                colConstraints.setPrefWidth(150);
            } else {
                colConstraints.setPrefWidth(75);
            } // if first
            colConstraints.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(colConstraints);
        } // for col widths
        for (int row = 0; row < ROWS; row++) {
            RowConstraints rowConstraints = new RowConstraints();
            if (row == 0) {
                rowConstraints.setPrefHeight(25);
            } else {
                rowConstraints.setPrefHeight(55);
            } // if else
            grid.getRowConstraints().add(rowConstraints);
        } // for row heights
        return grid;
    } // createIncomeStatementGridPane

    /**
     * Populates the Income Statement grid with headers and row labels.
     *
     * @param grid   the GridPane to populate
     * @param ticker the ticker symbol for the forecast
     */
    private void populateIncomeStatementGrid(GridPane grid, String ticker) {
        try {
            incomeStatement = apiService.fetchIncomeStatement(ticker);
            incomeStatement2023 = apiService.getIncomeStatementForYear(incomeStatement, 2023);
            balanceSheet = apiService.fetchBalanceSheet(ticker);
            balanceSheet2023 = apiService.getBalanceSheetForYear(balanceSheet, 2023);
            totalPPE2023 = balanceSheet2023.getPropertyPlantEquipment();
            totalDebt2023 = (balanceSheet2023.getCurrentDebt() +
                             balanceSheet2023.getLongTermDebt());
        } catch (Exception e) {
            e.printStackTrace();
        } // try catch
        String[] headers = {"2023", "2024", "2025", "2026", "2027",
                            "2028", "Terminal State (2029)"};
        populateGridHeaders(grid, headers);
        for (int col = 1; col <= headers.length; col++) {
            wrapTextInGridCell(grid, headers[col - 1], col, 2, 75, Font.font("Times New Roman",
                                                                             FontWeight.BOLD, 8));
        } // for Forecasted I/S Headers
        String[] rowLabels = {"Sales Growth", "Forecasted I/S", "Sales/Turnover (Net)",
                              "Cost of Goods Sold", "Selling, General and Administrative Expense",
                              "Depreciation and Amortization", "Nonoperating Income",
                              "Interest and Related Expense - Total", "EBIT",
                              "Income Taxes - Total", "Net Income (Loss)" };
        for (int row = 1; row <= rowLabels.length; row++) {
            wrapTextInGridCell(grid, rowLabels[row - 1], 0, row, 150,
                               Font.font("Times New Roman", FontWeight.BOLD, 10));
            if (row == 1) {
                populateSalesGrowthRow(grid, row);
            } // if sales growth row
        } // for row
        double sales2023 = incomeStatement2023 != null ? incomeStatement2023.getTotalRevenue() : 0;
        for (int col = 2; col <= 7; col++) {
            double salesGrowth = (col == 7) ? Assumptions.getTerminalSalesGrowth()
                : Double.valueOf(5 - col) / 100;
            double salesCurrentYear = calculateSalesForYear(sales2023, salesGrowth);
            double netPPE = salesCurrentYear * Assumptions.getNetPPEtoSalesRatio();
            double totalDebt = Assumptions.getDebtCapitalRatio() * salesCurrentYear; // TNOC
            if (col > 2) {
                netPPE = calculateSalesForYear(netPPE, salesGrowth);
                totalDebt = calculateSalesForYear(totalDebt, salesGrowth);
            } // if
            Map<String, Double> incomeValues = calculateNetIncome(salesCurrentYear,
                                                                  netPPE, totalDebt);
            addValueToGrid(grid, salesCurrentYear, col, 3);
            addValueToGrid(grid, incomeValues.get("COGS"), col, 4);
            addValueToGrid(grid, incomeValues.get("SG&A"), col, 5);
            addValueToGrid(grid, incomeValues.get("Depreciation"), col, 6);
            addValueToGrid(grid, incomeValues.get("NonOperatingIncome"), col, 7);
            addValueToGrid(grid, incomeValues.get("InterestExpense"), col, 8);
            addValueToGrid(grid, incomeValues.get("EBT"), col, 9);
            addValueToGrid(grid, incomeValues.get("IncomeTax"), col, 10);
            addValueToGrid(grid, incomeValues.get("NetIncome"), col, 11);
            sales2023 = salesCurrentYear;
        } // for cols
        populateTerminalSalesGrowth(grid);
    } // populateIncomeStatementGrid

    /**
     * Creates the Balance Sheet GridPane structure.
     *
     * @return the configured GridPane
     */
    private GridPane createBalanceSheetGridPane() {
        return createIncomeStatementGridPane();
    } // createBalanceSheetGridPane

    /**
     * Populates the Balance Sheet grid with headers and row labels.
     *
     * @param grid   the GridPane to populate
     * @param ticker the ticker symbol for the forecast
     */
    private void populateBalanceSheetGrid(GridPane grid, String ticker) {
        try {
            balanceSheet = apiService.fetchBalanceSheet(ticker);
            balanceSheet2023 = apiService.getBalanceSheetForYear(balanceSheet, 2023);
            incomeStatement = apiService.fetchIncomeStatement(ticker);
            incomeStatement2023 = apiService.getIncomeStatementForYear(incomeStatement, 2023);
            totalPPE2023 = balanceSheet2023.getPropertyPlantEquipment();
            totalDebt2023 = (balanceSheet2023.getCurrentDebt() +
                             balanceSheet2023.getLongTermDebt());
        } catch (Exception e) {
            System.err.println("Failed to fetch balance sheet data: " + e.getMessage());
        } // try catch
        populateGridHeaders(grid, new String[]{"2023", "2024", "2025", "2026", "2027",
                                               "2028", "Terminal State (2029)"});

        String[] rowLabels = instantiateRowLabels();
        populateRowLabels(grid, rowLabels);
        double netPPEAssumption = Assumptions.getNetPPEtoSalesRatio();
        double totalAssetsAssumption = Assumptions.getTotalAssetsToSalesRatio();
        double operatingLiabilitiesAssumption = Assumptions.getOperatingLiabilitiesRatio();
        double totalDebtAssumption = Assumptions.getDebtCapitalRatio();
        double commonEquityAssumption = Assumptions.getEquityCapitalRatio();
        double sales2023 = incomeStatement2023 != null ? incomeStatement2023.
            getTotalRevenue() : 0.0;
        double previousYearCE = 0.0;
        for (int col = 2; col <= 7; col++) {
            double salesGrowth = (col == 7) ? Assumptions.getTerminalSalesGrowth()
                : Double.valueOf(5 - col) / 100;
            double prevYearNetPPE = balanceSheet2023 != null ? totalPPE2023 : 0.0;
            double prevYearTotalDebt = balanceSheet2023 != null ? totalDebt2023 : 0.0;
            double currentYearSales = calculateSalesForYear(sales2023, salesGrowth);
            double netPPE = currentYearSales * netPPEAssumption;
            double totalAssets = currentYearSales * totalAssetsAssumption;
            double operatingLiabilities = currentYearSales * operatingLiabilitiesAssumption;
            double tnoc = totalAssets - operatingLiabilities;
            double investorSuppliedCapital = tnoc;
            double totalDebt = investorSuppliedCapital * totalDebtAssumption;
            double commonEquity = investorSuppliedCapital * commonEquityAssumption;
            double liabilitiesAndEquity = operatingLiabilities + totalDebt + commonEquity;
            double additionToRetainedEarnings = commonEquity - previousYearCE;
            previousYearCE = commonEquity;
            sales2023 = currentYearSales;
            double netIncome = calculateNetIncome(currentYearSales, netPPE,
                                                  totalDebt).get("NetIncome");
            double dividend = netIncome - additionToRetainedEarnings;
            addValueToGrid(grid, netPPE, col, 1);
            addValueToGrid(grid, totalAssets, col, 2);
            addValueToGrid(grid, operatingLiabilities, col, 3);
            addValueToGrid(grid, tnoc, col, 4);
            addValueToGrid(grid, investorSuppliedCapital, col, 5);
            addValueToGrid(grid, totalDebt, col, 6);
            addValueToGrid(grid, commonEquity, col, 7);
            addValueToGrid(grid, 0.0, col, 8);
            addValueToGrid(grid, liabilitiesAndEquity, col, 9);
            addValueToGrid(grid, additionToRetainedEarnings, col, 10);
            addValueToGrid(grid, dividend, col, 11);
        } // for
        populate2023BalanceSheetData(grid, balanceSheet2023);
    } // populateBalanceSheetGrid

    /**
     * Wraps the text within a specific cell in a GridPane.
     *
     * @param grid the GridPane to modify
     * @param text the text to wrap
     * @param col the column index of the cell
     * @param row the row index of the cell
     * @param width the wrapping width for the text
     * @param font the font to apply to the text
     */
    private void wrapTextInGridCell(GridPane grid, String text,
                                    int col, int row, double width, Font font) {
        Text wrappedText = new Text(text);
        wrappedText.setFont(font);
        wrappedText.setWrappingWidth(width);
        wrappedText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setHalignment(wrappedText, HPos.CENTER);
        grid.add(wrappedText, col, row);
    } // wrapTextInGridCell

    /**
     * Adds a TextField with input validation to a specific cell in the GridPane.
     * If the user enters a value > 10 or < -10, an alert window is shown.
     *
     * @param grid the GridPane to modify
     * @param col the column index of the cell
     * @param row the row index of the cell
     * @param font the font to apply to the TextField
     * @param wrappingWidth the wrapping width for the TextField
     */
    private void addSalesGrowthFieldWithValidation(GridPane grid, int col, int row,
                                                   Font font, double wrappingWidth) {
        TextField inputField = new TextField();
        inputField.setFont(font);
        inputField.setPrefWidth(wrappingWidth);
        inputField.setAlignment(Pos.CENTER);
        inputField.setPromptText("XX.XX%");
        inputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // When focus is lost
                String input = inputField.getText().trim();
                if (!input.endsWith("%")) {
                    input += "%";
                    inputField.setText(input);
                } // if
                try {
                    double value = Double.parseDouble(input.replace("%", ""));
                    value = Math.round(value * 100.0) / 100.0;
                    if (value > 10.0 || value < -10.0) {
                        showConfirmationWindow(inputField, value);
                    } else {
                        inputField.setText(String.format("%.2f%%", value));
                    } // if else
                } catch (NumberFormatException e) {
                    inputField.setText("");
                } // try catch
            } // if
        }); // adding listener
        grid.add(inputField, col, row);
    } // addEditableFieldWithValidation

    /**
     * Displays a confirmation window for extreme input values.
     *
     * @param inputField the TextField containing the extreme input
     * @param value the extreme value entered by the user
     */
    public void showConfirmationWindow(TextField inputField, double value) {
        Stage confirmationStage = new Stage();
        confirmationStage.initModality(Modality.APPLICATION_MODAL);
        confirmationStage.setTitle("Extreme Value Confirmation");
        confirmationStage.setWidth(600);
        confirmationStage.setHeight(100);
        Text message = new Text(String.format("%.2f%% is pretty extreme. Are you sure?", value));
        message.setFont(Font.font("Times New Roman", 12));
        Button acceptButton = new Button("I can justify " + String.format("%.2f%%", value));
        acceptButton.setOnAction(event -> {
            inputField.setText(String.format("%.2f%%", value));
            confirmationStage.close();
        });
        Button rejectButton = new Button("I cannot properly justify " +
                                         String.format("%.2f%%", value));
        rejectButton.setOnAction(event -> {
            inputField.clear();
            confirmationStage.close();
        });
        HBox buttonContainer = new HBox(10, acceptButton, rejectButton);
        buttonContainer.setAlignment(Pos.CENTER);
        VBox container = new VBox(10, message, buttonContainer);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(10));
        Scene scene = new Scene(container);
        confirmationStage.setScene(scene);
        confirmationStage.showAndWait();
    } // showConfirmationWindow

    /**
     * Creates the FCF/EVA grid pane structure.
     *
     * @return the {@link GridPane} containing the FCF/EVA table
     * with headers and placeholders for data.
     */
    private GridPane createFcfEvaGridPane() {
        GridPane fcfEvaGrid = new GridPane();
        fcfEvaGrid.setGridLinesVisible(true);
        fcfEvaGrid.setStyle("-fx-border-color: black;");
        for (int col = 0; col <= 5; col++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            if (col == 0) {
                colConstraints.setPrefWidth(150);
            } else {
                colConstraints.setPrefWidth(75);
            } // if else
            colConstraints.setHalignment(HPos.CENTER);
            fcfEvaGrid.getColumnConstraints().add(colConstraints);
        } // for columns
        for (int row = 0; row <= 5; row++) {
            RowConstraints rowConstraints = new RowConstraints();
            if (row == 0 || row == 4) {
                rowConstraints.setPrefHeight(25);
            } else {
                rowConstraints.setPrefHeight(55);
            } // if else
            fcfEvaGrid.getRowConstraints().add(rowConstraints);
        } // for rows
        return fcfEvaGrid;
    } // create FcfEvaGridPane

    /**
     * Populates the FCF/EVA grid pane with data such as NOPAT, FCF, EVA,
     * Discounting Periods, and DR(N).
     *
     * @param fcfEvaGrid the {@link GridPane} to populate with data and formatted cells.
     */
    private void populateFcfEvaGrid(GridPane fcfEvaGrid) {
        String[] headers = { "", "2024", "2025", "2026", "2027", "2028", "Terminal State (2029)" };
        for (int col = 0; col < headers.length; col++) {
            wrapTextInGridCell(fcfEvaGrid, headers[col], col, 0, 100,
                               Font.font("Times New Roman", FontWeight.BOLD, 8));
        } // for column labels

        String[] rowLabels = { "NOPAT", "FCF", "EVA", "Discounting Periods",
                               "DR(N)=(1+wacc_1)*(1+wacc_2)*...*(1+wacc_N)" };
        for (int row = 1; row <= rowLabels.length; row++) {
            wrapTextInGridCell(fcfEvaGrid, rowLabels[row - 1], 0, row, 100,
                               Font.font("Times New Roman", FontWeight.BOLD, 10));
        } // for rowLabels

        // Dummy values for testing
        double[][] dummyValues = {
            { 8429, 8383, 8495, 8591, 8771, 9077 },   // NOPAT
            { 13763, 12809, 9926, 8591, 7354, 5929 }, // FCF
            { -3261.5, -2877.0, -2412.5, -2197.8, -2011.7, -1813.4 }, // EVA
            {1, 2, 3, 4, 5, 6},                           // Discounting Periods
            { 1.08, 1.16, 1.25, 1.34, 1.44, 1.55 }    // DR(N)
        }; // dummy values

        for (int row = 0; row < dummyValues.length; row++) {
            for (int col = 0; col < dummyValues[row].length ; col++) {
                Text cellValue;
                if (row == 3) {
                    cellValue = new Text(String.format("%d", (int) dummyValues[row][col]));
                    cellValue.setFont(Font.font("Times New Roman", FontWeight.BOLD, 12));
                    cellValue.setFill(Color.BLACK);
                } else {
                    cellValue = formatCellValue(dummyValues[row][col]);
                } // if else
                wrapTextInGridCell(fcfEvaGrid, cellValue.getText(), col + 1, row + 1,
                                   100, Font.font("Times New Roman", FontWeight.NORMAL, 12));
            } // for col
        } // for row
        // createFcfEvaGridPane()
    } // populateFcfEvaGrid

    /**
     * Formats a cell's value for display. If the value is negative, it applies red
     * font and wraps it in parentheses. Positive values are displayed normally.
     *
     * @param value the numerical value to format.
     * @return a {@link Text} object containing the formatted value for display in a cell.
     */
    private Text formatCellValue(double value) {
        Text cellValue = new Text();
        if (value < 0) {
            cellValue.setText("(" + String.format("%.2f", Math.abs(value)) + ")");
            cellValue.setFill(Color.RED);
        } else {
            cellValue.setText(String.format("%,.2f", value));
            cellValue.setFill(Color.BLACK);
        } // if else
        cellValue.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
        return cellValue;
    } // formatCellValue

    /**
     * Adds a value to the GridPane with specific formatting for negative values.
     *
     * @param grid  the GridPane to populate
     * @param value the value to add (can be null)
     * @param col   the column index
     * @param row   the row index
     */
    private void addValueToGrid(GridPane grid, Double value, int col, int row) {
        if (value == null) {
            wrapTextInGridCell(grid, "", col, row, 100,
                               Font.font("Times New Roman", FontWeight.NORMAL, 12));
        } else {
            value = value / 1_000_000.0;
            Text cellValue = new Text(value < 0
                                      ? String.format("(%,.2f)", Math.abs(value))
                                      : String.format("%,.2f", value));
            cellValue.setFill(value < 0 ? Color.RED : Color.BLACK);
            cellValue.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
            grid.add(cellValue, col, row);
        } // if else
    } // addValueToGrid

    /**
     * Retrieves a node in the specified {@code GridPane} at the given row and column indices.
     *
     * @param grid the {@code GridPane} to search
     * @param row the row index of the desired node
     * @param col the column index of the desired node
     * @return the {@code Node} at the specified row and column, or {@code null} if no node exists
     */
    private Node getNodeByRowColumnIndex(GridPane grid, int row, int col) {
        for (Node node : grid.getChildren()) {
            Integer nodeRow = GridPane.getRowIndex(node);
            Integer nodeCol = GridPane.getColumnIndex(node);
            if (nodeRow == null) {
                nodeRow = 0;
            } // if
            if (nodeCol == null) {
                nodeCol = 0;
            } // if
            if (nodeRow == row && nodeCol == col) {
                return node;
            } // if
        } // for each node
        return null;
    } // getNodeByRowColumnIndex

    /**
     * Calculates the sales for a given year based on the previous year's sales and growth rate.
     *
     * @param previousYearSales the sales for the previous year.
     * @param salesGrowth the sales growth rate for the current year.
     * @return the calculated sales for the current year.
     */
    private double calculateSalesForYear(double previousYearSales, double salesGrowth) {
        return previousYearSales * (1 + salesGrowth);
    } // calculateSalesForYear

    /**
     * Calculates the net income for a specific year based on sales,
     * previous year's Net PPE, and previous year's total debt.
     *
     * @param currentYearSales the sales value for the current year.
     * @param prevYearNetPPE the Net Property, Plant, and Equipment value from the previous year.
     * @param prevYearTotalDebt the total debt value from the previous year.
     * @return a map containing line items for the income statement,
     * including "COGS", "SG&A", "Depreciation",
     * "NonOperatingIncome", "InterestExpense", "EBIT", "IncomeTax", and "NetIncome".
     */
    private Map<String, Double> calculateNetIncome(double currentYearSales, double
                                                   prevYearNetPPE, double prevYearTotalDebt) {
        Map<String, Double> result = new HashMap<>();
        double cogs = currentYearSales * Assumptions.getCogsToSalesRatio();
        double sga = currentYearSales * Assumptions.getSgaToSalesRatio();
        double depreciation = calculateDepreciation(prevYearNetPPE);
        double nonOperatingIncome = currentYearSales * Assumptions.getNonOperatingIncomeRatio();
        double interestExpense = calculateInterestExpense(prevYearTotalDebt);
        double ebt = currentYearSales - cogs - sga - depreciation +
            nonOperatingIncome - interestExpense;
        double incomeTax = ebt * Assumptions.getTaxRate();
        double netIncome = ebt - incomeTax;
        result.put("COGS", cogs);
        result.put("SG&A", sga);
        result.put("Depreciation", depreciation);
        result.put("NonOperatingIncome", nonOperatingIncome);
        result.put("InterestExpense", interestExpense);
        result.put("EBT", ebt);
        result.put("IncomeTax", incomeTax);
        result.put("NetIncome", netIncome);
        return result;
    } // calculateNetIncome

    /**
     * Calculates the depreciation for the current year based on the previous year's
     * Net Property, Plant, and Equipment.
     *
     * @param prevYearNetPPE the Net PPE value from the previous year.
     * @return the depreciation value for the current year.
     */
    private double calculateDepreciation(double prevYearNetPPE) {
        return prevYearNetPPE * Assumptions.getDepreciationToNetPpeRatio();
    } // calculateDepreciation

    /**
     * Calculates the interest expense for the current year based on the previous year's total debt.
     *
     * @param prevYearTotalDebt the total debt value from the previous year.
     * @return the interest expense for the current year.
     */
    private double calculateInterestExpense(double prevYearTotalDebt) {
        return prevYearTotalDebt * Assumptions.getInterestExpenseToDebtRatio();
    } // calculateInterestExpense

    /**
     * Calculates the Investor Supplied Capital  based on total assets and operating liabilities.
     *
     * @param totalAssets the total assets for the year
     * @param operatingLiabilities the operating liabilities for the year
     * @return the calculated investor supplied capital (TNOC)
     */
    private double calculateInvestorSuppliedCapital(double totalAssets,
                                                    double operatingLiabilities) {
        return totalAssets - operatingLiabilities;
    } // calculateInvestorSuppliedCapital

    /**
     * Populates the column headers for the specified grid.
     *
     * @param grid    the GridPane to populate.
     * @param headers an array of header titles, typically representing years or periods.
     */
    private void populateGridHeaders(GridPane grid, String[] headers) {
        for (int col = 2; col <= headers.length; col++) {
            wrapTextInGridCell(grid, headers[col - 1], col, 0, 75,
                               Font.font("Times New Roman", FontWeight.BOLD, 8));
        } // for
    } // populateGridHeaders

    /**
     * Populates the row labels for the specified grid.
     *
     * @param grid      the GridPane to populate.
     * @param rowLabels an array of labels for the rows, typically representing line items.
     */
    private void populateRowLabels(GridPane grid, String[] rowLabels) {
        for (int row = 1; row <= rowLabels.length; row++) {
            wrapTextInGridCell(grid, rowLabels[row - 1], 0, row, 150,
                               Font.font("Times New Roman", FontWeight.BOLD, 10));
        } // for
    } // populateRowLabels

    /**
     * Populates the grid with the terminal sales growth value in the designated cell.
     *
     * @param grid the GridPane to populate
     */
    private void populateTerminalSalesGrowth(GridPane grid) {
        double terminalSalesGrowthValue = Assumptions.getTerminalSalesGrowth() * 100;
        Text terminalSalesGrowthText = new Text(String.format("%.2f%%", terminalSalesGrowthValue));
        terminalSalesGrowthText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
        terminalSalesGrowthText.setTextAlignment(TextAlignment.CENTER);
        GridPane.setHalignment(terminalSalesGrowthText, HPos.CENTER);
        grid.add(terminalSalesGrowthText, 7, 1);
    } // populateTerminalSalesGrowth

    /**
     * Populates the sales growth values for the specified row in the grid.
     *
     * @param grid the GridPane to populate
     * @param row the row index where the sales growth values will be added
     */
    private void populateSalesGrowthRow(GridPane grid, int row) {
        for (int col = 2; col <= 6; col++) {
            double salesGrowthValue = Double.valueOf(5 - col);
            Text salesGrowthText = new Text(String.format("%.2f%%", salesGrowthValue));
            salesGrowthText.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
            GridPane.setHalignment(salesGrowthText, HPos.CENTER);
            grid.add(salesGrowthText, col, row);
        } // for
    } // populateSalesGrowthRow

    /**
     * Populates the initial 2023 balance sheet data into the grid.
     *
     * @param grid the GridPane to populate
     * @param balanceSheet2023 the 2023 balance sheet report containing the data
     */
    private void populate2023BalanceSheetData(GridPane grid,
                                              BalanceSheetAnnualReport balanceSheet2023) {
        addValueToGrid(grid, Double.valueOf(balanceSheet2023.getPropertyPlantEquipment()), 1, 1);
        addValueToGrid(grid, Double.valueOf(balanceSheet2023.getTotalAssets()), 1, 2);
        double operatingLiabilities = balanceSheet2023.getTotalCurrentLiabilities() +
            - balanceSheet2023.getCurrentDebt() + balanceSheet2023.getOtherNonCurrentLiabilities();
        addValueToGrid(grid, Double.valueOf(operatingLiabilities), 1, 3);
        double tnoc = balanceSheet2023.getTotalAssets() - operatingLiabilities;
        addValueToGrid(grid, Double.valueOf(tnoc), 1, 4);
        addValueToGrid(grid, Double.valueOf(tnoc), 1, 5);
        double totalDebt = balanceSheet2023.getCurrentDebt() + balanceSheet2023.getLongTermDebt();
        addValueToGrid(grid, Double.valueOf(totalDebt), 1, 6);
        addValueToGrid(grid, Double.valueOf(tnoc - totalDebt), 1, 7);
        addValueToGrid(grid, 0.0, 1, 8);
        addValueToGrid(grid, Double.valueOf(balanceSheet2023.getTotalLiabilities()), 1, 9);
        addValueToGrid(grid, null, 1, 10);
        addValueToGrid(grid, null, 1, 11);
    } // populate2023BalanceSheetData

    /**
     * Instantiates the row labels for the Balance Sheet grid.
     *
     * @return a String array containing row labels for the Balance Sheet grid
     */
    private String[] instantiateRowLabels() {
        return new String[] {
            "Property, Plant and Equipment - Total (Net)",
            "Assets - Total",
            "Operating Liabilities (Current + LT + Noncontrolling)",
            "TNOC",
            "Investor Supplied Capital",
            "Debt - Total",
            "Common/Ordinary Equity",
            "Preferred Stock (Capital) - Total",
            "Liabilities and Stockholders Equity - Total",
            "Addition to retained earnings (increase in common equity)",
            "Dividend=NI-Addition to RE"
        };
    } // instantiateRowLabels
} // ForecastingFinancialStatements
