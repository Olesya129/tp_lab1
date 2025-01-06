
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String genre;
    private String price;
    private String isbn;
    private Publisher publisher;
    private String format;

    private List<Reviews> reviews;
    private List<String> awards;
    private String currency;


    // Геттеры и сеттеры
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
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
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
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
                "id=" + id + ",\n" +
                "title: " + title + ",\n" +
                "author: " + author + ",\n" +
                "year: " + year + ",\n" +
                "genre: " + genre + ",\n" +
                "price: " + price + ",\n" +
                "isbn: " + isbn + ",\n" +
                publisher + ",\n" +
                "format: " + format + ",\n" +
                "reviews: " + reviews + ",\n" +
                "awards: " + awards + ",\n";
    }

    // Доп задание
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("    <book id=\"").append(id).append("\">\n");               // Открываем тег book с атрибутом id
        xml.append("        <title>").append(title).append("</title>\n");       // Добавляем тег title
        xml.append("        <author>").append(author).append("</author>\n");    // Тег author
        xml.append("        <year>").append(year).append("</year>\n");          // Тег year
        xml.append("        <genre>").append(genre).append("</genre>\n");       // Тег genre
        xml.append("        <price currency=\"").append(currency).append("\">").append(price).append("</price>\n"); // Тег genre

        // Тег isbn если он есть
        if (isbn != null) {
            xml.append("        <isbn>").append(isbn).append("</isbn>\n");
        }

        // Тег format
        if (format != null) {
            xml.append("        <format>").append(format).append("</format>\n");
        }

        xml.append("        ").append(publisher.toXML()).append("\n");          // Тег publisher

        // Добавляем reviews если он есть
        if (reviews != null && !reviews.isEmpty()) {
            xml.append("        <reviews>\n");
            for (Reviews review : reviews) {
                xml.append("            ").append(review.toXML()).append("\n");  // Вызываем toXML() у каждого отзыва
            }
            xml.append("        </reviews>\n");
        }

        // Добавляем awards если онесть
        if (awards != null && !awards.isEmpty()) {
            xml.append("        <awards>\n");
            for (String award : awards) {
                xml.append("             <award>").append(award).append("</award>\n");  // Добавляем каждую награду
            }
            xml.append("        </awards>\n");
        }
        xml.append("    </book>\n");  // Закрываем тег book
        return xml.toString();
    }
}
