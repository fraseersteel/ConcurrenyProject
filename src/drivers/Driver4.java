package drivers;

import bankSystem.*;

public class Driver4 {

    public static void main(String[] args) {
        System.out.println("Concurrent check of balance then customer withdraw then employee withdraw in Driver 4, " +
                "Thread: "+Thread.currentThread().getName());
        System.out.println("Initial balance: 1000");
        System.out.println("One account, two customers and an employee, " +
                "john(customer) depositing 3000 and checking balance [Runnable 6], " +
                "alex(customer) withdrawing 500 and checking balance [Runnable 5] and" +
                "sam(employee) withdrawing 500 - no balance check [Runnable 4]");

        Bank bank = new Bank();

        Customer c = new Customer("john", bank);
        Customer c1 = new Customer("alex", bank);
        Customer c2 = new Customer("amy", bank);

        Employee e = new Employee("sam", bank);
        Employee e1 = new Employee("eliot", bank);


        c.openJointAccount(new JointAccount(1000), c1);

        //runnable depositing money and checking
        Runnable6 deposit_check = new Runnable6(c);
        //runnable withdrawing from the balance and checking
        Runnable5 draw_check = new Runnable5(c1);
        //runnable for employee withdrawing money
        //note - the runnable deposits into the customer's first account in the array  *EDIT CW - Does not deposit anything*
        Runnable4 employee_withdraw = new Runnable4(e, c);


        Thread t5 = new Thread(deposit_check);
        Thread t6 = new Thread(draw_check);
        Thread t7 = new Thread(employee_withdraw);

//    	    	one is depositing and checking balance, the other is withdrawing and checking balance
//	    	and an employee is doing a withdraw

        t5.start();
        t6.start();
        t7.start();

    }
}
