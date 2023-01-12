package zad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotesStorageTest {

    private NotesStorage notesStorage;

    @BeforeEach
    public void setUp() {
        this.notesStorage = new MockNotesStorage();
    }

    @Test
    public void checkInstance() {
        assertEquals(notesStorage.getClass(), MockNotesStorage.class);
    }

    @Test
    public void testAddNotesToList() {
        //given
        int size = notesStorage.getAllNotesOf("").size();

        //when
        notesStorage.add(new Note("a", 1f));

        //then
        assertTrue(size != 1);
    }

    @Test
    public void testIfListIsEmpty() {
        //given
        notesStorage.add(new Note("a", 1f));
        notesStorage.add(new Note("b", 2f));
        notesStorage.add(new Note("c", 3f));

        //when
        notesStorage.clear();

        //then
        assertTrue(notesStorage.getAllNotesOf("").isEmpty());
    }

    @Test
    public void checkIfNoteIsNullWhileAddingToList() {
        assertThrows(NullPointerException.class, () -> notesStorage.add(null));
    }

    @Test
    public void checkAddedNotes(){
        //given
        Note c = new Note("c", 4f);
        notesStorage.add(new Note("a",1f));
        notesStorage.add(new Note("b",3f));
        notesStorage.add(c);

        //when
        List<Note> allNotesOf = notesStorage.getAllNotesOf("");

        //then
        assertTrue(allNotesOf.contains(c));

    }

    @AfterEach
    public void tearDown() {
        this.notesStorage = null;
    }


}