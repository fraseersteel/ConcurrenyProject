package bankSystem;

public class Runnable5 implements Runnable {
	
	 private Customer cust;
	 private static final int DELAY = 1000;
	  
	 public Runnable5 (Customer c) {
		 cust=c;
	 }
	 public void run () {
         System.out.println("Customer Withdraw 500 then Check Balance Runnable [Runnable 5] started.");
		 try {
			 
			 Thread.sleep(DELAY);
			 System.out.println("Withdrawing money by " + cust.getName());
			 cust.getAccounts().get(0).withdraw(500);
			
			 System.out.println(cust.getName() + " checks the balance and it's " + cust.getAccounts().get(0).getBalance());
			 
		 }
		 catch (Exception e){

         }
	 }
}
