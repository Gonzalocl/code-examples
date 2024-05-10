package org.eu.gonzalocaparros.example.notes.io.repository.mapper;

import org.eu.gonzalocaparros.example.notes.domain.model.Note;
import org.eu.gonzalocaparros.example.notes.io.repository.entity.NoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteEntityMapper {
    Note from(NoteEntity entity);
    NoteEntity from(Note note);
}
