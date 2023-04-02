import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private HashMap<Integer, Transaction> transactionsById = new HashMap<>();

    public int getCount() {
        return transactionsById.size();
    }

    @Override
    public void add(Transaction transaction) {
        if (contains(transaction)) {
            return;
        }
        transactionsById.put(transaction.getId(), transaction);
    }

    @Override
    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    @Override
    public boolean contains(int id) {
        return geyByIdOrNull(id) != null;
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        getById(id).setStatus(newStatus);
    }

    @Override
    public void removeTransactionById(int id) {

        Transaction removed = transactionsById.remove(id);
        if (removed == null) {
            throw new IllegalArgumentException();
        }

//        List<Transaction> updatedTransactions = transactions.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
//       if (updatedTransactions.size() == transactions.size()){
//           throw new IllegalArgumentException();
//       }
//        transactions =updatedTransactions;
    }

    @Override
    public Transaction getById(int id) {
        Transaction transaction = geyByIdOrNull(id);
        if (transaction == null) {
            throw new IllegalArgumentException();
        }
        return transaction;
    }

    private Transaction geyByIdOrNull(int id) {

        return transactionsById.get(id);


/*        Optional<Transaction> transactionOptional = transactions.stream()
                .filter(t -> t.getId() == id).findFirst();
        if (transactionOptional.isPresent()) {
            return transactionOptional.get();
        } else {
            return null;
        }*/
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactionsById.values().stream()
                .sorted((a, b) -> {
                    if (a.getAmount() != b.getAmount()) {
                        return Double.compare(b.getAmount(), a.getAmount());
                    }
                    return Integer.compare(a.getId(), b.getId());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return null;
    }
}
