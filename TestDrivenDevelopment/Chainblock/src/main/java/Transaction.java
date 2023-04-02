public interface Transaction {
    void setStatus(TransactionStatus status);

    int getId();

    TransactionStatus getStatus();

    String getFrom();

    String getTo();

    double getAmount();

    int compareTo(TransactionImpl o);
}
