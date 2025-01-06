
public class Reviews {
    private String user;
    private int rating;
    private String comment;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "user - " + user  +
                ", rating - " + rating  +
                ", comment - " + comment;
    }

    // Доп
    public String toXML() {
        return " <review>\n" +
                "                   <user>" + user + "</user>\n" +         // Тег user
                "                   <rating>" + rating + "</rating>\n" +   // Тег rating
                "                   <comment>" + comment + "</comment>\n" +  // Тег comment
                "             </review>";
    }
}
