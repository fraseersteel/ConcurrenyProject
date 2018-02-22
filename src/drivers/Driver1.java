package drivers;

import bankSystem.*;

public class Driver1 {

    public static void main(String[] args) {
        System.out.println("Concurrent check of balance started in Driver 1, Thread: "+Thread.currentThread().getName());
        System.out.println("Initial balance: 1000");
        System.out.println("One account, john checking balance [Runnable 1] then alex checking balance [Runnable 1], with no change to balance. ");
        Bank bank = new Bank();

        Customer c = new Customer("john", bank);
        Customer c1 = new Customer("alex", bank);

        c.openJointAccount(new JointAccount(1000), c1);

        //runnable checking the account balance
        Runnable1 check_bal = new Runnable1 (c);
        Runnable1 check_bal2 = new Runnable1 (c1);

        Thread t1 = new Thread(check_bal);
        Thread t2 = new Thread(check_bal2);

        //two account holders checking the balance
        t1.start();
        t2.start();
    }
}
