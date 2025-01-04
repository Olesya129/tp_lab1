import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserMain {

    // Метод для парсинга XML файла
    public Library parse(String filePath) {
        Library library = new Library(); // Создаем объект библиотеки
        Book book = null;                // Переменная для книги
        Publisher publisher = null;      // Переменная для издателя
        Address address = null;          // Переменная для адреса издателя
        List<Reviews> reviews = null;    // Список который хранит все отзывы для конкретной книги
        Reviews review = null;           // Переменная для одного отзыва
        List<String> awards = null;      // Список для наград

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // Чтение файла
            String line;
            while ((line = br.readLine()) != null) { // Чтение каждой строки
                line = line.trim();  // Убираем лишние пробелы по бокам

                // Начало нового элемента book
                if (line.startsWith("<book")) {
                    book = new Book();  // Создаем новую книгу
                    book.setId(Integer.parseInt(extractAttribute(line, "id"))); // Парсим id книги
                }
                // Парсинг других элементов книги
                else if (line.startsWith("<title>")) {
                    book.setTitle(extractValue(line, "title"));
                } else if (line.startsWith("<author>")) {
                    book.setAuthor(extractValue(line, "author"));
                } else if (line.startsWith("<year>")) {
                    book.setYear(Integer.parseInt(extractValue(line, "year")));
                } else if (line.startsWith("<genre>")) {
                    book.setGenre(extractValue(line, "genre"));
                } else if (line.startsWith("<isbn>")) {
                    book.setIsbn(extractValue(line, "isbn"));
                } else if (line.startsWith("<format>")) {
                    book.setFormat(extractValue(line, "format"));

                    // Парсим цену и валюту
                } else if (line.startsWith("<price")) {
                    String currency = extractAttribute(line, "currency");
                    String priceValue = line.substring(line.indexOf(">") + 1, line.lastIndexOf("</price>")).trim();
                    book.setPrice(priceValue + " " + currency);
                }

                    // Парсим издателя и его информации
                else if (line.startsWith("<publisher>")) {
                    publisher = new Publisher();  // Создаем нового издателя
                } else if (line.startsWith("<name>")) {
                    publisher.setName(extractValue(line, "name"));
                    // Создаем адрес для издателя
                } else if (line.startsWith("<address>")) {
                    address = new Address();
                } else if (line.startsWith("<city>")) {
                    address.setCity(extractValue(line, "city"));
                } else if (line.startsWith("<country>")) {
                    address.setCountry(extractValue(line, "country"));
                } else if (line.startsWith("</address>")) {
                    // Устанавливаем адрес в издателя
                    publisher.setAddress(address);
                } else if (line.startsWith("</publisher>")) {
                    // Устанавливаем издателя в книгу
                    book.setPublisher(publisher);
                }

                    // Парсинг отзывов
                else if (line.startsWith("<reviews>")) {
                    reviews = new ArrayList<>();  // Создаем список отзывов
                } else if (line.startsWith("<review>")) {
                    review = new Reviews();     // Создаем новый отзыв
                } else if (line.startsWith("<user>")) {
                    review.setUser(extractValue(line, "user"));
                } else if (line.startsWith("<rating>")) {
                    review.setRating(Integer.parseInt(extractValue(line, "rating")));
                } else if (line.startsWith("<comment>")) {
                    review.setComment(extractValue(line, "comment"));
                } else if (line.startsWith("</review>")) {
                    // Добавляем отзыв в список
                    reviews.add(review);
                } else if (line.startsWith("</reviews>")) {
                    // Устанавливаем отзывы в книгу
                    book.setReviews(reviews);
                }

                    // Парсинг наград
                else if (line.startsWith("<awards>")) {
                    awards = new ArrayList<>();  // Создаем список наград
                } else if (line.startsWith("<award>")) {
                    // Добавляем награду в список
                    awards.add(extractValue(line, "award"));
                } else if (line.startsWith("</awards>")) {
                    // Добавляем награды в книгу
                    book.setAwards(awards);
                }

                // Завершаем обработку книги
                else if (line.startsWith("</book>")) {
                    // Добавляем книгу в библиотеку
                    library.addBook(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  // Обработка ошибок
        }
        return library;  // Возвращаем библиотеку с заполненными книгами
    }

    // Метод для извлечения атрибута из строки для id и currency
    private String extractAttribute(String line, String attribute) {
        String pattern = attribute + "=\"";      // Ищем атрибут в формате id="1"; currency="GBP"
        int start = line.indexOf(pattern) + pattern.length();  // Находим начало значения атрибута
        int end = line.indexOf("\"", start);  // Находим конец значения атрибута
        return line.substring(start, end);        // Возвращаем значение атрибута
    }

    // Метод для извлечения значений из тегов (для всего остального)
    private String extractValue(String line, String tag) {
        // Убираем теги и оставляем только содержимое
        return line.replace("<" + tag + ">", "").replace("</" + tag + ">", "");
    }

    // Метод для запуска программы
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tosch\\IdeaProjects\\tp\\library.xml";  // путь к XML файлу

        ParserMain parser = new ParserMain();       // Создаем объект парсера
        Library library = parser.parse(filePath);   // Парсим файл и получаем библиотеку

        System.out.println(library);  // Выводим результат
    }
}
