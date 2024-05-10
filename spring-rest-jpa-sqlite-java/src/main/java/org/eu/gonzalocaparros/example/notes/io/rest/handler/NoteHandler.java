package org.eu.gonzalocaparros.example.notes.io.rest.handler;

import org.eu.gonzalocaparros.example.notes.domain.controller.NoteController;
import org.eu.gonzalocaparros.example.notes.domain.exception.NoteNotFoundException;
import org.eu.gonzalocaparros.example.notes.domain.exception.NoteSaveFailException;
import org.eu.gonzalocaparros.example.notes.domain.model.Note;
import org.eu.gonzalocaparros.example.notes.io.rest.dto.NoteDto;
import org.eu.gonzalocaparros.example.notes.io.rest.mapper.NoteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoteHandler {

    private final NoteController noteController;
    private final NoteMapper noteMapper;

    public NoteHandler(NoteController noteController, NoteMapper noteMapper) {
        this.noteController = noteController;
        this.noteMapper = noteMapper;
    }

    public NoteDto getNote(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is null");
        }

        Note note;
        try {
            note = noteController.getNote(id);
        } catch (NoteNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found: " + id, e);
        }

        return noteMapper.from(note);
    }

    public NoteDto postNote(NoteDto dto) {

        Note note = noteMapper.from(dto);

        Note savedNote;
        try {
            savedNote = noteController.saveNote(note);
        } catch (NoteSaveFailException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save note: " + dto, e);
        }

        return noteMapper.from(savedNote);
    }

}
