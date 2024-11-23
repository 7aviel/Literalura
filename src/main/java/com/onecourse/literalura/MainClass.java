package com.onecourse.literalura;

import com.fasterxml.jackson.core.type.TypeReference;
import com.onecourse.literalura.persistence.model.BookModel;
import com.onecourse.literalura.services.DataConversor;
import com.onecourse.literalura.services.SaveEntitiesService;
import com.onecourse.literalura.services.SearchByTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MainClass {

    private final SaveEntitiesService bookService;
    private final SearchByTitle searchByTitle;
    private final DataConversor dataConversor;

    @Autowired
    public MainClass(SaveEntitiesService bookService, SearchByTitle searchByTitle, DataConversor dataConversor) {
        this.bookService = bookService;
        this.searchByTitle = searchByTitle;
        this.dataConversor = dataConversor;
    }

    public void mainClass(){
        Scanner scn = new Scanner(System.in);
        int input;
        String title;
        do{
            System.out.println("----------------------------------");
            System.out.println("Choose an option with a number.");
            System.out.println("1. Search book by title");
            System.out.println("2. List registered books");
            System.out.println("3. List registered authors");
            System.out.println("4. List authors alive by year");
            System.out.println("5. List books by language");
            System.out.println("6. Exit");
            System.out.println("----------------------------------");
            input = scn.nextInt();
            scn.nextLine();

            switch (input){
                case 1:
                    System.out.println("Write the book's title");
                    title = scn.nextLine();
                    var json = searchByTitle.searchByTitle(title);
                    List<BookModel> data = dataConversor.getData(json, new TypeReference<>() {});
                    data.forEach(System.out::println);
                    this.bookService.saveBook(data);
                    break;
                case 2:
                    // Add cases for other options as needed
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (input != 6);
    }
}
