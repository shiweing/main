package tagline.testutil;

import java.util.HashSet;
import java.util.Set;

import tagline.model.person.Address;
import tagline.model.person.Email;
import tagline.model.person.Name;
import tagline.model.note.Note;
import tagline.model.note.Title;
import tagline.model.note.Content;
import tagline.model.note.TimeLastEdited;
import tagline.model.note.TimeCreated;
import tagline.model.note.NoteId;
import tagline.model.person.Phone;
import tagline.model.tag.Tag;
import tagline.model.util.SampleDataUtil;

import static tagline.model.note.Date.HUMAN_READABLE_FORMATTER;
import static tagline.model.note.Date.timezone;

/**
 * A utility class to help with building Note objects.
 */
public class NoteBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";



    private Name name;
    private Phone phone;
    private Email email;
    private Address address;

    public static final String DEFAULT_TITLE= "The Protector Initiative";
    public static final String DEFAULT_CONTENT= "Phase 1:\n A response team comprised "
        + "of the most able individuals humankind has to offer. The Initiative will "
        + "defend Earth from imminent global threats that are beyond the warfighting "
        + "capability of conventional military forces.";
    //public static final String DEFAULT_EMAIL = "alice@gmail.com";
    //public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Title title;
    private Content content;
    private TimeCreated timeCreated;
    private TimeLastEdited timeLastEdited;
    private Set<Tag> tags;

    public NoteBuilder() {
        title = new Title(DEFAULT_TITLE);
        content = new Content(DEFAULT_CONTENT);
        //refactor These two classes to return with the same Instant instance
        timeCreated = new TimeCreated();
        timeLastEdited = new TimeLastEdited();

        tags = new HashSet<>();
    }

    /**
     * Initializes the NoteBuilder with the data of {@code personToCopy}.
     */
    public NoteBuilder(Note noteToCopy) {
        title = noteToCopy.getTitle();
        content = noteToCopy.getContent();
        timeCreated = noteToCopy.getTimeCreated();
        timeLastEdited = noteToCopy.getTimeLastEdited();
        title = noteToCopy.getTitle();

        tags = new HashSet<>(noteToCopy.getTags());
    }

    /**
     * Sets the {@code Title} of the {@code Note} that we are building.
     */
    public NoteBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Note} that we are building.
     */
    public NoteBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Content} of the {@code Note} that we are building.
     */
    public NoteBuilder withContent(String content) {
        this.content = new Content(content);
        return this;
    }

    /**
     * Sets the {@code TimeCreated} of the {@code Note} that we are building.
     */
    public NoteBuilder withTimeCreated(String timestamp) {
        // need to add new feature into Date thingy
        this.timeCreated = new TimeCreated();
        return this;
    }

    /**
     * Sets the {@code TimeLastEdited} of the {@code Note} that we are building.
     */
    public NoteBuilder withTimeLastUpdated(String timestamp) {
        this.timeLastEdited = new TimeLastEdited();
        return this;
    }

    public Note build() {
        return new Note(title, content, timeCreated, timeLastEdited, tags);
    }

}
