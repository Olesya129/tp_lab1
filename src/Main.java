import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем книги
        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Effective Java");
        book1.setAuthor("George Orwell");
        book1.setYear(2001);
        book1.setGenre("History");
        book1.setPrice("24.87");
        book1.setCurrency("GBP");
        book1.setIsbn("978-1-245964667");

        Publisher publisher1 = new Publisher();
        publisher1.setName("TechBooks Publishing");

        Address address1 = new Address();
        address1.setCity("Moscow");
        address1.setCountry("Germany");

        publisher1.setAddress(address1);
        book1.setPublisher(publisher1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Foundation");
        book2.setAuthor("Joshua Bloch");
        book2.setYear(1998);
        book2.setGenre("Fiction");
        book2.setPrice("23.14");
        book2.setCurrency("RUB");

        Publisher publisher2 = new Publisher();
        publisher2.setName("TechBooks Publishing");

        Address address2 = new Address();
        address2.setCity("Tokyo");
        address2.setCountry("Germany");

        publisher2.setAddress(address2);
        book2.setPublisher(publisher2);

        Reviews review1 = new Reviews();
        review1.setUser("alice");
        review1.setRating(3);
        review1.setComment("Could be better.");

        Reviews review2 = new Reviews();
        review2.setUser("charlie");
        review2.setRating(1);
        review2.setComment("Excellent content.");

        book2.setReviews(List.of(review1, review2));

        Book book3 = new Book();
        book3.setId(3);
        book3.setTitle("Pride and Prejudice");
        book3.setAuthor("Jane Austen");
        book3.setYear(1984);
        book3.setGenre("Science");
        book3.setPrice("80.18");
        book3.setCurrency("USD");
        book3.setIsbn("978-1-935961066");
        book3.setFormat("Audiobook");

        Publisher publisher3 = new Publisher();
        publisher3.setName("Classic Books");

        Address address3 = new Address();
        address3.setCity("Berlin");
        address3.setCountry("USA");

        publisher3.setAddress(address3);
        book3.setPublisher(publisher3);

        Reviews review3 = new Reviews();
        review3.setUser("bob");
        review3.setRating(2);
        review3.setComment("Very informative.");

        book3.setReviews(List.of(review3));

        book3.setAwards(List.of("Best Seller", "Book of the Year"));

        // Создаем объект Library
        Library library = new Library();
        library.setBooks(List.of(book1, book2, book3));

        // Сериализация в XML
        String xmlOutput = library.toXML();
        System.out.println("Generated XML:");
        System.out.println(xmlOutput);

        // Запись XML в файл
        try (FileWriter writer = new FileWriter("generated_library.xml")) {
            writer.write(xmlOutput);
            System.out.println("XML записан в файл generated_library.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Валидация XML
        boolean isValid = ValidatorMain.validateXML("generated_library.xml", "library.xsd");
        System.out.println("\nXML корректен: " + isValid);
    }
}
