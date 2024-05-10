package org.eu.gonzalocaparros.example.notes.domain.controller;

import org.eu.gonzalocaparros.example.notes.domain.model.Note;
import org.eu.gonzalocaparros.example.notes.domain.repository.NoteRepository;

public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note getNote(long id) {
        return noteRepository.getNote(id);
    }

    public Note saveNote(Note note) {
        return noteRepository.saveNote(note);
    }

}
