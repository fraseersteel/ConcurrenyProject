package bankSystem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Employee extends APerson{
public String name;
public Bank bank;
public int id;
private Lock lock;
private Condition enoughFunds;


public Employee (String name, Bank bank) {
	this.name=name;
	this.bank=bank;
	lock = new ReentrantLock();
	enoughFunds = lock.newCondition();
	
	
}

public synchronized String getName() {
	return name;
}
public synchronized int getId() {
	return id;
}
public synchronized void setId(int id) {
	this.id=id;
}


@Override
public void openAccount(IAccount acc) {

	
}
public void openAccount(IAccount acc, Customer c) {
	synchronized (this) {
	bank.all_accounts.add(acc);
	acc.setAccId(bank.all_accounts.size());
    acc.setCustId(c.getId());
	}
	
}

@Override
public synchronized void closeAccount(int id) {
	for (IAccount acc:bank.all_accounts){
		if (acc.getAccId()==id) {
			bank.all_accounts.remove(acc);
		}
	}
	
	
}
public void deposit (Integer acc_id, double value) {
	lock.lock();
	try {
		
		for (IAccount acc: bank.getAccounts()) {
			if(acc.getAccId()==acc_id) {
				acc.deposit(value);
			}
		}
		enoughFunds.signalAll();
		
	}
	finally {
		lock.unlock();
	}
	
	
	
}
public void withdraw(IAccount acc, double d) throws InterruptedException {
	boolean waiting = true;
	lock.lock();
	try {
		while (acc.getBalance()<d) {
			if (!waiting) 
				Thread.currentThread().interrupt();
				waiting = enoughFunds.await(5, TimeUnit.SECONDS);
			
		}
		acc.setBalance(acc.getBalance()-d);
		
	}
	finally {
		lock.unlock();
	}
	
}

public synchronized void setAccId(IAccount acc, int id) {
	
	acc.setAccId(id);
}
public synchronized void setCustId (IAccount acc,int id) {
	
	acc.setCustId(id);
	
}
public synchronized void setCustId_2(IAccount acc,int id) {

	acc.setCustId_2(id);
}

}
