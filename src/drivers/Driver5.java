package drivers;

import bankSystem.*;

public class Driver5 {

    public static void main(String[] args) {


        Bank bank = new Bank();

        Customer c = new Customer("john", bank);
        Customer c1 = new Customer("alex", bank);
        Customer c2 = new Customer("amy", bank);

        Employee e = new Employee("sam", bank);
        Employee e1 = new Employee("eliot", bank);


        c.openJointAccount(new JointAccount(1000), c1);


        Runnable1 check_bal = new Runnable1 (c);
        //runnable withdrawing from the balance
        Runnable2 draw = new Runnable2 (c1);
        //runnable depositing money
        Runnable3 deposit = new Runnable3 (c);


        Thread t1 = new Thread(check_bal);
        Thread t4 = new Thread(draw);
        Thread t8 = new Thread(deposit);

        t4.start();
        t8.start();
        t1.start();
    }
}
