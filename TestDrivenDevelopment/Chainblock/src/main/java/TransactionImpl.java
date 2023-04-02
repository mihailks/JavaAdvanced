public class TransactionImpl implements Transaction, Comparable<TransactionImpl>{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public int compareTo(TransactionImpl o) {
        throw new UnsupportedOperationException();
    }
}
