package bugsTest;

import bankSystem.JointAccount;
import org.junit.Before;
import org.junit.Test;

public class JointAccountTest {

    private JointAccount jointAccount;

    @Before
    public void init() {
        jointAccount = new JointAccount(100);
    }

    @Test
    public void testBug() {
        jointAccount.deposit(100);
    }




}
