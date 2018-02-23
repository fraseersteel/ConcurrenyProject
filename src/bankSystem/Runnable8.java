package bankSystem;

public class Runnable8 implements Runnable {
	
	 private Employee emp;
	 private Customer cust;
	 private static final int DELAY = 1000;
	  
	 public Runnable8 (Employee employee, Customer c) {
		emp=employee;
		cust=c;
	 }
	 public void run () {
         System.out.println("Employee Change Account ID to 3456 and Check Account ID Runnable [Runnable 8] started.");
		 try {
			 
			 Thread.sleep(DELAY);
			 System.out.println("Changing account id by employee " + emp.getName());
			 emp.setAccId(cust.getAccounts().get(0), 3456);
			 System.out.println("id is now "+ cust.getAccounts().get(0).getAccId());

		 }
		 catch (Exception e){

         }
	 }
}