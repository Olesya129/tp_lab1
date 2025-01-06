
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>(); // Инициализация списка книг
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Метод для добавления книги в библиотеку
    public void addBook(Book book) {
        if (book != null) { // Проверка на null
            books.add(book); // Добавляем книгу в список
        }
    }

    @Override
    public String toString() {
        return "Library" + books;
    }

    // Метод для преобразования библиотеки в XML
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<library>\n");

        // Преобразуем каждую книгу в XML
        for (Book book : books) {
            xml.append(book.toXML());  // Для каждой книги вызываем ее метод toXML
        }

        xml.append("</library>\n");
        return xml.toString();
    }
}

