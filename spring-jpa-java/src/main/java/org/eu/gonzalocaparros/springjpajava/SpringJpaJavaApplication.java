package org.eu.gonzalocaparros.springjpajava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpaJavaApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringJpaJavaApplication.class);

    private final NoteRepository noteRepository;

    public SpringJpaJavaApplication(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaJavaApplication.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return this::run;

    }

    private void run(String[] args) {
        log.info("Saving notes");
        noteRepository.save(new Note("Note #1", "Description"));
        noteRepository.save(new Note("Note #2", "Description"));

        log.info("Finding all notes");
        List<Note> notes = noteRepository.findAll();

        log.info("Notes: " + notes);
        log.info("Total notes: " + notes.size());

    }

}
