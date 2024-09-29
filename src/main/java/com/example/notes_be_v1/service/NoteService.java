package com.example.notes_be_v1.service;

import com.example.notes_be_v1.model.NoteDto;
import com.example.notes_be_v1.model.NoteInputDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    Void deleteNote(Long id);

    NoteDto createNote(NoteInputDto noteInputDto);

    List<NoteDto> getAllNotes();

    NoteDto getNoteById(Long id);

    NoteDto updateNote(Long id, NoteInputDto noteInputDto);
}
