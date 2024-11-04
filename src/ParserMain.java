import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserMain {
    public static void main(String[] args) {
        try {
            // построчно читаем содержимое файла
            BufferedReader reader = new BufferedReader(new FileReader("library.xml"));
            // объект для хранения содержимого xml-файла в строке
            StringBuilder xmlData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                xmlData.append(line.trim()); // удаляем пробелы в начале и в конце строки и записываем в xmlData
            }
            reader.close();

            Library library = parseLibrary(xmlData.toString());
            System.out.println(library);

        // обработка ошибок
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // private static - доступен только в текущем классе и может быть вызван без создания объекта этого класса
    private static Library parseLibrary(String xml) {
        // создаем новый объект Library в который будут добавляться книги
        Library library = new Library();
        // создаем массив bookSections, разделяем строку xml по закрывающему тегу </book>
        String[] bookSections = xml.split("</book>");
        // проходим по каждому эл-ту bookSection в bookSections
        for (String bookSection : bookSections) {
            if (bookSection.contains("<book")) {    //если содержит открывающий тег, то вызываем parseBook
                Book book = parseBook(bookSection); //принимает bookSection,возвращает объект Book
                library.addBook(book);
            }
        }
        return library;
    }

    private static Book parseBook(String bookSection) {
        Book book = new Book();

        String idString = parseAttributeValue(bookSection, "book", "id");
        book.setId(Integer.parseInt(idString));


        // вызов метода parseTagContent, которому передается строка с тегом title для извлечения
        String title = parseTagContent(bookSection, "title");
        // после извлечения устанавливаем значение в поле title
        book.setTitle(title);

        String author = parseTagContent(bookSection, "author");
        book.setAuthor(author);

        String year = parseTagContent(bookSection, "year");
        book.setYear(Integer.parseInt(year)); // преобразовываем строку в число, т.к. объявлен int

        String genre = parseTagContent(bookSection, "genre");
        book.setGenre(genre);

        String price = parseTagContent(bookSection, "price");
        String currency = parseAttributeValue(bookSection, "price", "currency"); //извлекаем атрибут из тега
        String finPrice = currency + " " + price;
        book.setPrice(finPrice);

        String isbn = parseTagContent(bookSection, "isbn");
        book.setIsbn(isbn);

        Publisher publisher = parsePublisher(bookSection);
        book.setPublisher(publisher);

        String format = parseTagContent(bookSection, "format");
        book.setFormat(format);

        List<Reviews> reviews = parseReviews(bookSection);
        book.setReviews(reviews);

        List<String> awards = parseAwards(bookSection);
        book.setAwards(awards);

        return book;
    }

    private static Publisher parsePublisher(String bookSection) {
        Publisher publisher = new Publisher();

        String name = parseTagContent(bookSection, "name");
        publisher.setName(name);

        // извлекаем город и страну, добавляем их в список строк и устанавливаем в адрес
        String city = parseTagContent(bookSection, "city");
        String country = parseTagContent(bookSection, "country");
        List<String> address = List.of(city, country); // создаем список строк
        publisher.setAddress(address);


        return publisher;
    }
    private static List<Reviews> parseReviews(String bookSection){
        List<Reviews> review = new ArrayList<>();

        // создаем массив reviewsSections, разделяем строку xml по закрывающему тегу </review>
        String[] reviewsSections = bookSection.split("</review>");
        for (String reviewsSection : reviewsSections) {
            if (reviewsSection.contains("<review")) {
                Reviews reviews = new Reviews();

                String user = parseTagContent(reviewsSection, "user");
                reviews.setUser(user);

                String rating = parseTagContent(reviewsSection, "rating");
                reviews.setRating(Integer.parseInt(rating)); // Преобразуем строку в int


                String comment = parseTagContent(reviewsSection, "comment");
                reviews.setComment(comment);

                // Добавляем объект reviews в список review
                review.add(reviews);
            }
        }
        return review;
    }
    private static List<String> parseAwards(String bookSection) {
        List<String> awards = new ArrayList<>();

        String[] awardSections = bookSection.split("</award>"); // Разделяем на блоки, заканчивающиеся тегом </award>
        for (String awardSection : awardSections) {
            if (awardSection.contains("<award")) {

                String award = parseTagContent(awardSection, "award");
                awards.add(award); // Добавляем награду в список
            }
        }
        return awards;
    }




    private static String parseTagContent(String xmlSection, String tagName) {
        // Создаем открывающий тег
        String openTag = "<" + tagName + ">";
        // Создаем закрывающий тег
        String closeTag = "</" + tagName + ">";

        // Находим начало открывающего тега
        int startTagIndex = xmlSection.indexOf(openTag);
        if (startTagIndex == -1) {
            return null; // Тег не найден
        }

        // Находим конец открывающего тега
        int startContentIndex = startTagIndex + openTag.length();
        // Находим конец закрывающего тега
        int endTagIndex = xmlSection.indexOf(closeTag, startContentIndex);
        if (endTagIndex == -1) {
            return null; // Закрывающий тег не найден
        }

        // Извлекаем содержимое между тегами
        return xmlSection.substring(startContentIndex, endTagIndex).trim();
    }
    private static String parseAttributeValue(String xmlSection, String tagName, String attributeName) {
        // Ищем открывающий тег с нужным именем, например <price
        String openTag = "<" + tagName;
        int tagStart = xmlSection.indexOf(openTag);
        if (tagStart == -1) {
            return null; // Тег не найден
        }

        // Находим место начала и конца атрибута внутри открывающего тега
        int attrStart = xmlSection.indexOf(attributeName + "=\"", tagStart);
        if (attrStart == -1) {
            return null; // Атрибут не найден
        }

        attrStart += attributeName.length() + 2; // Переход к началу значения атрибута
        int attrEnd = xmlSection.indexOf("\"", attrStart); // Конец значения атрибута

        return xmlSection.substring(attrStart, attrEnd); // Возвращаем значение атрибута
    }





}
