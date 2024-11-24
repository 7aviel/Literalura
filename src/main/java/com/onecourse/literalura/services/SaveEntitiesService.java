package com.onecourse.literalura.services;

import com.onecourse.literalura.persistence.entities.AuthorEntity;
import com.onecourse.literalura.persistence.entities.BookEntity;
import com.onecourse.literalura.persistence.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveEntitiesService {

    private final BookService bookService;
    private final AuthorService authorService;
    public void saveBook(List<BookModel> bookModels){
        AuthorEntity a = saveAuthor(bookModels.get(0));
        BookEntity bookEntity =bookService.convertToEntity(bookModels);
        bookEntity.setAuthor(a);
        bookService.saveBook(bookEntity);
        authorService.updateAuthor(a,bookEntity);
    }
    @Autowired
    public SaveEntitiesService(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public AuthorEntity saveAuthor(BookModel bookModel){
        AuthorEntity author = authorService.convertToEntity(bookModel.authors().get(0));
        authorService.saveAuthor(author);
        return author;
    }

    public boolean authorExists(List<BookModel> bookModels) {
        if (bookModels == null || bookModels.isEmpty()) {
            return false; // Return false if the list is null or empty
        }
        AuthorEntity author = authorService.convertToEntity(bookModels.get(0).authors().get(0));
        return authorService.getByName(author.getName()).isPresent();
    }

    public boolean bookExist(List<BookModel> bookModels){
        return bookModels.isEmpty();
    }

    public List<BookEntity> getBookList(){
        return bookService.getBooks();
    }

    public List<AuthorEntity> getAuthorList(){
        return authorService.getAuthors();
    }


}

