package com.person.demo.repositories;

import com.person.demo.domain.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepositories extends CrudRepository<Notes,Long> {
}
