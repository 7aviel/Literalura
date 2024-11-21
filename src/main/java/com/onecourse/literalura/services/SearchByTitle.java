package com.onecourse.literalura.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchByTitle {

    private final Connection connection;
    public String searchByTitle(String title){
        List<String> words = new ArrayList<>(Arrays.asList(title.split(" ")));
        StringBuilder queryFormat = new StringBuilder();
        words.forEach(word -> queryFormat.append(word).append("%20") );
        return this.connection.JSONResponse("https://gutendex.com/books/?search="+ queryFormat);
    }

    @Autowired
    public SearchByTitle(Connection connection) {
        this.connection = connection;
    }
}
