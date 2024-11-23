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
    private AuthorEntity author;
    private String language;
    private Integer downloads;

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
