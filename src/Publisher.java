public class Publisher {
    private String name;
    private Address address;  // Используем объект Address

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "publisher: [ " +
                "name - " + name +
                ", address - [ " + address +
                " ]]";
    }

    // Доп. задание
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<publisher>\n");
        xml.append("             <name>").append(name).append("</name>\n");
        xml.append("             ").append(address.toXML()).append("\n");
        xml.append("        </publisher>");
        return xml.toString();
    }
}