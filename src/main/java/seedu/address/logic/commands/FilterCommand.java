package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.tenant.AddressContainsKeywordsPredicate;

/**
 * Filters for all persons in address book whose address contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class FilterCommand extends Command {
    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Filters all persons whose addresses contain any of "
        + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: KEYWORD [MORE_KEYWORDS]...\n" + "Example: " + COMMAND_WORD
        + " Kent Ridge";

    private final AddressContainsKeywordsPredicate predicate;

    public FilterCommand(AddressContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTenantList(predicate);
        return buildCommandResult(String.format(Messages.MESSAGE_TENANTS_LISTED_OVERVIEW,
            model.getFilteredTenantList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterCommand)) {
            return false;
        }

        FilterCommand otherFilterCommand = (FilterCommand) other;
        return predicate.equals(otherFilterCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("predicate", predicate).toString();
    }
}
