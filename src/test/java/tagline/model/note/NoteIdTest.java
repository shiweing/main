package tagline.model.note;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static tagline.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NoteIdTest {

    //@Test
    //public void constructor_null_throwsNullPointerException() {
    //    assertThrows(NullPointerException.class, () -> new Name(null));
    //}

    @Test
    public void constructor_sequentialId() {
        //doesnt work now, create a separate class
        long currCount = NoteIdCounter.getCount();
        NoteIdCounter.setZero();

        assertEquals(0, NoteIdCounter.getCount());

        NoteId one = new NoteId();
        assertEquals(1, one.value);

        NoteId two = new NoteId();
        assertEquals(2, two.value);

        NoteId fifty = new NoteId(50);
        assertEquals(50, fifty.value);

        NoteIdCounter.setCount(currCount);
    }

    @Test
    public void toString_test() {
        NoteId one = new NoteId();
        assertTrue(one.toString().equals("00001"));
        //assertEquals("00001", one.toString());

        NoteId two = new NoteId();
        assertTrue(two.toString().equals("00002"));
        //assertEquals("00002", two.toString());

        NoteId fifty = new NoteId(50);
        assertTrue(fifty.toString().equals("00050"));
        //assertEquals("00050", fifty.toString());

        NoteId hundred = new NoteId(100);
        assertTrue(hundred.toString().equals("00100"));
        //assertEquals("00100", hundred.toString());

        NoteId twoThousand = new NoteId(2000);
        assertTrue(twoThousand.toString().equals("02000"));
        //assertEquals("02000", twoThousand.toString());

        NoteId fortyTwoThousand = new NoteId(42000);
        assertTrue(fortyTwoThousand.toString().equals("42000"));
        //assertEquals("42000", fortyTwoThousand.toString());

        NoteId fiveNines = new NoteId(99999);
        assertTrue(fiveNines.toString().equals("99999"));
        //assertEquals("99999", fiveNines.toString());

        NoteId countdown = new NoteId(54321);
        assertTrue(countdown.toString().equals("54321"));
        //assertEquals("54321", countdown.toString());
    }

    @Test
    public void equals_test() {

        //NoteId one = new NoteId();
        //assertTrue(one.equals(new NoteId(1)));

        //NoteId two = new NoteId();
        //assertTrue(two.equals(new NoteId(2)));

        //NoteId fifty = new NoteId(50);
        //assertTrue(fifty.equals(new NoteId(50)));

    }

}
