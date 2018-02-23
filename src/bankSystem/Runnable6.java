package bankSystem;

public class Runnable6 implements Runnable {
	
	 private Customer cust;
	 private static final int DELAY = 1000;
	  
	 public Runnable6 (Customer c) {
		 cust=c;
	 }
	 public void run () {
         System.out.println("Customer Deposit 3000 then Check Balance Runnable [Runnable 6] started."
         + "Thread: " + Thread.currentThread().getName());
		 try {
			 Thread.sleep(DELAY);
			 System.out.println("Depositing money by " + cust.getName());
			 cust.getAccounts().get(0).deposit(3000);
			
			 System.out.println(cust.getName() + " checks the balance and it's " + cust.getAccounts().get(0).getBalance());
			 
		 }
		 catch (Exception e){

         }
	 }
}