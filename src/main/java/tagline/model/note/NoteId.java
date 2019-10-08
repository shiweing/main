package tagline.model.note;

import static java.util.Objects.requireNonNull;
import static tagline.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidNoteId(String)}
 */
public class NoteId {


    public static final String MESSAGE_CONSTRAINTS =
            "NoteId numbers should only contain numbers, and it should be at least 3 digits long";
    public static final String VALIDATION_REGEX = "\\d{1,}";
    public final String value;

    /**
     * Constructs a {@code NoteId}.
     *
     * @param idNumber A valid phone number.
     */
    public NoteId(String idNumber) {
        requireNonNull(idNumber);
        checkArgument(isValidNoteId(idNumber), MESSAGE_CONSTRAINTS);
        value = idNumber;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidNoteId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NoteId // instanceof handles nulls
                && value.equals(((NoteId) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
