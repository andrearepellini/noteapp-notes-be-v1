package com.example.notes_be_v1.service.impl;

import com.example.notes_be_v1.mapper.NoteMapper;
import com.example.notes_be_v1.model.NoteDto;
import com.example.notes_be_v1.model.NoteInputDto;
import com.example.notes_be_v1.persistence.entity.NoteEntity;
import com.example.notes_be_v1.persistence.repository.NoteRepository;
import com.example.notes_be_v1.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public Void deleteNote(Long id) {
        noteRepository.deleteById(id);
        return null;
    }

    @Override
    public NoteDto createNote(NoteInputDto noteInputDto) {
        NoteEntity noteEntity = noteMapper.inputDtoToEntity(noteInputDto);

        NoteEntity savedNoteEntity = noteRepository.save(noteEntity);

        return noteMapper.entityToDto(savedNoteEntity);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::entityToDto)
                .toList();
    }

    @Override
    public NoteDto getNoteById(Long id) {
        NoteEntity noteEntity = noteRepository.findById(id).orElse(null);

        return noteMapper.entityToDto(noteEntity);
    }

    @Override
    public NoteDto updateNote(Long id, NoteInputDto noteInputDto) {
        NoteEntity noteEntityToUpdate = noteRepository.findById(id).orElseThrow(RuntimeException::new);

        noteEntityToUpdate.setTitle(noteInputDto.getTitle());
        noteEntityToUpdate.setContent(noteInputDto.getContent());

        NoteEntity updatedNoteEntity = noteRepository.save(noteEntityToUpdate);

        return noteMapper.entityToDto(updatedNoteEntity);
    }
}
