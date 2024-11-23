package com.onecourse.literalura;

import com.fasterxml.jackson.core.type.TypeReference;
import com.onecourse.literalura.persistence.model.BookModel;
import com.onecourse.literalura.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MainClass {

    private final SaveEntitiesService saveEntitiesService;
    private final SearchByTitle searchByTitle;
    private final DataConversor dataConversor;

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public MainClass(SaveEntitiesService saveEntitiesService, SearchByTitle searchByTitle, DataConversor dataConversor, AuthorService authorService, BookService bookService) {
        this.saveEntitiesService = saveEntitiesService;
        this.searchByTitle = searchByTitle;
        this.dataConversor = dataConversor;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public void mainClass(){
        Scanner scn = new Scanner(System.in);
        int input;
        String title;
        String lang;
        int year;
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
                    this.saveEntitiesService.saveBook(data);
                    break;
                case 2:
                    this.saveEntitiesService.getBookList().forEach(System.out::println);
                    break;
                case 3:
                    this.saveEntitiesService.getAuthorList().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Provide the year");
                    year = scn.nextInt();
                    scn.nextLine();
                    this.authorService.getAuthorsByYear(year).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Provide a language \n -en \n -es");
                    lang = scn.nextLine();
                    this.bookService.getBooksByLang(lang).forEach(System.out::println);
                    break;
            }
        } while (input != 6);
    }
}
