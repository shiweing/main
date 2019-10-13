package tagline.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static tagline.testutil.Assert.assertThrows;
import static tagline.testutil.TypicalNotes.PROTECTOR;
import static tagline.testutil.TypicalNotes.TOKYO;
import static tagline.testutil.TypicalNotes.EARTH;
//import static tagline.testutil.TypicalNotes.ALICE;
//import static tagline.testutil.TypicalNotes.HOON;
//import static tagline.testutil.TypicalNotes.IDA;
import static tagline.testutil.TypicalNotes.getTypicalNoteBook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import tagline.commons.exceptions.DataConversionException;
import tagline.model.NoteBook;
import tagline.model.ReadOnlyNoteBook;

public class JsonNoteBookStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonNoteBookStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readNoteBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readNoteBook(null));
    }

    private java.util.Optional<ReadOnlyNoteBook> readNoteBook(String filePath) throws Exception {
        return new JsonNoteBookStorage(Paths.get(filePath)).readNoteBook(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readNoteBook("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readNoteBook("notJsonFormatNoteBook.json"));
    }

    @Test
    public void readNoteBook_invalidNoteNoteBook_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readNoteBook("invalidNoteNoteBook.json"));
    }

    @Test
    public void readNoteBook_invalidAndValidNoteNoteBook_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readNoteBook("invalidAndValidNoteNoteBook.json"));
    }

    @Test
    public void readAndSaveNoteBook_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempNoteBook.json");
        //to get a copy of how the JSON is stored as
        //Path filePath2 = TEST_DATA_FOLDER.resolve("TempNoteBook2.json");
        NoteBook original = getTypicalNoteBook();
        JsonNoteBookStorage jsonNoteBookStorage = new JsonNoteBookStorage(filePath);

        // Save in new file and read back
        jsonNoteBookStorage.saveNoteBook(original, filePath);
        //jsonNoteBookStorage.saveNoteBook(original, filePath2);
        ReadOnlyNoteBook readBack = jsonNoteBookStorage.readNoteBook(filePath).get();
        assertEquals(original, new NoteBook(readBack));

        // Modify data, overwrite exiting file, and read back
        original.addNote(TOKYO);
        original.removeNote(PROTECTOR);
        jsonNoteBookStorage.saveNoteBook(original, filePath);
        //jsonNoteBookStorage.saveNoteBook(original, filePath2);
        readBack = jsonNoteBookStorage.readNoteBook(filePath).get();
        assertEquals(original, new NoteBook(readBack));

        // Save and read without specifying file path
        original.addNote(EARTH);
        jsonNoteBookStorage.saveNoteBook(original); // file path not specified
        //jsonNoteBookStorage.saveNoteBook(original, filePath2);
        readBack = jsonNoteBookStorage.readNoteBook().get(); // file path not specified
        assertEquals(original, new NoteBook(readBack));

    }

    @Test
    public void saveNoteBook_nullNoteBook_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveNoteBook(null, "SomeFile.json"));
    }

    /**
     * Saves {@code addressBook} at the specified {@code filePath}.
     */
    private void saveNoteBook(ReadOnlyNoteBook addressBook, String filePath) {
        try {
            new JsonNoteBookStorage(Paths.get(filePath))
                    .saveNoteBook(addressBook, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveNoteBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveNoteBook(new NoteBook(), null));
    }
}
