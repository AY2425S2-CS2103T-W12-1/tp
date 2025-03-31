package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ArchiveCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.MapCommand;
import seedu.address.logic.commands.ShowArchiveCommand;
import seedu.address.logic.commands.UnarchiveCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class TenantTrackerParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Logger logger = LogsCenter.getLogger(TenantTrackerParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        // Note to developers: Change the log level in config.json to enable lower level (i.e.,
        // FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);

        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments, userInput);

        case ArchiveCommand.COMMAND_WORD:
            return new ArchiveCommandParser().parse(arguments, userInput);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments, userInput);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments, userInput);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand().withUserInput(userInput);

        case FilterCommand.COMMAND_WORD:
            return new FilterCommandParser().parse(arguments, userInput);

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments, userInput);

        case ListCommand.COMMAND_WORD:
            return new ListCommand().withUserInput(userInput);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand().withUserInput(userInput);

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand().withUserInput(userInput);

        case MapCommand.COMMAND_WORD:
            return new MapCommandParser().parse(arguments, userInput);

        case ShowArchiveCommand.COMMAND_WORD:
            return new ShowArchiveCommand();

        case UnarchiveCommand.COMMAND_WORD:
            return new UnarchiveCommandParser().parse(arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
