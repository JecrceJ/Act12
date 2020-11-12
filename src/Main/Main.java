package Main;
import java.util.Scanner;
public class Main {                                                     //Creacion de la clase principal
    public static void main(String[] args) {                            //Metodo principal
        int sel;
        AddressBook ab = new AddressBook();                             //Iniciacion de las clases
        do {
            sel=showMenu();
            switch (sel) {
                case 1 -> ab.load();
                case 2 -> ab.save();
                case 3 -> ab.list();
                case 4 -> ab.create();
                case 5 -> ab.delete();
            }
        } while (sel!=0);    }
    public static int showMenu() {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Selecciona una opcion:\n" +
                "1 cargar archivo\n" +
                "2 guardar archivo\n" +
                "3 listar contactos\n" +
                "4 crear contacto\n" +
                "5 eliminar contacto\n" +
                "0 Salir");
        a = sc.nextInt();
        return a;
    }
}