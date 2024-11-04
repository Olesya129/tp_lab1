import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>(); // Инициализация списка
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



   /* // Доп задание: метод для преобразования объекта Library в XML
    public String toXml() {
        StringBuilder xml = new StringBuilder();
        xml.append("<library>\n");  // Начало тега <library>

        for (Book book : books) {
            xml.append(book.toXml()).append("\n");  // Добавляем XML каждой книги
        }

        xml.append("</library>");  // Закрывающий тег </library>
        return xml.toString();
    }*/

}
