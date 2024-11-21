package com.onecourse.literalura.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onecourse.literalura.persistence.model.BookModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne
    private AuthorEntity author;
    private String language;
    private Integer downloads;

    public BookEntity(BookModel bookModel, AuthorEntity author){
        this.title = bookModel.title();
        this.author = author;
        this.language = bookModel.languages().get(0);
        this.downloads = bookModel.downloads();
    }

    @Override
    public String toString() {
        return "------------ BOOK -----------------" +
                "   ID: " + id +
                ", TITLE: '" + title + '\'' +
                ", AUTHOR: " + author +
                ", LANG: '" + language + '\'' +
                ", DOWNLOADS: " + downloads +
                "-----------------------------------";
    }
}
