package org.eu.gonzalocaparros.example.notes.io.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class NoteEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    public NoteEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
