# Literalura

**Literalura** is a simple Java-based application that interacts with a third-party API Gutendex to fetch book data and store it in a local database. Users can search for books by title, list registered books and authors, and perform various queries on the stored data.

## Features

- **Search Book by Title**: Fetches book data from a third-party API based on the provided title and saves it to the local database.
- **List Registered Books**: Displays all books currently stored in the database.
- **List Registered Authors**: Displays all authors currently stored in the database.
- **List Authors Alive by Year**: Lists authors who were alive in a specific year.
- **List Books by Language**: Filters and displays books based on the provided language code.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- [Gutendex API](https://github.com/garethbjohnson/gutendex?tab=readme-ov-file).

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/7aviel/Literalura.git
   ```

2. Build the project using Maven:

   ```sh
   mvn clean install
   ```

3. Run the application:

   ```sh
   mvn spring-boot:run
   ```

## Usage

Upon running the application, you will be prompted with a menu to choose from the following options:

1. **Search book by title**: Enter the title of the book you want to search for.
2. **List registered books**: Displays a list of all books stored in the database.
3. **List registered authors**: Displays a list of all authors stored in the database.
4. **List authors alive by year**: Enter a year to see which authors were alive during that time.
5. **List books by language**: Enter a language code (e.g., `-en` for English, `-es` for Spanish) to list books in that language.
6. **Exit**: Exit the application.

### Example Usage

Here is an example of how to use the application:

1. Run the application.
2. Choose option `1` to search for a book by title.
3. Enter the book's title.
4. The application fetches the book data from the API, checks if the author exists in the database, and saves the book if it doesn't already exist.
5. Choose other options from the menu to interact with the stored data.

## Contributing

If you have suggestions for improvements or find any bugs, feel free to create an issue or submit a pull request. Contributions are welcome!

## License

This project is licensed under the MIT License.
