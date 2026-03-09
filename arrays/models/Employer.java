package arrays.models;

import java.util.Arrays;

public class Employer {
    private String id;
    private String name;
    private String lastName;
    private char gender;
    private String[] titles;

    public Employer(String id, String name, String lastName, char gender, String[] titles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.titles = titles;
    }

    public Employer() {}


    public Employer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public char getGender() {
        return gender;
    }
    public String[] getTitles() {
        return titles;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setTitles(String[] grades) {
        this.titles = grades;
    }
    public void printEmployer() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + lastName);
        System.out.println("Género: " + gender);
        System.out.println("Calificaciones: " + Arrays.toString(titles));
        System.out.println("================================");
    }


    public String getIndividualTitle(int index_title) {
        if (titles == null) {
            return "No hay títulos cargados";
        }

        if (index_title >= 0 && index_title < titles.length) {
            if (titles[index_title] == null) {
                return "No hay título para este índice";
            }
            return titles[index_title];
        }
        return "No hay título para este índice";
    }
}
