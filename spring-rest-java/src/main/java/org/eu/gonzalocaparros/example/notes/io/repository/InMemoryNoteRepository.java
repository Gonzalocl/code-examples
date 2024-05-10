package org.eu.gonzalocaparros.example.notes.io.repository;

import org.eu.gonzalocaparros.example.notes.domain.model.Note;
import org.eu.gonzalocaparros.example.notes.domain.repository.NoteRepository;
import org.eu.gonzalocaparros.example.notes.io.repository.exception.InMemoryNoteNotFoundException;
import org.eu.gonzalocaparros.example.notes.io.repository.exception.InMemoryNoteSaveFailException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryNoteRepository implements NoteRepository {

    private static final long ID_MAX = 10;

    private static long nextId = 0;
    private final Map<Long, Note> notes = new HashMap<>();

    public Note getNote(long id) {
        if (!notes.containsKey(id)) {
            throw new InMemoryNoteNotFoundException();

        }

        return notes.get(id);

    }

    public Note saveNote(Note note) {
        if (nextId == ID_MAX) {
            throw new InMemoryNoteSaveFailException();
        }

        Note saved = note.toBuilder().id(nextId++).build();

        notes.put(saved.getId(), saved);

        return saved;

    }

}
