package com.onecourse.literalura.persistence.repositories;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import com.onecourse.literalura.persistence.entities.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE AuthorEntity a SET a.book = :newBook WHERE a.id = :id")
    void updateAuthorEntitiesBy(@Param("newBook")BookEntity book, @Param("id") Long id);

}
