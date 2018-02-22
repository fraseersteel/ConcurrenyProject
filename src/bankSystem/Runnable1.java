package bankSystem;

public class Runnable1 implements Runnable {

    private Customer cust;

    private static final int DELAY = 1000;

    public Runnable1(Customer c) {
        cust = c;
    }

    public void run() {
        System.out.println("Check Balance Runnable [Runnable 1] started.");
        try {

            Thread.sleep(DELAY);

            System.out.println("Balance is " + cust.getAccounts().get(0).getBalance());


        } catch (Exception e) {

        }
    }
}
