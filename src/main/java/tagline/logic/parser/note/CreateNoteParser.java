package tagline.logic.parser.note;

import tagline.logic.commands.note.CreateNoteCommand;
import tagline.logic.parser.ArgumentMultimap;
import tagline.logic.parser.ArgumentTokenizer;
import tagline.logic.parser.Parser;
import tagline.logic.parser.Prefix;
import tagline.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

import static tagline.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_CONTENT;

public class CreateNoteParser implements Parser<CreateNoteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the CreateNoteCommand
     * and returns an CreateNoteCommand object for execution.
     * @throws tagline.logic.parser.exceptions.ParseException if the user input does not conform the expected format
     */
    public CreateNoteCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_CONTENT);

        if (!arePrefixesPresent(argMultimap, PREFIX_CONTENT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateNoteCommand.MESSAGE_USAGE));
        }

        /* TO ADD ATTRIBUTE PARSING */

        return new CreateNoteCommand();
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
