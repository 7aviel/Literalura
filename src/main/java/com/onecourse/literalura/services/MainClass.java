package com.onecourse.literalura.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.onecourse.literalura.persistence.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
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
        Integer input = null;
        String lang;
        boolean validInput;
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
            validInput=false;
            while (!validInput) {
                System.out.print("Please enter a number: ");
                try {
                input = scn.nextInt(); // Attempt to read an integer
                validInput = true; // If successful, set the flag to true
                } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scn.next();// Clear the invalid input
                }
            }
            scn.nextLine();
            switch (input){
                case 1:
                    System.out.println("Write the book's title");
                    var json = searchByTitle.searchByTitle(scn.nextLine());
                    List<BookModel> data = dataConversor.getData(json, new TypeReference<>() {});
                    if (this.saveEntitiesService.bookExist(data)) {
                        System.out.println("Book not found in the API response");
                        break;
                    }else if(this.saveEntitiesService.authorExists(data)) {
                        System.out.print("Book already exists in database.\n Choose another one \n");
                        break;
                    }else {
                        this.saveEntitiesService.saveBook(data);
                    }
                    break;
                case 2:
                    this.saveEntitiesService.getBookList().forEach(System.out::println);
                    break;
                case 3:
                    this.saveEntitiesService.getAuthorList().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Provide the year");
                    try {
                        year = scn.nextInt();
                        scn.nextLine();
                        this.authorService.getAuthorsByYear(year).forEach(System.out::println);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid year.");
                        scn.next(); // Clear the invalid input
                    } break;
                case 5:
                    System.out.println("Provide a language \n -en \n -es");
                    lang = scn.nextLine();
                    this.bookService.getBooksByLang(lang).forEach(System.out::println);
                    break;
            }
        } while (input != 6);
        scn.close();
    }
}
