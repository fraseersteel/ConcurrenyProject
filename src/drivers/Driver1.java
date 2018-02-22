package drivers;

import bankSystem.*;

public class Driver1 {

    public static void main(String[] args) {
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
