package com.onecourse.literalura.persistence.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookModel(

        String title,
        List<AuthorModel> authors,
       @JsonAlias("download_count") Integer downloads,
        List<String> languages

) {}
