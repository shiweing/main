package tagline.model.note;

//import static java.util.Objects.requireNonNull;
//import static tagline.commons.util.AppUtil.checkArgument;

/**
 * Represents a Note's content in the note book.
 * Guarantees: immutable; is valid as declared in
 */
public class NoteIdCounter {

    public static final String MESSAGE_CONSTRAINTS = "NoteIdCounter can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    //public static final String VALIDATION_REGEX = "[^\\s].*";

    //public final String value;
    private static long counter;

    ///**
    // * Constructs an {@code NoteIdCounter}.
    // *
    // * @param preset A valid content.
    // */
    //public NoteIdCounter(long preset) {
    //    requireNonNull(preset);
    //    //checkArgument(isValidNoteIdCounter(content), MESSAGE_CONSTRAINTS);
    //    counter = Long.valueOf(preset);
    //}

    //this is a static class only
    private NoteIdCounter() {
        //counter = Long.valueOf(0);
    }

    public static void setCount(long newCount) {
        counter = newCount; //Long.valueOf(0);
    }

    public static void setZero() {
        counter = 0; //Long.valueOf(0);
    }

    // increment then getValue
    public static long getThenIncrement() {
        ++counter;
        return counter;
    }

    public static long getCount() {
        return counter;
    }

    //@Override
    //public String toString() {
    //    return String.valueOf(counter);
    //}

    //@Override
    //public boolean equals(Object other) {
    //    return other == this // short circuit if same object
    //            || (other instanceof NoteIdCounter // instanceof handles nulls
    //            && counter.equals(((NoteIdCounter) other).counter)); // state check
    //}

    //@Override
    //public int hashCode() {
    //    return counter.hashCode();
    //}

}
