Sure thing! I'll add a section with the steps for contributing to your project:

---

# Literalura

**Literalura** is a simple Java-based application that interacts with Gutendex's API to fetch book data and store it in a local database. Users can search for books by title, list registered books and authors, and perform various queries on the stored data.

## Features

- **Search Book by Title**: Fetches book data from Gutendex API based on the provided title and saves it to the local database.
- **List Registered Books**: Displays all books currently stored in the database.
- **List Registered Authors**: Displays all authors currently stored in the database.
- **List Authors Alive by Year**: Lists authors who were alive in a specific year.
- **List Books by Language**: Filters and displays books based on the provided language code.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- [Gutendex API](https://github.com/garethbjohnson/gutendex?tab=readme-ov-file).
- PostgreSQL local database

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

We welcome contributions to enhance the functionality and fix issues in Literalura. Here's how you can contribute:

1. **Fork the Repository**: Click the "Fork" button on the top right of the repository page to create a copy of the repository in your GitHub account.

2. **Clone Your Fork**: Clone your forked repository to your local machine using the following command:
   ```sh
   git clone https://github.com/yourusername/Literalura.git
   cd Literalura
   ```

3. **Create a Branch**: Create a new branch for your feature or bugfix:
   ```sh
   git checkout -b feature-or-bugfix-name
   ```

4. **Make Your Changes**: Implement your changes or new features. Ensure your code follows the project's coding standards and includes appropriate tests.

5. **Commit Your Changes**: Commit your changes with a clear and descriptive commit message:
   ```sh
   git add .
   git commit -m "Description of the feature or fix"
   ```

6. **Push to Your Fork**: Push your changes to your forked repository:
   ```sh
   git push origin feature-or-bugfix-name
   ```

7. **Create a Pull Request**: Go to the original repository and click on the "New Pull Request" button. Select your branch and submit the pull request, providing a detailed description of your changes.

8. **Review Process**: Your pull request will be reviewed by the project maintainers. Be ready to make any requested changes and engage in discussions to ensure your contribution aligns with the project goals.

9. **Merge**: Once your pull request is approved, it will be merged into the main repository.

If you have suggestions for improvements or find any bugs, feel free to create an issue or submit a pull request. Contributions are welcome!

## Contact me:
vilcheariel1@gmail.com
