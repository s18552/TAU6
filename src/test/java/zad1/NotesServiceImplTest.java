package zad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotesServiceImplTest {
    private NotesServiceImpl notesService;

    @BeforeEach
    public void setup(){
        NotesStorage notesStorage = new MockNotesStorage();
        this.notesService=NotesServiceImpl.createWith(notesStorage);
    }


    @Test
    public void checkInstance() {
        assertEquals(notesService.getClass(), NotesServiceImpl.class);
    }

    @Test
    public void testAddNotesToList() {
        //given
        int size = notesService.getList("a").size();

        //when
        notesService.add(new Note("a", 1f));

        //then
        assertTrue(size != 1);
    }

    @Test
    public void testIfListIsEmpty() {
        //given
        notesService.add(new Note("a", 1f));
        notesService.add(new Note("b", 2f));
        notesService.add(new Note("c", 3f));

        //when
        notesService.clear();

        //then
        assertTrue(notesService.getList("").isEmpty());
    }

    @Test
    public void checkIfNoteIsNullWhileAddingToList() {
        assertThrows(NullPointerException.class, () -> notesService.add(null));
    }

    @Test
    public void checkAddedNotes() {
        //given
        Note c = new Note("c", 4f);
        notesService.add(new Note("a", 1f));
        notesService.add(new Note("b", 3f));
        notesService.add(c);

        //when
        List<Note> allNotesOf = notesService.getList("");

        //then
        assertTrue(allNotesOf.contains(c));

    }
    @Test
    public void testOfAverageResult(){
        //given
        notesService.add(new Note("a",2.32f));
        notesService.add(new Note("a",3.24f));
        notesService.add(new Note("c",2.32f));

        //when
        float result = notesService.averageOf("a");

        assertEquals(result,2.626666784286499);
    }

    @AfterEach
    public void tearDown(){
        this.notesService=null;
    }



}