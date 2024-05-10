package org.eu.gonzalocaparros.example.notes;

import org.eu.gonzalocaparros.example.notes.domain.controller.NoteController;
import org.eu.gonzalocaparros.example.notes.domain.repository.NoteRepository;
import org.eu.gonzalocaparros.example.notes.io.repository.SqliteNoteRepository;
import org.eu.gonzalocaparros.example.notes.io.repository.jpa.NoteJpaRepository;
import org.eu.gonzalocaparros.example.notes.io.repository.mapper.NoteEntityMapper;
import org.eu.gonzalocaparros.example.notes.io.rest.handler.NoteHandler;
import org.eu.gonzalocaparros.example.notes.io.rest.mapper.NoteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotesConfiguration {

    @Bean
    public NoteController noteController(NoteRepository noteRepository) {
        return new NoteController(noteRepository);
    }

    @Bean
    public NoteRepository noteRepository(NoteJpaRepository noteJpaRepository, NoteEntityMapper noteEntityMapper) {
        return new SqliteNoteRepository(noteJpaRepository, noteEntityMapper);
    }

    @Bean
    public NoteHandler noteHandler(NoteController noteController, NoteMapper noteMapper) {
        return new NoteHandler(noteController, noteMapper);
    }

}
