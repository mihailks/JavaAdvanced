import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    @Test
    public void testGetCount() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));

        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testGetCountEmpty() {
        ChainblockImpl chainblock = new ChainblockImpl();
        int actual = chainblock.getCount();
        assertEquals(0, actual);
    }

    @Test
    public void testAdd() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));
        chainblock.add(setUpTransaction(2000));
        chainblock.add(setUpTransaction(-2500));

        List<Transaction> actual = getAll(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionsIdsEqual(Arrays.asList(-2500, 1, 2, 2000), actual);
    }

    @Test
    public void testAddSingle() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(-2500));

        List<Transaction> actual = getAll(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionsIdsEqual(Collections.singletonList(-2500), actual);
    }

    @Test
    public void testAddDoesntDuplicate() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(setUpTransaction(2));
        chainblock.add(setUpTransaction(1, TransactionStatus.ABORTED));

        List<Transaction> actual = getAll(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(1, actual.get(0).getId());
        assertEquals(TransactionStatus.SUCCESSFUL, actual.get(0).getStatus());
        assertTransactionsIdsEqual(Arrays.asList(1, 2), actual);
    }

    @Test
    public void testContainsForExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        Transaction searchTransaction = setUpTransaction(1);
        chainblock.add(searchTransaction);
        chainblock.add(setUpTransaction(2));

        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsForExistingTransactionWhenSingleTransactionInDataBase() {
        ChainblockImpl chainblock = new ChainblockImpl();
        Transaction searchTransaction = setUpTransaction(1);
        chainblock.add(searchTransaction);

        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsSameIdTransactionDifferentObjectByInstance() {
        ChainblockImpl chainblock = new ChainblockImpl();

        Transaction transaction = setUpTransaction(1);
        chainblock.add(transaction);

        Transaction searchTransaction = setUpTransaction(1);
        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsForExistingTransactionWithDifferentPropertiesReturnsTrue() {
        ChainblockImpl chainblock = new ChainblockImpl();
        Transaction transaction = setUpTransaction(1);
        chainblock.add(transaction);
        Transaction searchTransaction = setUpTransaction(1);
        searchTransaction.setStatus(TransactionStatus.ABORTED);

        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsForNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));
        Transaction searchTransaction = setUpTransaction(3);

        assertFalse(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsEmptyDataBase() {
        ChainblockImpl chainblock = new ChainblockImpl();

        Transaction searchTransaction = setUpTransaction(3);

        assertFalse(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsByIdExisting() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));

        assertTrue(chainblock.contains(1));
    }

    @Test
    public void testContainsByIdNonExisting() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));

        assertFalse(chainblock.contains(3));
    }

    @Test
    public void testContainsByIdEmptyDataBase() {
        ChainblockImpl chainblock = new ChainblockImpl();

        assertFalse(chainblock.contains(3));
    }

    @Test
    public void testChangeStatusExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(setUpTransaction(2, TransactionStatus.SUCCESSFUL));

        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);

        assertEquals(TransactionStatus.ABORTED, chainblock.getById(1).getStatus());
        assertEquals(TransactionStatus.SUCCESSFUL, chainblock.getById(2).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeStatusNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(setUpTransaction(2, TransactionStatus.SUCCESSFUL));

        chainblock.changeTransactionStatus(3, TransactionStatus.ABORTED);

    }

    @Test
    public void testRemoveExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));
        chainblock.add(setUpTransaction(3));

        chainblock.removeTransactionById(2);

        List<Transaction> remaining = getAll(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionsIdsEqual(Arrays.asList(1, 3), remaining);
    }

    @Test
    public void testRemoveMultipleExistingTransactions() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));
        chainblock.add(setUpTransaction(3));

        chainblock.removeTransactionById(2);
        chainblock.removeTransactionById(3);

        List<Transaction> remaining = getAll(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionsIdsEqual(Collections.singletonList(1), remaining);
    }

    @Test
    public void testRemoveOnlyTransactions() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1));

        chainblock.removeTransactionById(1);

        List<Transaction> remaining = getAll(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(0, remaining.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1));

        chainblock.removeTransactionById(2);


    }

    @Test
    public void testGetByIdExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));
        chainblock.add(setUpTransaction(3));

        Transaction transaction = chainblock.getById(2);

        assertEquals(2, transaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdNonExisting() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setUpTransaction(1));
        chainblock.add(setUpTransaction(2));
        chainblock.add(setUpTransaction(3));

        Transaction transaction = chainblock.getById(4);
    }

    private static void assertTransactionsIdsEqual(List<Integer> expectedIds, List<Transaction> actual) {
        assertEquals(expectedIds.size(), actual.size());
        for (int i = 0; i < expectedIds.size(); i++) {
            assertEquals((int) expectedIds.get(i), actual.get(i).getId());
        }
    }


    private static Transaction setUpTransaction(int id, TransactionStatus status) {
        return new TransactionImpl(id, status, "from", "to", 42);
    }

    private static Transaction setUpTransaction(int id) {
        return new TransactionImpl(id, TransactionStatus.SUCCESSFUL, "from", "to", 42);
    }


    private static <T> List<T> getAll(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList<>();
        for (T item : iterable) {
            list.add(item);
        }
        return list;
    }


}
