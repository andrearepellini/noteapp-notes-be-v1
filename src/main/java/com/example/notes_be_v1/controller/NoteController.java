package com.example.notes_be_v1.controller;


import com.example.notes_be_v1.api.NotesApi;
import com.example.notes_be_v1.model.NoteDto;
import com.example.notes_be_v1.model.NoteInputDto;
import com.example.notes_be_v1.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")  // Allowing CORS from frontend
public class NoteController implements NotesApi {

    @Autowired
    private NoteService noteService;

    @Override
    public ResponseEntity<NoteDto> createNote(NoteInputDto noteInputDto) {
        return new ResponseEntity<>(noteService.createNote(noteInputDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteNote(Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NoteDto> getNoteById(Long id) {
        return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NoteDto> updateNote(Long id, NoteInputDto noteInputDto) {
        return new ResponseEntity<>(noteService.updateNote(id, noteInputDto), HttpStatus.OK);
    }
}
