import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionImplTest {

    @Test
    public void testGetters() {
        TransactionImpl transaction = new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "from", "to", 42.0);

        assertEquals(1, transaction.getId());
        assertEquals(TransactionStatus.UNAUTHORIZED, transaction.getStatus());
        assertEquals("from", transaction.getFrom());
        assertEquals("to", transaction.getTo());
        assertEquals(42.0, transaction.getAmount(), 0);
    }

    @Test
    public void testChangeStatus() {
        TransactionImpl transaction = new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "from", "to", 42.0);

        transaction.setStatus(TransactionStatus.SUCCESSFUL);
        assertEquals(TransactionStatus.SUCCESSFUL, transaction.getStatus());
    }
}
