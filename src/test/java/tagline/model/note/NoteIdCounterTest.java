package tagline.model.note;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static tagline.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NoteIdCounterTest {

    //@Test
    //public void constructor_null_throwsNullPointerException() {
    //    assertThrows(NullPointerException.class, () -> new Name(null));
    //}

    @Test
    public void setZero_test() {
        long currCount = NoteIdCounter.getCount();
        NoteIdCounter.setZero();

        NoteIdCounter.setZero();
        assertEquals(0, NoteIdCounter.getCount());

        NoteIdCounter.setCount(50);
        assertEquals(50, NoteIdCounter.getCount());
        NoteIdCounter.setZero();
        assertEquals(0, NoteIdCounter.getCount());

        assertEquals(1, NoteIdCounter.incrementThenGetValue());
        assertEquals(1, NoteIdCounter.getCount());
        NoteIdCounter.setZero();
        assertEquals(0, NoteIdCounter.getCount());

        NoteIdCounter.setCount(currCount);
    }

    @Test
    public void getThenIncrement_test() {
        //doesnt work now, create a separate class
        long currCount = NoteIdCounter.getCount();
        NoteIdCounter.setZero();

        assertEquals(0, NoteIdCounter.getCount());

        assertEquals(1, NoteIdCounter.incrementThenGetValue());
        assertEquals(1, NoteIdCounter.getCount());

        assertEquals(2, NoteIdCounter.incrementThenGetValue());
        assertEquals(2, NoteIdCounter.getCount());

        assertEquals(3, NoteIdCounter.incrementThenGetValue());
        assertEquals(3, NoteIdCounter.getCount());


        NoteIdCounter.setCount(currCount);
    }

    //@Test
    //public void toString_test() {
    //    NoteId one = new NoteId();
    //    assertEquals("00001", one.toString());

    //    NoteId two = new NoteId();
    //    assertEquals("00002", two.toString());

    //    NoteId fifty = new NoteId(50);
    //    assertEquals("00050", fifty.toString());

    //    NoteId hundred = new NoteId(100);
    //    assertEquals("00100", hundred.toString());

    //    NoteId twoThousand = new NoteId(2000);
    //    assertEquals("02000", twoThousand.toString());

    //    NoteId fortyTwoThousand = new NoteId(42000);
    //    assertEquals("42000", fortyTwoThousand.toString());

    //    NoteId fiveNines = new NoteId(99999);
    //    assertEquals("99999", fiveNines.toString());

    //    NoteId countdown = new NoteId(54321);
    //    assertEquals("54321", countdown.toString());
    //}

    //@Test
    //public void equals_test() {

    //    NoteId one = new NoteId();
    //    assertTrue(one.equals(new NoteId(1)));

    //    NoteId two = new NoteId();
    //    assertTrue(two.equals(new NoteId(2)));

    //    NoteId fifty = new NoteId(50);
    //    assertTrue(fifty.equals(new NoteId(50)));

    //}

}
