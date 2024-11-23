package com.onecourse.literalura.services;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import com.onecourse.literalura.persistence.entities.BookEntity;
import com.onecourse.literalura.persistence.model.AuthorModel;
import com.onecourse.literalura.persistence.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void saveAuthor(AuthorEntity author) {
        this.authorRepository.save(author);
    }

    public void updateAuthor(AuthorEntity author, BookEntity book) {
        authorRepository.updateAuthorEntitiesBy(book,author.getId());
    }

    public AuthorEntity convertToEntity(AuthorModel authorModel) {
        AuthorEntity author = new AuthorEntity();
        author.setName(authorModel.name());
        author.setBirthYear(authorModel.birthYear());
        author.setDeathYear(authorModel.deathYear());
        return author;
    }

    public List<AuthorEntity> getAuthors() {
        return authorRepository.findAll();
    }

    public List<AuthorEntity> getAuthorsByYear(Integer year){
        return authorRepository.getAuthorEntitiesByBirthYear(year);
    }

}
