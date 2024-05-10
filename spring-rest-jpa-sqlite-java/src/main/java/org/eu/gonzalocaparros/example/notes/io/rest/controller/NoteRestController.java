package org.eu.gonzalocaparros.example.notes.io.rest.controller;

import org.eu.gonzalocaparros.example.notes.io.rest.dto.NoteDto;
import org.eu.gonzalocaparros.example.notes.io.rest.handler.NoteHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteRestController {

    private final NoteHandler noteHandler;

    public NoteRestController(NoteHandler noteHandler) {
        this.noteHandler = noteHandler;
    }

    @GetMapping("/note/{id}")
    public NoteDto getNote(@PathVariable Long id) {
        return noteHandler.getNote(id);
    }

    @PostMapping("/note")
    public NoteDto postNote(@RequestBody NoteDto note) {
        return noteHandler.postNote(note);
    }

}
