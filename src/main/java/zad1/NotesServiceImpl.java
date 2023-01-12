package zad1;

import java.util.Collection;
import java.util.List;

public class NotesServiceImpl implements NotesService {

    private final NotesStorage storageService;

    public static NotesServiceImpl createWith(final NotesStorage storageService) {
        return new NotesServiceImpl(storageService);
    }

    @Override
    public void add(Note note) {
        storageService.add(note);
    }

    @Override
    public float averageOf(String name) {
        float sum = 0.0f;
        final Collection<Note> notes = storageService.getAllNotesOf(name);
        for (final Note note: notes) {
            sum += note.getNote();
        }
        return sum / notes.size();
    }

    @Override
    public void clear() {
        storageService.clear();
    }

    public List<Note> getList(String name){
        return storageService.getAllNotesOf(name);
    }

    private NotesServiceImpl(final NotesStorage storageService) {
        this.storageService = storageService;
    }

}
