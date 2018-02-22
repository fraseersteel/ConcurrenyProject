package bankSystem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavingsAccount implements IAccount {
	public double balance;
	public double interest;
	public int accID;
	public int custID;
	private Lock lock;
	private Condition enoughFunds;

	public SavingsAccount(double balance) {
		this.balance = balance;
		lock = new ReentrantLock();
		enoughFunds = lock.newCondition();
	}

	@Override
	public synchronized double getBalance() {

		return balance;
	}

	@Override
	public synchronized double setBalance(double bal) {
		return this.balance = bal;
	}

	public synchronized void setInterest(double d) {

		interest = d;
	}

	public synchronized double getInterest() {

		return interest;
	}

	public synchronized void addInterest() {

		balance = balance + interest;
	}

	@Override
	public synchronized int getAccId() {

		return accID;
	}

	public synchronized void setAccId(int id) {

		this.accID = id;
	}

	@Override
	public synchronized int getCustId() {

		return custID;
	}

	public synchronized void setCustId(int id) {

		this.custID = id;
	}

	@Override
	public synchronized void withdraw(double d) throws InterruptedException {
		boolean waiting = true;
		lock.lock();
		try {
			while (balance<d) {
				if (!waiting) 
					Thread.currentThread().interrupt();
					waiting = enoughFunds.await(5, TimeUnit.SECONDS);
				
			}
			balance=balance-d;
			
		}
		finally {
			lock.unlock();
		}
		
	}
	@Override
	public synchronized void deposit(double d) {
		lock.lock();
		try {
			
			balance=balance+d;
			enoughFunds.signalAll();
			
		}
		finally {
			lock.unlock();
		}
	}
	public void transfer(IAccount acc, IAccount acc2, double value) throws InterruptedException {
		//transfers value from acc to to acc2
		synchronized(this) {
			
		}
		lock.lock();
		try {
			acc.withdraw(value);
			acc2.deposit(value);
			
		}
		finally {
			lock.unlock();
		}
	}

	@Override
	public int getCustId_2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCustId_2(int id) {
		// TODO Auto-generated method stub
		
	}


}
