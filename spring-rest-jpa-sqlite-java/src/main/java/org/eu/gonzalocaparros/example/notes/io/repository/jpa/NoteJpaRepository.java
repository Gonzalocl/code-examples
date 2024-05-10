package org.eu.gonzalocaparros.example.notes.io.repository.jpa;

import org.eu.gonzalocaparros.example.notes.io.repository.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteJpaRepository extends JpaRepository<NoteEntity, Long> {
}
