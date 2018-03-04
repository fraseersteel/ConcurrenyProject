package coverage;

import bankSystem.ConTests;

public class CoverageDriver {

    public static void main(String[] args) throws InterruptedException {

        ConTests conTests = new ConTests();
        LockTracker lockTracker = new LockTracker();

        conTests.driver1Test();
        Thread.sleep(1000);
        System.out.println(" ---------------------");
        System.out.println();

        conTests.driver2Test();
        Thread.sleep(1000);
        System.out.println(" ---------------------");
        System.out.println();

        conTests.driver3Test();
        Thread.sleep(1000);
        System.out.println(" ---------------------");
        System.out.println();

        conTests.driver4Test();
        Thread.sleep(1000);
        System.out.println(" ---------------------");
        System.out.println();

        conTests.driver5Test();
        Thread.sleep(1000);
        System.out.println(" ---------------------");
        System.out.println();

        conTests.driver6Test();
        Thread.sleep(3000);


        System.out.println(" ---------------------");
        System.out.print(" locks ");
        lockTracker.printResults();

        System.out.println("coverage result it: " + lockTracker.getCoverageScore());




    }
}