package bankSystem;

public interface IAccount {
	
	public double getBalance();
	public double setBalance(double bal);
	public int getAccId();
	public void setAccId(int id);
	public void setCustId(int id);
	public void setCustId_2(int id);
	public int getCustId();
	public int getCustId_2();
	
	public void withdraw(double d) throws InterruptedException;
	public void deposit(double d);
	public void transfer(IAccount acc, IAccount acc2, double value) throws InterruptedException;
		
	
}
