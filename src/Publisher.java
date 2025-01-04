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
}