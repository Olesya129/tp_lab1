public class Address {
    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "city - " + city +
                ", country - " + country;
    }

    //Доп
    public String toXML() {
        return "<address>\n" +
                "                   <city>" + city + "</city>\n" +  // Тег city
                "                   <country>" + country + "</country>\n" +  // Тег country
                "             </address>";
    }
}
