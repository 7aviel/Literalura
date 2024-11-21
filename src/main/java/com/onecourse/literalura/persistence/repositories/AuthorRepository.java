package com.onecourse.literalura.persistence.repositories;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
