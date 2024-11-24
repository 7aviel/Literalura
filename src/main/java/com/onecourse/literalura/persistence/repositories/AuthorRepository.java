package com.onecourse.literalura.persistence.repositories;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import com.onecourse.literalura.persistence.entities.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE AuthorEntity a SET a.book = :newBook WHERE a.id = :id")
    void updateAuthorEntitiesBy(@Param("newBook")BookEntity book, @Param("id") Long id);

    @Query("SELECT a FROM AuthorEntity a WHERE a.deathYear > :year AND a.birthYear < :year")
    List<AuthorEntity> getAuthorEntitiesByBirthYear(@Param("year") Integer year);

    @Query("SELECT a FROM AuthorEntity a WHERE a.name = :name")
    Optional<AuthorEntity> getAuthorByName(@Param("name") String name);
}
