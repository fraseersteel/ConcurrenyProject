package bankSystem;

public class Runnable4 implements Runnable {

    private Employee emp;
    private Customer cust;
    private static final int DELAY = 1000;

    public Runnable4(Employee employee, Customer c) {
        emp = employee;
        cust = c;
    }

    public void run() {
        System.out.println("Employee Withdraw 600 Runnable [Runnable 4] started. "
        + "Thread: " + Thread.currentThread().getName());
        try {

            Thread.sleep(DELAY);
            System.out.println("Withdrawing money by employee " + emp.getName());
            emp.withdraw(cust.getAccounts().get(0), 600);


        } catch (Exception e) {

        }
    }
}
