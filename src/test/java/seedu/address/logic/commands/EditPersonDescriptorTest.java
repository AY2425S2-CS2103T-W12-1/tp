package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.EditCommand.EditTenantDescriptor;
import seedu.address.testutil.EditTenantDescriptorBuilder;

public class EditPersonDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditTenantDescriptor descriptorWithSameValues = new EditTenantDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditTenantDescriptor editedAmy =
                new EditTenantDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy =
                new EditTenantDescriptorBuilder(DESC_AMY)/* .withPhone(VALID_PHONE_BOB) */.build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy =
                new EditTenantDescriptorBuilder(DESC_AMY)/* .withEmail(VALID_EMAIL_BOB) */.build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different address -> returns false
        editedAmy =
                new EditTenantDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy =
                new EditTenantDescriptorBuilder(DESC_AMY)/* .withTags(VALID_TAG_HUSBAND) */.build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }

    @Test
    public void toStringMethod() {
        EditTenantDescriptor editPersonDescriptor = new EditTenantDescriptor();
        String expected = EditTenantDescriptor.class.getCanonicalName() + "{name="
                + editPersonDescriptor.getName().orElse(null)
                + /*
                   * ", phone=" + editPersonDescriptor.getPhone().orElse(null) + ", email=" +
                   * editPersonDescriptor.getEmail().orElse(null) +
                   */ ", address=" + editPersonDescriptor.getAddress()
                        .orElse(null) /*
                                       * + ", tags=" + editPersonDescriptor.getTags().orElse(null)
                                       */
                + "}";
        assertEquals(expected, editPersonDescriptor.toString());
    }
}
