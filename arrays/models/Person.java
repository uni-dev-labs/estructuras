package arrays.models;

public class Person {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String gender;
    private String[] grades;

    // Constructor público - permite crear objetos Person desde otras clases
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person(
        String name,
        int age,
        String email, 
        String phone, 
        String address, 
        String city,
        String state,
        String zip,
        String country,
        String gender, 
        String[] grades
    ) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.gender = gender;
        this.grades = grades;
        }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getCountry() {
        return country;
    }
    public String getGender() {
        return gender;
    }
    public String[] getGrades() {
        return grades;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setGrades(String[] grades) {
        this.grades = grades;
    }

    // Método para imprimir información de la persona
    public void printPerson() {
        System.out.println("=== Información de la Persona ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Country: " + country);
        System.out.println("Gender: " + gender);
        if (grades != null && grades.length > 0) {
            System.out.println("Grades: " + String.join(", ", grades));
        }
        System.out.println("================================");
    }

}
