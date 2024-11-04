import java.util.List;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String price;
    private String isbn;
    private Publisher publisher;
    private int year;
    private String format;

    private List<Reviews> review;
    private List<String> awards;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Reviews> getReviews() {
        return review;
    }

    public void setReviews(List<Reviews> reviews) {
        this.review = reviews;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "\nBook: " +
                "id=" + id + '\n' +
                "title: " + title + '\n' +
                "author: " + author + '\n' +
                "genre: " + genre + '\n' +
                "price: " + price + '\n' +
                "isbn: " + isbn + '\n' +
                "publisher: " + publisher + '\n' +
                "year: " + year + '\n' +
                "format: " + format + '\n' +
                "reviews:" + review + '\n' +
                "awards:" + awards + '\n';
    }

/*    // Доп задание: метод для преобразования объекта Book в XML
    public String toXml() {
        StringBuilder xml = new StringBuilder();
        xml.append("<book id=\"").append(id).append("\">\n");
        xml.append("<title>").append(title).append("</title>\n");
        xml.append("<author>").append(author).append("</author>\n");
        xml.append("<year>").append(year).append("</year>\n");
        xml.append("<genre>").append(genre).append("</genre>\n");

        // Проверка, чтобы цена выводилась корректно
        if (price != null && !price.isEmpty()) {
            // Извлекаем цену и валюту
            String[] priceParts = price.split(" ");
            String priceValue = priceParts[0]; // Числовая часть
            String currency = priceParts.length > 1 ? priceParts[1] : ""; // Валюта
            xml.append("<price currency=\"").append(currency).append("\">").append(priceValue).append("</price>\n");
        } else {
            xml.append("<price currency=\"\"></price>\n"); // Пустая цена, если не задано
        }

        // Наконец, добавляем format только если он не пустой
        if (format != null && !format.isEmpty()) {
            xml.append("<format>").append(format).append("</format>\n");
        }
        if (publisher != null) {
            xml.append(publisher.toXml()).append("\n");
        }

        // Сначала добавляем reviews, затем awards, а потом формат
        if (reviews != null && !reviews.isEmpty()) {
            xml.append("<reviews>\n");
            for (Reviews review : reviews) {
                xml.append(review.toXml()).append("\n");
            }
            xml.append("</reviews>\n");
        }

        if (awards != null && !awards.isEmpty()) {
            xml.append("<awards>\n");
            for (String award : awards) {
                xml.append("<award>").append(award).append("</award>\n");
            }
            xml.append("</awards>\n");
        }



        xml.append("</book>");

        return xml.toString();
    }*/
}
