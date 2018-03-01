package bugsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import bankSystem.*;
import bankSystem.Bank;
import bankSystem.Customer;
import bankSystem.JointAccount;
import bankSystem.Runnable3;
import bankSystem.Runnable5;



public class WrongLockOrNoLockTest {

	Customer c1;
	Customer c;
	
	@Before
	public void setUp(){
		
		
		 Bank bank = new Bank();

	     c = new Customer("john", bank);
	     c1 = new Customer("alex", bank);
	     
	     c.openJointAccount(new JointAccount(1000), c1);
//	     jointAccount = (JointAccount) c.getAccounts().get(0);
//	     jointAccount.setCustId(c.getId());
//	     jointAccount.setCustId_2(c.getId());

	}
	
	@Test
	public void test() {
		
		//runnable checking the account balance
		
	     Runnable3 deposit = new Runnable3 (c);			//bal + 1000
	     Runnable5 withdrawcheck = new Runnable5 (c1);	//bal - 500
	     
	     System.out.println("Bal before run: "+c.getAccounts().get(0).getBalance());
	     
	     Thread t1 = new Thread(deposit);
	     Thread t2 = new Thread(withdrawcheck);
		
		 //two account holders checking the balance
	     t1.start();
	     t2.start();
	     
		try{
	     t1.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted.");
		}
		
		assertEquals(1500,(int) c.getAccounts().get(0).getBalance());
		//Expected = 1500
		//Actual = 2000, after a few runs

	}

}
