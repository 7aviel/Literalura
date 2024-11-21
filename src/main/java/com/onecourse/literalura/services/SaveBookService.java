package com.onecourse.literalura.services;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import com.onecourse.literalura.persistence.entities.BookEntity;
import com.onecourse.literalura.persistence.model.BookModel;
import com.onecourse.literalura.persistence.repositories.AuthorRepository;
import com.onecourse.literalura.persistence.repositories.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveBookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public void saveBook(List<BookModel> bookModels){
        BookModel bookModel = bookModels.get(0);
        AuthorEntity author = getAuthorEntity(bookModel);
        BookEntity bookEntity = new BookEntity(bookModel, author);
        this.authorRepository.save(author);
        this.bookRepository.save(bookEntity);
    }

    private AuthorEntity getAuthorEntity(BookModel bookModel){
        AuthorEntity author = new AuthorEntity();
        author.setName(bookModel.authors().get(0).name());
        author.setBirthYear(bookModel.authors().get(0).birthYear());
        author.setDeathYear(bookModel.authors().get(0).deathYear());
        return author;
    }

    @Autowired
    public SaveBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
}
