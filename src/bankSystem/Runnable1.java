package bankSystem;

public class Runnable1 implements Runnable {

    private Customer cust;

    private static final int DELAY = 1000;

    public Runnable1(Customer c) {
        cust = c;

    }

    public void run() {
        try {
            Thread.sleep(DELAY);

            System.out.println("Balance is " + cust.getAccounts().get(0).getBalance());


        } catch (Exception e) {
        }
    }

}
