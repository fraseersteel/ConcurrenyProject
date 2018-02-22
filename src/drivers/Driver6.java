package drivers;

import bankSystem.*;

public class Driver6 {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Customer c = new Customer("john", bank);
        Customer c1 = new Customer("alex", bank);
        Customer c2 = new Customer("amy", bank);

        Employee e = new Employee("sam", bank);
        Employee e1 = new Employee("eliot", bank);


        c.openJointAccount(new JointAccount(1000), c1);


        Runnable7 empl_change_details = new Runnable7 (e, c);
        //runnable depositing money and checking
        Runnable8 empl_change_details2 = new Runnable8 (e1, c);

        Thread t9 = new Thread(empl_change_details);
        Thread t10 = new Thread(empl_change_details2);


        t9.start();
        t10.start();

    }
}

