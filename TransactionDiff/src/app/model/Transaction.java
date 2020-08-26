package app.model;

/**
 * This represents a single transaction.
 */
public class Transaction {
    public String profileName;
    public String transactionDate;
    public double transactionAmount;
    public String transactionNarrative;
    public String transactionDescription;
    public long transactionId;
    public int transactionType;
    public String walletReference;

    /**
     * Create a new transaction
     * @param profileName the profile name
     * @param transactionDate the transaction date
     * @param transactionAmount the transaction amount
     * @param transactionNarrative the transaction narrative
     * @param transactionDescription the transaction description
     * @param transactionId the transaction id
     * @param transactionType the transaction type
     * @param walletReference the transaction wallet reference
     */
    public Transaction(
            String profileName, String transactionDate, double transactionAmount, String transactionNarrative,
            String transactionDescription, long transactionId, int transactionType, String walletReference
    ) {
        this.profileName = profileName;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionNarrative = transactionNarrative;
        this.transactionDescription = transactionDescription;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.walletReference = walletReference;
    }

    /**
     * Calculate the difference between two transactions.
     * This is useful for finding close matches.
     * @param other the other transaction
     * @return the score
     */
    public int difference(Transaction other) {
        int score = 0;
        score += profileName.equals(other.profileName) ? 0 : 1;
        score += transactionDate.equals(other.transactionDate) ? 0 : 1;
        score += transactionAmount == other.transactionAmount ? 0 : 1;
        score += transactionNarrative.equals(other.transactionNarrative) ? 0 : 1;
        score += transactionDescription.equals(other.transactionDescription) ? 0 : 1;
        score += transactionId == other.transactionId ? 0 : 1;
        score += transactionType == other.transactionType ? 0 : 1;
        score += walletReference.equals(other.walletReference) ? 0 : 1;
        return score;
    }

    /**
     * Check if this is equal to another object.
     * @param obj the other object
     * @return true if equal false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Transaction other = (Transaction) obj;
        return this.difference(other) == 0;
    }

    /**
     * Get the transaction date.
     * @return the transaction date
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Get the wallet reference
     * @return the wallet reference
     */
    public String getWalletReference() {
        return walletReference;
    }

    /**
     * Get the transaction amount
     * @return the transaction amount
     */
    public double getTransactionAmount() {
        return transactionAmount;
    }
}
