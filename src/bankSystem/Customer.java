package bankSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer extends APerson{
    public String name;
    public Bank bank;
    public int id;

    //public ArrayList<bankSystem.IAccount> accounts = new ArrayList<bankSystem.IAccount>();


    public Customer (String name, Bank bank) {
        this.name=name;
        this.bank=bank;
        bank.addCustomer(this);
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
    public synchronized ArrayList<IAccount> getAccounts() {
        ArrayList<IAccount> accounts = new ArrayList<IAccount>();
        for (IAccount acc: bank.all_accounts) {
            if (acc.getCustId()==this.id  || acc.getCustId_2()==this.id)
                accounts.add(acc);
        }
        return accounts;
    }

    @Override
    public void openAccount(IAccount acc) {
        synchronized (this){
        bank.all_accounts.add(acc);
        acc.setAccId(bank.all_accounts.size()+1111);
        acc.setCustId(this.id);
        }

    }
    @Override
    public void openJointAccount(JointAccount acc, Customer c) {
        synchronized (this){
        bank.all_accounts.add(acc);
        acc.setAccId(bank.all_accounts.size()+1111);
        acc.setCustId(this.id);
        acc.setCustId_2(c.getId());

        }

    }

    @Override
    public synchronized void closeAccount(int id) {

        for (Iterator<IAccount> it = bank.all_accounts.iterator(); it.hasNext(); ) {
            IAccount acc = it.next();
            if (acc.getAccId()==id) {
                it.remove();
            }
        }
    }

}
