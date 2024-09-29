package com.example.notes_be_v1.persistence.repository;

import com.example.notes_be_v1.persistence.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity,Long> {
}
