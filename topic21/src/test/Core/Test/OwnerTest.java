package test.Core.Test;

import home12.Core.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Created by Leonid on 03.05.2016.
 */
@RunWith(JUnit4.class)
public class OwnerTest {
    Owner owner ;

    @Test
    public void creationOwnerTest()
    {
        owner = new Owner(5,"Гена","Букин","789456");
        assertEquals(owner.getOwner_id(), 5);
        assertEquals(owner.getFirstName(), "Гена");
        assertEquals(owner.getLastName(), "Букин");
        assertEquals(owner.getTel(), "789456");
    }

}
