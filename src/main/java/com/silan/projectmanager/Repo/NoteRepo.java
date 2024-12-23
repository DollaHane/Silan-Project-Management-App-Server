package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, String>{

}
