package com.onecourse.literalura.persistence.repositories;

import com.onecourse.literalura.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b WHERE b.language = :lang")
    List<BookEntity> getBookEntitiesByLanguage(@Param("lang") String lang);

    }
