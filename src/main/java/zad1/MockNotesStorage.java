package zad1;

import java.util.ArrayList;
import java.util.List;

public class MockNotesStorage implements NotesStorage {

    private final List<Note> notes = new ArrayList<>();

    @Override
    public void add(Note note){
        if(note==null) throw new NullPointerException();
        notes.add(note);
    }

    @Override
    public List<Note> getAllNotesOf(String name) {
        return notes;
    }

    @Override
    public void clear() {
        notes.clear();
    }
}
