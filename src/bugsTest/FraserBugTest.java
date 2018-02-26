package bugsTest;

import bankSystem.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class FraserBugTest {

    Bank bank;
    Customer c;
    Customer c1;
    Thread t5;
    Thread t6;
    Thread t7;
    JointAccount jointAccount;
    Runnable draw_check;
    Runnable deposit_check;
    Runnable employee_withdraw;
    Employee e;

    @Before
    public void setUp(){

        bank = new Bank();
        c = new Customer("john",bank);
        c1 = new Customer("alex", bank);
        e = new Employee("sam", bank);
        c.openJointAccount(new JointAccount(1000),c);
        jointAccount = (JointAccount) c.getAccounts().get(0);
        jointAccount.setCustId(c.getId());
        jointAccount.setCustId_2(c1.getId());
    }

    @Test
    public void testSleep(){
        draw_check = new Runnable5(c1);
        deposit_check = new Runnable6(c);

        t5 = new Thread(deposit_check);
        t6 = new Thread(draw_check);
        t5.start();
        try {
            t5.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }t6.start();


        assertEquals(4000,(int) jointAccount.getBalance());
    }

    @Test
    public void testSleep2(){

        draw_check = new Runnable5(c1);
        deposit_check = new Runnable6(c);
        employee_withdraw = new Runnable4(e,c);

        t5 = new Thread(deposit_check);
        t6 = new Thread(draw_check);
        t7 = new Thread(employee_withdraw);

        t5.start();
        try {
            t5.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } t6.start();
        try {
            t6.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        t7.start();

        assertEquals(3500,(int) jointAccount.getBalance());
    }



}
