/**
 * Represents a customer with a past order count and can calculate order discounts.
 *
 * @author
 */
public class Customer {

    private int pastOrderCount;

    /**
     * Create a new customer specifying the number of past orders the customer has placed
     *
     * @param pastOrderCount must be non-negative
     * @throws IllegalArgumentException for past order counts less than zero
     */
    public Customer(int pastOrderCount) {
        if (pastOrderCount <= 0) {
            throw new IllegalArgumentException("pastOrderCount must be greater than zero!");
        }
        this.pastOrderCount = pastOrderCount;
    }

    /**
     * Returns the number of past orders the customer has placed.
     *
     * @return the past number of orders the customer has placed
     */
    public int getPastOrderCount() {
        return pastOrderCount;
    }

    /**
     * Calculate the percent discount on an order and increase the customer's past order count
     * <p>
     * pastOrderCount < 10 : percentage 0%
     * 10 <= pastOrderCount <= 40 : percentage 5%
     * 40 < pastOrderCount : percentage 10%
     * <p>
     * Orders with a total cost over $1000.00 are given an additional 1% discount
     *
     * @param orderTotal the total cost of the merchandise in the order
     * @return returns the percent discount to be given, when given the price of the merchandise, and the number of orders the customer has placed in the past
     */
    public int calculateOrderDiscount(double orderTotal) {

        int percent = 0;

        if (pastOrderCount > 10 && pastOrderCount <= 40) {
            percent = 5;
        } else if (pastOrderCount > 40) {
            percent = 10;
        }

        if (orderTotal > 1000.00) {
            percent = percent + 1;
        }

        pastOrderCount++;

        return percent;
    }
}