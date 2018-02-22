package bankSystem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JointAccount implements IAccount {
    public double balance;
    public double interest;
    public int accID;
    public int custID;
    public int custID_2;
    private Lock lock;
    private Condition enoughFunds;
    private int lockCount;

    public JointAccount(double bal) {
        this.balance = bal;
        lock = new ReentrantLock();
        enoughFunds = lock.newCondition();
        lockCount=0;

    }

    @Override
    public synchronized double getBalance() {

        return balance;
    }

    @Override

    public synchronized double setBalance(double bal) {
        return this.balance = bal;
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

    public synchronized void setCustId_2(int id) {

        this.custID_2 = id;
    }

    @Override
    public void withdraw(double d) throws InterruptedException {
        boolean waiting = true;
        lock.lock();
        lockCount++;
        try {
            while (balance < d) {
                if (!waiting)
                    Thread.currentThread().interrupt();
                waiting = enoughFunds.await(5, TimeUnit.SECONDS);

            }

            balance = balance - d;


        } finally {
            lock.unlock();
        }

    }

    @Override
    public void deposit(double d) {
        lock.lock();
        lockCount++;
        try {

            balance = balance + d;
            enoughFunds.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void transfer(IAccount acc, IAccount acc2, double value) throws InterruptedException {
        //transfers value from acc to to acc2
        synchronized (this) {

        }
        lock.lock();
        lockCount++;
        try {
            acc.withdraw(value);
            acc2.deposit(value);

        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getCustId_2() {

        return custID_2;
    }


}
