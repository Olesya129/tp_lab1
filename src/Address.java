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
        return "\n" +
                "city=" + city + '\n' +
                "country=" + country + '\n';
    }

/*    // Доп задание: метод для преобразования объекта Address в XML
    public String toXml() {
        StringBuilder xml = new StringBuilder();
        xml.append("<address>\n");
        xml.append("<city>").append(city).append("</city>\n");
        xml.append("<country>").append(country).append("</country>\n");
        xml.append("</address>");
        return xml.toString();
    }*/

}
