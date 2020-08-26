package app.controller;

import app.model.TransactionComparator;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The controller for the file picker view.
 */
public class FilePickerController {

    public Label lblStatus;
    public Label lblFile1;
    public Label lblFile2;

    private TransactionComparator transactionComparator;

    /**
     * Initialize the transaction comparator.
     */
    public void initialize() {
        transactionComparator = TransactionComparator.getInstance();
    }

    /**
     * Read content of the first file when a file is selected.
     */
    public void onSelectFile1Action() {
        try {
            File selectedFile = chooseFile();
            transactionComparator.readFirst(selectedFile);
            lblFile1.setText(selectedFile.getName());
            lblStatus.setText("");
        } catch (FileNotFoundException e) {
            lblStatus.setText("Please select a valid file.");
        } catch (Exception e) {
            lblStatus.setText("Error reading from file.");
        }
    }

    /**
     * Read content of the second file when a file is selected.
     */
    public void onSelectFile2Action() {
        try {
            File selectedFile = chooseFile();
            transactionComparator.readSecond(selectedFile);
            lblFile2.setText(selectedFile.getName());
            lblStatus.setText("");
        } catch (FileNotFoundException e) {
            lblStatus.setText("Please select a valid file.");
        } catch (Exception e) {
            lblStatus.setText("Error reading from file.");
        }
    }

    /**
     * Open a file chooser window.
     * @return the chosen file
     * @throws FileNotFoundException if the file couldn't be opened.
     */
    public File chooseFile() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(lblStatus.getScene().getWindow());
        if (selectedFile == null) {
            throw new FileNotFoundException();
        }
        return selectedFile;
    }

    /**
     * Compare the two files.
     * @throws IOException if the next screen couldn't be loaded.
     */
    public void onCompareAction() throws IOException {
        try {
            transactionComparator.compare();
        } catch (Exception e) {
            lblStatus.setText("Error comparing files. Please make sure the files are correct.");
            return;
        }
        Util.switchScene((Stage) lblStatus.getScene().getWindow(), "/app/view/resultsView.fxml");
    }
}
