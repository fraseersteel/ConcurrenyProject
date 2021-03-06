package coverage;

import java.util.ArrayList;

public class LockTracker {

   private Locks currentLocks;
    private static ArrayList<Locks[]> lockList;
    private int lockCount = 0;
    private int possibleLockPairs;

    public LockTracker() {
        currentLocks = Locks.NoLock;
        lockList = new ArrayList<>();
        //there are 10 possible lock pairs in the joint account class
        possibleLockPairs = 10;
 }

    public void setCurrentLocks(Locks newLocks) {
        if (currentLocks.equals(Locks.NoLock)) {
            currentLocks = newLocks;
        } else {
            addLockPair(currentLocks, newLocks);
            currentLocks = Locks.NoLock;
        }
    }

    public void addLockPair(Locks current, Locks newLock) {
printResults();

        //Check if we already have the pair (current, newLock) or (newLock, current). Add them if we do not.
        for (Locks[] lock : lockList) {
            if ((lock[0].equals(current) && lock[1].equals(newLock))) {

                System.out.println("Naughty: " +  current + " " +newLock);
                return;

            }
        }

        System.out.println(current + " " +newLock);
        Locks[] newPair = new Locks[2];
        newPair[0] = current;
        newPair[1] = newLock;

        lockList.add(newPair);
        lockCount++;

        System.out.println("Lock count: " + getLockCount());

    }

    public int getLocksListSize() {
        return lockList.size();
    }

    public void printResults() {
        System.out.println(" ----------------------------");
        System.out.println("Lock Pairs are as follows: ");


        for (Locks[] locks : lockList) {
            System.out.println(locks[0] + " & " + locks[1]);
        }

        System.out.println("--------------------------");
    }

    public enum Locks {
        GetBalance, SetBalance, Withdraw, Deposit, Transfer, NoLock
    }


    public int getLockCount(){
        return lockCount;
    }


    public double getCoverageScore(){
        double score;

        System.out.println(getLockCount());
        score = (lockCount/possibleLockPairs)*100;
        return score;
    }

}
