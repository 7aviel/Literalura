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
    @OneToOne(mappedBy = "book")
    @JsonBackReference
    private AuthorEntity author;
    private String language;
    private Integer downloads;

    @Override
    public String toString() {
        return  "------------ BOOK ------------\n" +
                "  ID: " + id +"\n"+
                " TITLE: '" + title + "'\n" +
                " AUTHOR: " + author.getName() + "\n"+
                " LANG: '" + language + "'\n" +
                " DOWNLOADS: " + downloads + "\n" +
                "------------------------------";
    }
}
