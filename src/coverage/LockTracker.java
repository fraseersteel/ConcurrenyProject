package coverage;

import java.util.ArrayList;

public class LockTracker {

    public enum Locks {
        GetBalance, SetBalance, Withdraw, Deposit, Transfer, NoLock
    }

    private Locks currentLocks;
    private ArrayList<Locks[]> lockList;

    public LockTracker(){
        currentLocks = Locks.NoLock;
        lockList = new ArrayList<>();

    }

    public void setCurrentLocks(Locks newLocks){
        if(currentLocks.equals(Locks.NoLock)){
            currentLocks = newLocks;
        }else{
            addLockPair(currentLocks,newLocks);
            currentLocks = Locks.NoLock;
        }
    }


    public void addLockPair(Locks current, Locks newLock){


        for(Locks[] lock : lockList){
            if((lock[0].equals(current) && lock[1].equals(newLock)) || (lock[1].equals(current) && lock[0].equals(newLock))){
                // only do something if they do not match, if they match you dont want to add them again
            }
            else{
                Locks[] newPair = new Locks[2];
                newPair[0] = current;
                newPair[1] = newLock;
                lockList.add(newPair);
            }
        }
    }

    public int getLocksListSize(){
        return lockList.size();
    }

    public void printResults(){
        System.out.println(" ----------------------------");
        System.out.println("Lock Pairs are as follows: ");

        for(Locks[] locks: lockList){
            System.out.println(locks[0] + " & " + locks[1]);
        }
    }


}
