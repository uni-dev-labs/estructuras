package arraylist.models;

public class Main {

    public static void main(String[] args) {

        ListaEnlazada<Terrestre> terrestres = new ListaEnlazada<>();
        ListaEnlazada<Maritimo> maritimos = new ListaEnlazada<>();
        ListaEnlazada<Aereo> aereos = new ListaEnlazada<>();

        Menu.iniciarMenu(terrestres, maritimos, aereos);
    }
}