package drivers;

import bankSystem.*;

public class Driver3 {

    public static void main(String[] args) {
        System.out.println("Concurrent (withdrawal, check balance) then (deposit, check balance) in Driver 3, Thread: "+Thread.currentThread().getName());
        System.out.println("Initial balance: 1000");
        System.out.println("One account, alex withdrawing 500 and checking balance [Runnable 5] " +
                "then john depositing 3000 and checking balance [Runnable 6].");

        Bank bank = new Bank();

        Customer c = new Customer("john", bank);
        Customer c1 = new Customer("alex", bank);

        c.openJointAccount(new JointAccount(1000), c1);


        //runnable withdrawing from the balance and checking
        Runnable5 draw_check = new Runnable5(c1);

        //runnable depositing money and checking
        Runnable6 deposit_check = new Runnable6(c);

        Thread t5 = new Thread(deposit_check);
        Thread t6 = new Thread(draw_check);


        t5.start();
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t6.start();
    }
}
