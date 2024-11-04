import java.util.List;

public class Publisher {
    private String name;
    private List<String> address; //0-city, 1-country


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n" +
                "name: " + name + '\n' +
                "address: " + address;
    }


   /* // Доп задание: метод для преобразования объекта Publisher в XML
    public String toXml() {
        StringBuilder xml = new StringBuilder();
        xml.append("<publisher>\n");
        xml.append("<name>").append(name).append("</name>\n");

        if (address != null && address.size() == 2) {
            xml.append("<address>\n");
            xml.append("<city>").append(address.get(0)).append("</city>\n");
            xml.append("<country>").append(address.get(1)).append("</country>\n");
            xml.append("</address>\n");
        }

        xml.append("</publisher>");
        return xml.toString();
    }*/

}
