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
		 try {
			 
			 Thread.sleep(DELAY);
			 System.out.println("Changing account id by employee " + emp.getName());
			 emp.setAccId(cust.getAccounts().get(0), 3456);
			 System.out.println("id is now "+ cust.getAccounts().get(0).getAccId());

			 
			 
		 }
		 catch (Exception e){}
	 }
	 
	}