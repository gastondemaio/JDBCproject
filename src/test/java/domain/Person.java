package domain;

public class Person {
    private int idPerson;
    private String name;
    private String lastName;
    private String cellphone;
    private String email;

    public Person() {
    }

    public Person(int idPerson) {
        this.idPerson = idPerson;
    }

    public Person(String name, String lastName, String cellphone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Person(int idPerson, String name, String lastName, String cellphone, String email) {
        this.idPerson = idPerson;
        this.name = name;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.email = email;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
