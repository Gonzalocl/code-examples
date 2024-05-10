package org.eu.gonzalocaparros.example.notes.io.repository;

import org.eu.gonzalocaparros.example.notes.domain.model.Note;
import org.eu.gonzalocaparros.example.notes.domain.repository.NoteRepository;
import org.eu.gonzalocaparros.example.notes.io.repository.entity.NoteEntity;
import org.eu.gonzalocaparros.example.notes.io.repository.exception.SqliteNoteNotFoundException;
import org.eu.gonzalocaparros.example.notes.io.repository.jpa.NoteJpaRepository;
import org.eu.gonzalocaparros.example.notes.io.repository.mapper.NoteEntityMapper;

import java.util.Optional;

public class SqliteNoteRepository implements NoteRepository {

    private final NoteJpaRepository noteJpaRepository;
    private final NoteEntityMapper noteEntityMapper;

    public SqliteNoteRepository(NoteJpaRepository noteJpaRepository, NoteEntityMapper noteEntityMapper) {
        this.noteJpaRepository = noteJpaRepository;
        this.noteEntityMapper = noteEntityMapper;
    }

    @Override
    public Note getNote(long id) {
        Optional<NoteEntity> noteEntity = noteJpaRepository.findById(id);
        return noteEntityMapper.from(noteEntity.orElseThrow(SqliteNoteNotFoundException::new));
    }

    @Override
    public Note saveNote(Note note) {
        NoteEntity saved = noteJpaRepository.save(noteEntityMapper.from(note));
        return noteEntityMapper.from(saved);
    }
}
