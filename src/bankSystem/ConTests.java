package bankSystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ConTests {

    public CurrentAccount jointAccount;
    Customer c1;
    Customer c2;
    Employee e;
    Bank bank;
    final static int RUN_X_TIMES=10;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[RUN_X_TIMES][0]);
    }

    @Before
    public synchronized void build() {
        jointAccount = new CurrentAccount(1000);


        bank = new Bank();
        e = new Employee("Dean", bank);
        c1 = new Customer("John", bank);
        c2 = new Customer("Fraser", bank);


        c1.openAccount(jointAccount);
        jointAccount.setCustId(c1.getId());
    }

    @Test
    public synchronized void driver1Test() throws InterruptedException {
        //runnable checking the account balance
        Runnable1 check_bal = new Runnable1(c1);
        Runnable1 check_bal2 = new Runnable1(c2);

        Thread t1 = new Thread(check_bal);
        Thread t2 = new Thread(check_bal2);

        //two account holders checking the balance
        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
            //Thread.sleep(1000);
        }
        assertEquals(1000, jointAccount.balance, 0);

    }


    @Test
    public synchronized void driver2Test() throws InterruptedException {
        //runnable checking the account balance
        Runnable1 check_bal = new Runnable1(c1);

        //runnable withdrawing from the balance
        Runnable2 draw = new Runnable2(c2);

        Thread t3 = new Thread(check_bal);
        Thread t4 = new Thread(draw);

        t3.start();
        t4.start();

        while (t3.isAlive() || t4.isAlive()) {
            //Thread.sleep(1000);

        }
        assertEquals(1000, jointAccount.balance, 0);
    }

    //test 2 - one customer tries to check the balance whilst another is depositing money

    @Test
    public synchronized void driver3Test() throws InterruptedException {
        //runnable withdrawing from the balance and checking
        Runnable5 draw_check = new Runnable5(c1);

        //runnable depositing money and checking
        Runnable6 deposit_check = new Runnable6(c2);

        Thread t5 = new Thread(deposit_check);
        Thread t6 = new Thread(draw_check);


        t5.start();
        t6.start();


        while (t5.isAlive() || t6.isAlive()) {
            //Thread.sleep(1000);

        }
        assertEquals(500, jointAccount.balance, 0);
    }

    //test 3 - one customer customer withdraws whilst another user is depositing money

    @Test
    public synchronized void driver4Test() throws InterruptedException {

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

        while (t5.isAlive() || t6.isAlive() || t7.isAlive()) {
            //Thread.sleep(1000);

        }
        System.out.println(jointAccount.balance);
        assertTrue(jointAccount.balance == 2900.0 || jointAccount.balance == 3400.0 || jointAccount.balance == 3400.0);
    }

    // test 4 -	one customer is depositing, the other is withdrawing and checking balance
//	    	and an employee is also doing a withdraw

    @Test
    public synchronized void driver5Test() throws InterruptedException {
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

        while (t4.isAlive() || t8.isAlive() || t1.isAlive()) {
            //Thread.sleep(1000);

        }
        assertEquals(2000, jointAccount.balance, 0);

    }

    // test 5 - check balance - withdraw - deposit

    @Test
    public synchronized void driver6Test() {
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

    // test 6 - two employees changing details


}

