package zad1;

import java.util.Collection;

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

    private NotesServiceImpl(final NotesStorage storageService) {
        this.storageService = storageService;
    }

}
