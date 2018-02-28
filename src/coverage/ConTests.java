package coverage;

import bankSystem.*;

public class ConTests {

    Customer c1;
    Customer c2;
    Employee e;
    JointAccount jointAccount;
    Bank bank;

    public ConTests() {

        bank = new Bank();
        e = new Employee("Dean", bank);
        c1 = new Customer("John", bank);
        c2 = new Customer("Fraser", bank);
        c1.openJointAccount(new JointAccount(1000), c2);
        jointAccount = (JointAccount) c1.getAccounts().get(0);
        jointAccount.setCustId(c1.getId());
        jointAccount.setCustId_2(c2.getId());


    }

    public void driver1Test() {
        //runnable checking the account balance
        Runnable1 check_bal = new Runnable1(c1);
        Runnable1 check_bal2 = new Runnable1(c2);

        Thread t1 = new Thread(check_bal);
        Thread t2 = new Thread(check_bal2);

        //two account holders checking the balance
        t1.start();
        t2.start();


    }

    //test 2 - one customer tries to check the balance whilst another is depositing money

    public void driver2Test() {
        //runnable checking the account balance
        Runnable1 check_bal = new Runnable1(c1);

        //runnable withdrawing from the balance
        Runnable2 draw = new Runnable2(c2);

        Thread t3 = new Thread(check_bal);
        Thread t4 = new Thread(draw);

        t3.start();
        t4.start();
    }

    //test 3 - one customer customer withdraws whilst another user is depositing money

    public void driver3Test() {
        //runnable withdrawing from the balance and checking
        Runnable5 draw_check = new Runnable5(c1);

        //runnable depositing money and checking
        Runnable6 deposit_check = new Runnable6(c2);

        Thread t5 = new Thread(deposit_check);
        Thread t6 = new Thread(draw_check);


        t5.start();
        t6.start();


    }

    // test 4 -	one customer is depositing, the other is withdrawing and checking balance
//	    	and an employee is also doing a withdraw


    public void driver4Test() {

        //runnable depositing money and checking
        Runnable6 deposit_check = new Runnable6(c1);
        //runnable withdrawing from the balance and checking
        Runnable5 draw_check = new Runnable5(c2);
        //runnable for employee withdrawing money
        Runnable4 employee_withdraw = new Runnable4(e, c1);

        Thread t5 = new Thread(deposit_check);
        Thread t6 = new Thread(draw_check);
        Thread t7 = new Thread(employee_withdraw);

        t5.start();
        t6.start();
        t7.start();


    }

    // test 5 - check balance - withdraw - deposit

    public void driver5Test() {
        Runnable1 check_bal = new Runnable1(c1);
        //runnable withdrawing from the balance
        Runnable2 draw = new Runnable2(c2);
        //runnable depositing money
        Runnable3 deposit = new Runnable3(c1);


        Thread t1 = new Thread(check_bal);
        Thread t4 = new Thread(draw);
        Thread t8 = new Thread(deposit);

        t4.start();
        t8.start();
        t1.start();


    }

    // test 6 - two employees changing details

    public void driver6Test() {
        Employee e1 = new Employee("Fraser Steel", bank);
        Employee e2 = new Employee("eliot", bank);

        Runnable7 empl_change_details = new Runnable7(e1, c1);
        //runnable depositing money and checking
        Runnable8 empl_change_details2 = new Runnable8(e2, c1);

        Thread t9 = new Thread(empl_change_details);
        Thread t10 = new Thread(empl_change_details2);


        t9.start();
        t10.start();
    }

}

