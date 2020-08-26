package app.model;

import java.util.ArrayList;

/**
 * A transaction data container.
 * This contains data about total, matching, unmatched entries.
 */
public class TransactionData {
    public ArrayList<Transaction> data;
    public ArrayList<Transaction> unmatched;
    public int total;
    public int matching;
    public String fileName;

    /**
     * Create a new TransactionData instance.
     * @param fileName the file name.
     */
    public TransactionData(String fileName) {
        unmatched = new ArrayList<>();
        matching = 0;
        this.fileName = fileName;
    }

    /**
     * Set the data list.
     * @param data the data
     */
    public void setData(ArrayList<Transaction> data) {
        this.data = data;
        total = data.size();
    }

    /**
     * Compare this data container with another.
     * @param other the other data container.
     */
    public void compare(TransactionData other) {
        matching = 0;
        unmatched = new ArrayList<>();
        //Search the other container for entries in this one and add the unmatched ones to a separate list.
        for (Transaction transaction : data) {
            boolean found = false;
            for (Transaction otherTransaction : other.data) {
                if (transaction.equals(otherTransaction)) {
                    found = true;
                    matching++;
                    break;
                }
            }
            if (!found) {
                unmatched.add(transaction);
            }
        }
    }
}
