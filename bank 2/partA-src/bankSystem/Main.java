package bankSystem;


public class Main {
		
		private static final int DELAY = 3000;
		
	    public static void main(String args[]) {
	    	Bank bank = new Bank();
	    	
	    	Customer c = new Customer("john", bank);
	    	Customer c1 = new Customer("alex", bank);
	    	Customer c2 = new Customer("amy", bank);
	    	
	    	Employee e = new Employee("sam", bank);
	    	Employee e1 = new Employee("eliot", bank);

	    	
	        c.openJointAccount(new JointAccount(1000), c1);
	    	

             //runnable checking the account balance   	
	    	Runnable1 check_bal = new Runnable1 (c);
	    	Runnable1 check_bal2 = new Runnable1 (c1);
	    	
	    	//runnable withdrawing from the balance  
	    	Runnable2 draw = new Runnable2 (c1);
	    	
	    	//runnable depositing money
	    	Runnable3 deposit = new Runnable3 (c);
	    	
	    	//runnable withdrawing from the balance and checking 
	    	Runnable5 draw_check = new Runnable5 (c1);
	    	
	    	//runnable depositing money and checking
	    	Runnable6 deposit_check = new Runnable6 (c);
	    	
	    	//runnable for employee withdrawing money
	    	//note - the runnable deposits into the customer's first account in the array
	    	Runnable4 employee_withdraw = new Runnable4(e, c);
	    	
	    	//runnable withdrawing from the balance and checking 
	    	Runnable7 empl_change_details = new Runnable7 (e, c);
	    	//runnable depositing money and checking
	    	Runnable8 empl_change_details2 = new Runnable8 (e1, c);
	    	
	    	Thread t1 = new Thread(check_bal);
	    	Thread t2 = new Thread(check_bal2);
	    	
	    	Thread t3 = new Thread(check_bal);
	    	Thread t4 = new Thread(draw);
	    	
	    	Thread t5 = new Thread(deposit_check);
	    	Thread t6 = new Thread(draw_check);
	    	
	    	
	    	Thread t7 = new Thread(employee_withdraw);
	    	
	    	Thread t8 = new Thread(deposit);
	    	
	    	Thread t9 = new Thread(empl_change_details);
	    	Thread t10 = new Thread(empl_change_details2);
	    	
	    	
	    	//two account holders checking the balance
	    //	t1.start();
	   // 	t2.start();
	    	//one is checking balance, one is withdrawing
//	    	t3.start();
//	    	t4.start();
	    	//one is depositing and checking balance, the other is withdrawing and checking balance
  //       t5.start();
   //       t6.start();
	    	//one is depositing and checking balance, the other is withdrawing and checking balance
	    	//and an employee is doing a withdraw
//         t5.start();
//	    	t6.start();
//	    	t7.start();
			//Insufficient funds
			//For a deposit to be made in time, change runnable1’s delay to 8000 and runnable3’s delay to 3000, runnable2’s withdraw value to 1500.
			//For a deposit to not be made in time, change runnable1’s delay to 8000 and runnable3’s delay to 7000, runnable2’s withdraw value to 1500.
//	    	t4.start();
//	    	t8.start();
//	    	t1.start();
            //two employees are trying to change account details simultaneously 
	    	//t9.start();
	    	//t10.start();
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	        
	       
	    }

	
	

	    
}
