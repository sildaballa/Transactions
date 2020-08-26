package app.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The singleton takes care of all the comparison and report building operations.
 */
public class TransactionComparator {
    private static TransactionComparator transactionComparator = null;

    public TransactionData first;
    public TransactionData second;

    /**
     * Empty private constructor.
     */
    private TransactionComparator() {
    }

    /**
     * Get a TransactionComparator instance.
     * @return the transaction comparator instance.
     */
    public static TransactionComparator getInstance() {
        if (transactionComparator == null)
            transactionComparator = new TransactionComparator();
        return transactionComparator;
    }

    /**
     * Read the first file
     * @param file the file
     * @throws Exception if the file couldn't be read properly
     */
    public void readFirst(File file) throws Exception {
        first = new TransactionData(file.getName());
        first.setData(readTransactionsFromFile(file));
    }

    /**
     * Read the second file
     * @param file the file
     * @throws Exception if the file couldn't be read properly
     */
    public void readSecond(File file) throws Exception {
        second = new TransactionData(file.getName());
        second.setData(readTransactionsFromFile(file));
    }

    /**
     * Compare the two files.
     */
    public void compare() {
        //Both files are compared against each other.
        //This way we find missing entries on both files.
        first.compare(second);
        second.compare(first);
    }

    /**
     * Read transactions from a file
     * @param file the file
     * @return an ArrayList containing the transactions.
     * @throws Exception if the file couldn't be read properly.
     */
    public ArrayList<Transaction> readTransactionsFromFile(File file) throws Exception {
        Scanner sc = new Scanner(file);
        ArrayList<Transaction> transactions = new ArrayList<>();
        //Ignore the first line.
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().replaceAll(",$", "").split(",", -1);
            if (tokens.length != 8) throw new IndexOutOfBoundsException();
            transactions.add(new Transaction(
                    tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4],
                    Long.parseLong(tokens[5]), Integer.parseInt(tokens[6]), tokens[7]
            ));
        }
        return transactions;
    }

    /**
     * A string representation of the comparator.
     * @return a string.
     */
    public String toString() {
        return String.format(
                "first: %d / %d\n" + "second: %d / %d\n",
                first.matching, first.total,
                second.matching, second.total
        );
    }
}
