package com.onecourse.literalura;

import com.onecourse.literalura.services.Connection;
import com.onecourse.literalura.services.SearchByTitle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(LiteraluraApplication.class, args);}

	@Override
	public void run(String... args) throws Exception{
		Connection cn = new Connection();
		SearchByTitle search = new SearchByTitle(cn);
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

			if (input == 1){
				System.out.println("Write the book's title");
				title = scn.nextLine();
				System.out.println(search.searchByTitle(title));
			}

		}while (input != 6);

	}
}
