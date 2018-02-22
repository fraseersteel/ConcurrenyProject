package drivers;

import bankSystem.*;

public class Driver2 {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Customer c = new Customer("john", bank);
        Customer c1 = new Customer("alex", bank);

        c.openJointAccount(new JointAccount(1000), c1);

        //runnable checking the account balance
        Runnable1 check_bal = new Runnable1 (c);

        //runnable withdrawing from the balance
        Runnable2 draw = new Runnable2 (c1);

        Thread t3 = new Thread(check_bal);
        Thread t4 = new Thread(draw);

        t3.start();
        t4.start();

    }
}