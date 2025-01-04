
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

    /*public String toXml() {
        StringBuilder xml = new StringBuilder();
        xml.append("<review>\n");
        xml.append("<user>").append(user).append("</user>\n");
        xml.append("<rating>").append(rating).append("</rating>\n");
        xml.append("<comment>").append(comment).append("</comment>\n");
        xml.append("</review>");
        return xml.toString();
    }
*/
}
