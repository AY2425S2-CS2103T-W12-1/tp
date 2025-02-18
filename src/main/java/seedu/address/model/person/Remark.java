package seedu.address.model.person;
import static java.util.Objects.requireNonNull;
/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {
    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A valid remark. Can be any string including an empty string.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    /**
     * Returns the string representation of this remark.
     *
     * @return the remark string
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Compares this Remark to another object to determine equality.
     * Two remarks are considered equal if they have the same string value.
     *
     * @param other the other object to compare against
     * @return true if both remarks have the same value, otherwise false
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
