package app.controller;

import app.model.Transaction;
import app.model.TransactionComparator;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The controller for the report view.
 */
public class ReportController {

    public Label lblFile1Name;
    public Label lblFile2Name;

    public TableView tableFile1;
    public TableView tableFile2;

    public TableColumn<String, Transaction> columnFile1Date;
    public TableColumn<String, Transaction> columnFile1Ref;
    public TableColumn<Double, Transaction> columnFile1Amount;
    public TableColumn<String, Transaction> columnFile2Date;
    public TableColumn<String, Transaction> columnFile2Ref;
    public TableColumn<Double, Transaction> columnFile2Amount;

    private TransactionComparator transactionComparator;

    /**
     * Set the relevant fields.
     */
    public void initialize() {
        transactionComparator = TransactionComparator.getInstance();

        lblFile1Name.setText(transactionComparator.first.fileName);
        lblFile2Name.setText(transactionComparator.second.fileName);

        columnFile1Date.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        columnFile1Ref.setCellValueFactory(new PropertyValueFactory<>("walletReference"));
        columnFile1Amount.setCellValueFactory(new PropertyValueFactory<>("transactionAmount"));

        columnFile2Date.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        columnFile2Ref.setCellValueFactory(new PropertyValueFactory<>("walletReference"));
        columnFile2Amount.setCellValueFactory(new PropertyValueFactory<>("transactionAmount"));

        //Add the unmatched records to the tables.
        tableFile1.getItems().addAll(transactionComparator.first.unmatched);
        tableFile2.getItems().addAll(transactionComparator.second.unmatched);
    }

    /**
     * Go back on back button press.
     * @param actionEvent the event that triggered the action.
     * @throws IOException if the next screen wasn't found.
     */
    public void onBackButtonAction(ActionEvent actionEvent) throws IOException {
        Util.switchScene((Stage) lblFile1Name.getScene().getWindow(), "/app/view/resultsView.fxml");
    }
}
