package app.controller;

import app.model.TransactionComparator;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The controller for the results view.
 */
public class ResultsController {
    public Label lblFile1Name;
    public Label lblFile2Name;

    public Label lblFile1Total;
    public Label lblFile1Matching;
    public Label lblFile1Unmatched;

    public Label lblFile2Total;
    public Label lblFile2Matching;
    public Label lblFile2Unmatched;

    private TransactionComparator transactionComparator;

    /**
     * Set the relevant fields.
     */
    public void initialize() {
        transactionComparator = TransactionComparator.getInstance();
        lblFile1Name.setText(transactionComparator.first.fileName);
        lblFile2Name.setText(transactionComparator.second.fileName);

        lblFile1Total.setText(String.valueOf(transactionComparator.first.total));
        lblFile1Matching.setText(String.valueOf(transactionComparator.first.matching));
        lblFile1Unmatched.setText(String.valueOf(transactionComparator.first.unmatched.size()));

        lblFile2Total.setText(String.valueOf(transactionComparator.second.total));
        lblFile2Matching.setText(String.valueOf(transactionComparator.second.matching));
        lblFile2Unmatched.setText(String.valueOf(transactionComparator.second.unmatched.size()));
    }

    /**
     * Go to the report view.
     * @throws IOException if the view wasn't found.
     */
    public void onReportAction() throws IOException {
        Util.switchScene((Stage) lblFile1Name.getScene().getWindow(), "/app/view/reportView.fxml");
    }

    /**
     * Go back.
     * @throws IOException if the view wasn't found.
     */
    public void onBackAction() throws IOException {
        Util.switchScene((Stage) lblFile1Name.getScene().getWindow(), "/app/view/filePickerView.fxml");
    }
}
