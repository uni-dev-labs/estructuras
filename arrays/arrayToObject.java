package arrays;

import arrays.models.Person;

/**
 * DESCRIPCIÓN DEL PROBLEMA:
 * Necesito crear un programa que guarde varias personas en un arreglo de objetos (Person),
 * permitiendo crear personas con nombre, edad y email opcional; asignarlas a posiciones del arreglo,
 * imprimir nombre, edad o email por índice, y recorrer todo el arreglo con for y for-each
 */

public class arrayToObject {

    public static void main(String[] args) {
        int size = 4;
        Person[] persons = new Person[size];
        
        // Crear la persona (email opcional)
        Person person_one = createPerson("manuel", 20);                         // sin email
        Person person_two = createPerson("juan", 21, "juan@mail.com");   // con email
        Person person_three = createPerson("pedro", 22);                       // sin email (o pasar null)
       
        setPersonInArray(persons, person_one, 0);
        setPersonInArray(persons, person_two, 1);
        setPersonInArray(persons, person_three, 2);
        
        // Imprimir la persona
        printPersonName(persons, 0);
        printPersonName(persons, 1);
        printPersonAge(persons, 2);

        printPersonEmail(persons, 0);
        printPersonEmail(persons, 1);

        // Imprimir la persona EN LA POSICION 3 (NO EXISTE)
        printPersonEmail(persons, 3);


        System.out.println("--------------------------------");
        printAllPersonsNamesWithFor(persons);
        System.out.println("--------------------------------");
        printAllPersonsNamesWithForEach(persons);
    }


    /** Crea una persona solo con nombre y edad. */
    public static Person createPerson(String name, int age) {
        return new Person(name, age);
    }

    /**
     * Crea una persona con nombre, edad y email opcional.
     * Si email es null o vacío, se ignora (igual que crear sin email).
     */
    public static Person createPerson(String name, int age, String email) {
        if (email == null || email.isBlank()) return new Person(name, age);
        return new Person(name, age, email);
    }

    public static void setPersonInArray(Person[] persons, Person person, int index) {
        persons[index] = person;
    }

    public static void printPersonName(Person[] persons, int index) {
        System.out.println("Nombre de la persona: " + persons[index].getName());
    }

    public static void printPersonAge(Person[] persons, int index) {
        System.out.println("Edad de la persona: " + persons[index].getAge());
    }

    public static void printPersonEmail(Person[] persons, int index) {
        if (persons[index] == null) {
            System.out.println("Persona no encontrada");
            return;
        }
        System.out.println("Email de la persona: " + persons[index].getEmail());
    }

    public static void printAllPersonsNamesWithForEach(Person[] persons) {
        for (Person person : persons) {
            if (person == null) {
                System.out.println("Persona no encontrada");
                continue;
            }
            System.out.println("Nombre de la persona: " + person.getName());
        }
    }

    public static void printAllPersonsNamesWithFor(Person[] persons) {
        for (int position = 0; position < persons.length; position++) {

            if (persons[position] == null) {
                System.out.println("Persona no encontrada");
                continue;
            }
            System.out.println("Nombre de la persona en la posición " + position + ": " + persons[position].getName());
        }
        
    }
}
