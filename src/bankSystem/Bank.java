package bankSystem;

import java.util.ArrayList;

public class Bank {
	ArrayList<Customer> customers = new ArrayList<Customer>();      //Any classes in the package can access this without protection
	ArrayList<Employee> employees = new ArrayList<Employee>();      //Any classes in the package can access this without protection
	ArrayList<IAccount> all_accounts = new ArrayList<IAccount>();   //Any classes in the package can access this without protection
	
	void addCustomer(Customer customer){
		synchronized (this){
            customers.add(customer);
		    customer.setId(customers.size()+1000);
		}
	}
	
	synchronized Customer getCustomer(int id){
		for (Customer c: customers) {
			if (c.getId()==id)
				return c;
		}
		return null;
	}
	
	void addEmployee(Employee e){
		synchronized (this){
		employees.add(e);
		e.setId(employees.size());
		}
	}
	
	synchronized Employee getEmployee(int id){
		for (Employee e: employees) {
			if (e.getId()==id)
				return e;
		}
		return null;
	}
	
	synchronized void  addAccount(IAccount acc){
		all_accounts.add(acc);
	}
	
	synchronized ArrayList<Customer> getCustomers() {
		return customers;
	}
	synchronized ArrayList<IAccount> getAccounts() {
		return all_accounts;
	}
	synchronized ArrayList<Employee> getEmployees() {
		return employees;
	}

}
