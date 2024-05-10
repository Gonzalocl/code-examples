package org.eu.gonzalocaparros.example.notes.io.rest.mapper;

import org.eu.gonzalocaparros.example.notes.domain.model.Note;
import org.eu.gonzalocaparros.example.notes.io.rest.dto.NoteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note from(NoteDto dto);
    NoteDto from(Note note);
}
