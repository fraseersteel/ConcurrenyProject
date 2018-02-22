package bankSystem;

public abstract class APerson {
	
	String name;
	
    
    
	abstract	public String getName();
	abstract	public int getId();
	
	abstract	public void openAccount(IAccount acc);
	
	abstract	public void closeAccount(int id);
	public void openJointAccount(JointAccount acc, Customer c) {
	
		
	}
		
	

}
