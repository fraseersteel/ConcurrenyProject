package bankSystem;

public class Runnable3 implements Runnable {
	
	 private Customer cust;
	 private static final int DELAY = 1000;
	  
	 public Runnable3 (Customer c) {
		 cust=c;
	 }

	 public void run () {
         System.out.println("Deposit 1000 Runnable [Runnable 3] started. Thread: "
         + Thread.currentThread().getName());
		 try {
			 
			 Thread.sleep(DELAY);
			 System.out.println("Depositing money by " + cust.getName());
			 cust.getAccounts().get(0).deposit(1000);
			 
		 }
		 catch (Exception e){

         }
	 }
}