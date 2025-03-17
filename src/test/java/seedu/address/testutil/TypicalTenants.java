package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FAMILY_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FAMILY_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GIVEN_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GIVEN_NAME_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TenantTracker;
import seedu.address.model.tenant.Tenant;

/**
 * A utility class containing a list of {@code Tenant} objects to be used in tests.
 */
public class TypicalTenants {

    public static final Tenant ALICE =
            new TenantBuilder().withName("Alice", "Pauline").withAddress("123, Jurong West Ave 6, #08-111, 123456")
                    // .withEmail("alice@example.com").withPhone("94351253").withTags("friends")
                    .build();
    public static final Tenant BENSON =
            new TenantBuilder().withName("Benson", "Meier").withAddress("311, Clementi Ave 2, #02-25, 123456")
                    /* .withPhone("98765432").withTags("owesMoney", "friends") */.build();
    public static final Tenant CARL = new TenantBuilder().withName("Carl", "Kurz")
            /* .withPhone("95352563").withEmail("heinz@example.com") */
            .withAddress("wall street, 123456").build();
    public static final Tenant DANIEL = new TenantBuilder().withName("Daniel", "Meier")
            /* .withPhone("87652533").withEmail("cornelia@example.com") */
            .withAddress("10th street, 123456")/* .withTags("friends") */.build();
    public static final Tenant ELLE = new TenantBuilder().withName("Elle", "Meyer")
            /* .withPhone("9482224").withEmail("werner@example.com") */
            .withAddress("michegan ave, 123456").build();
    public static final Tenant FIONA = new TenantBuilder().withName("Fiona", "Kunz")
            /* .withPhone("9482427").withEmail("lydia@example.com") */
            .withAddress("little tokyo, 123456").build();
    public static final Tenant GEORGE = new TenantBuilder().withName("George", "Best")
            /* .withPhone("9482442").withEmail("anna@example.com") */
            .withAddress("4th street, 123456").build();

    // Manually added
    public static final Tenant HOON = new TenantBuilder().withName("Hoon", "Meier")
            /* .withPhone("8482424").withEmail("stefan@example.com") */
            .withAddress("little india, 123456").build();
    public static final Tenant IDA = new TenantBuilder().withName("Ida", "Mueller")
            /* .withPhone("8482131").withEmail("hans@example.com") */
            .withAddress("chicago ave, 123456").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Tenant AMY = new TenantBuilder().withName(VALID_GIVEN_NAME_AMY, VALID_FAMILY_NAME_AMY)
            /* .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY) */
            .withAddress(VALID_ADDRESS_AMY)/* .withTags(VALID_TAG_FRIEND) */.build();
    public static final Tenant BOB = new TenantBuilder().withName(VALID_GIVEN_NAME_BOB, VALID_FAMILY_NAME_BOB)
            // .withPhone(VALID_PHONE_BOB) .withEmail(VALID_EMAIL_BOB)
            .withAddress(VALID_ADDRESS_BOB)
            // .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalTenants() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static TenantTracker getTypicalTenantTracker() {
        TenantTracker ab = new TenantTracker();
        for (Tenant tenant : getTypicalTenants()) {
            ab.addTenant(tenant);
        }
        return ab;
    }

    public static List<Tenant> getTypicalTenants() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
