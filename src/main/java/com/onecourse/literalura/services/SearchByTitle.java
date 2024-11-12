package com.onecourse.literalura.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchByTitle {

    private Connection connection;
    public String searchByTitle(String title){
        List<String> words = new ArrayList<>(Arrays.asList(title.split(" ")));
        StringBuilder queryFormat = new StringBuilder();
        words.forEach(word -> queryFormat.append(word).append("%20") );
        return this.connection.JSONResponse("https://gutendex.com/books/?search="+ queryFormat);
    }


    public SearchByTitle(Connection connection) {
        this.connection = connection;
    }
}
