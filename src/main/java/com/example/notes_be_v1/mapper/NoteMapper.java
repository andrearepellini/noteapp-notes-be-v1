package com.example.notes_be_v1.mapper;

import com.example.notes_be_v1.model.NoteDto;
import com.example.notes_be_v1.model.NoteInputDto;
import com.example.notes_be_v1.persistence.entity.NoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    // Mapping from entity to DTO
    NoteDto entityToDto(NoteEntity entity);

    // Mapping from DTO to entity
    NoteEntity dtoToEntity(NoteDto dto);

    NoteEntity inputDtoToEntity(NoteInputDto noteInputDto);
}
