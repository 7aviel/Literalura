package com.onecourse.literalura.persistence.repositories;

import com.onecourse.literalura.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    }
