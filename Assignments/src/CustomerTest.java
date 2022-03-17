import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void getPastOrderCount() {
        Customer customer1 = new Customer(1);
        assertEquals(customer1.getPastOrderCount(), 1 );
    }

    @Test
    void getPastOrderCountThrowsExceptionOnNegativeArg(){
        assertThrows(IllegalArgumentException.class,
                () -> { Customer customer2 = new Customer(-1);
                      customer2.getPastOrderCount();});
    }

    @Test
    void calculateOrderDiscount() {
        Customer customer3 = new Customer(12); // input 12 percent should be 5
        Customer customer4 = new Customer(42); //percent should be 10
        Customer customer5 = new Customer(1001); //percent should be 11
        Customer customer6 = new Customer(6); //percent should be 0

        assertEquals(customer3.calculateOrderDiscount(12), 5);
        assertEquals(customer4.calculateOrderDiscount(42), 10);
        assertEquals(customer5.calculateOrderDiscount(1001), 11);
        assertEquals(customer6.calculateOrderDiscount(6), 0);

    }
}