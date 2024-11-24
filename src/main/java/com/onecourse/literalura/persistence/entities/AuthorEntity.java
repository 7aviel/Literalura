package com.onecourse.literalura.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @OneToOne
    @JsonManagedReference
    private BookEntity book;

    @Override
    public String toString() {
        return  "---------- AUTHOR ----------\n" +
                " ID: '" + id +"'\n"+
                " NAME: '" + name + "' \n" +
                " BIRTH YEAR: " + birthYear +"\n"+
                " DEATH YEAR: " + deathYear +"\n"+
                "----------------------------";
    }
}
