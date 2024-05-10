package org.eu.gonzalocaparros.example.notes.domain.repository;

import org.eu.gonzalocaparros.example.notes.domain.model.Note;

public interface NoteRepository {
    Note getNote(long id);
    Note saveNote(Note note);
}
