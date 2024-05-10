package org.eu.gonzalocaparros.example.notes.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Note {
    private Long id;
    private String title;
    private String description;
}
