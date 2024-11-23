package com.onecourse.literalura.services;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import com.onecourse.literalura.persistence.entities.BookEntity;
import com.onecourse.literalura.persistence.model.BookModel;
import com.onecourse.literalura.persistence.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public void saveBook(BookEntity bookEntity) {
        this.bookRepository.save(bookEntity);
    }

    public BookEntity convertToEntity(List<BookModel> bookModels){
        BookModel bookModel = bookModels.get(0);
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookModel.title());
        bookEntity.setDownloads(bookModel.downloads());
        bookEntity.setLanguage(bookModel.languages().get(0));
        return bookEntity;
    }

    public List<BookEntity> getBooks(){
       return this.bookRepository.findAll();
    }

    public List<BookEntity> getBooksByLang(String lang){
        return this.bookRepository.getBookEntitiesByLanguage(lang);
    }


}
