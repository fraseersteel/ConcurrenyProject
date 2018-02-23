package bankSystem;

public class Runnable7 implements Runnable {
	
	 private Employee emp;
	 private Customer cust;
	 private static final int DELAY = 1000;
	  
	 public Runnable7 (Employee employee, Customer c) {
		emp=employee;
		cust=c;
	 }
	 public void run () {
         System.out.println("Employee Change Account ID to 2345  and Check Account ID Runnable [Runnable 7] started."
         + "Thread: " + Thread.currentThread().getName());
		 try {
			 
			 Thread.sleep(DELAY);
			 System.out.println("Changing account id by employee " + emp.getName());
			 emp.setAccId(cust.getAccounts().get(0), 2345);
			 System.out.println("id is now "+ cust.getAccounts().get(0).getAccId());
			
			// System.out.println(cust.getAccounts().get(0).getBalance());
			// System.out.println("Balance is " + cust.getAccounts().get(0).getBalance());
			 
		 }
		 catch (Exception e){

         }
	 }
}
