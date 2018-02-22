package drivers;

import bankSystem.*;

public class Driver3 {

    public static void main(String[] args) {

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
        t6.start();
    }
}
