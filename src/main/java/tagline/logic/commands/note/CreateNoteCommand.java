package tagline.logic.commands.note;

import static java.util.Objects.requireNonNull;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_CONTENT;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_TITLE;

import tagline.logic.commands.CommandResult;
import tagline.logic.commands.exceptions.CommandException;
import tagline.model.Model;
import tagline.model.note.Note;

/**
 * Creates a new note.
 */
public class CreateNoteCommand extends NoteCommand {

    public static final String COMMAND_WORD = "create";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a new note. "
            + "Parameters: "
            + PREFIX_TITLE + "TITLE "
            + PREFIX_CONTENT + "CONTENT\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "CS2103T TP"
            + PREFIX_CONTENT + "CS2103T meeting on Wednesday";

    public static final String MESSAGE_SUCCESS = "New note added: %1$s";

    private final Note toCreate;

    /**
     * Creates a CreateNoteCommand to add the specified {@code Note}
     */
    public CreateNoteCommand(Note note) {
        requireNonNull(note);
        toCreate = note;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        /* TO ADD EXECUTE LOGIC */

        return new CommandResult(String.format(MESSAGE_SUCCESS, "toAdd"));
    }

    public boolean equalsIgnoreDate(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CreateNoteCommand // instanceof handles nulls
                && toCreate.getNoteId().equals(((CreateNoteCommand) other).toCreate.getNoteId())
                && toCreate.getContent().equals(((CreateNoteCommand) other).toCreate.getContent())
                && toCreate.getTags().equals(((CreateNoteCommand) other).toCreate.getTags()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CreateNoteCommand // instanceof handles nulls
                && toCreate.getNoteId().equals(((CreateNoteCommand) other).toCreate.getNoteId())
                && toCreate.getTitle().equals(((CreateNoteCommand) other).toCreate.getTitle())
                && toCreate.getContent().equals(((CreateNoteCommand) other).toCreate.getContent())
                && toCreate.getTags().equals(((CreateNoteCommand) other).toCreate.getTags()));
    }
}
