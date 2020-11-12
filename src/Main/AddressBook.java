package Main;

import java.io.*;
import java.util.*;

public class AddressBook {
    Map<String, String> prs = new HashMap();

    Scanner sc = new Scanner(System.in);
    BufferedWriter bw=null;
    BufferedReader br=null;
    FileWriter fw;
    File file;
    Set set = prs.entrySet();
    Iterator iterator;
    String toSave;
    Map.Entry mIn;

    public void load() {
        file = new File("src/contacts.csv");   //carga el archivo
        if (!file.exists()) {
            try {
                file.createNewFile();               //Si no existe el archivo lo crea
                System.out.println("Archivo creado con exito");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El archivo ya existia, se cargo");
    }

    public void save() {
        iter();
        try {
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            fw.write(toSave);
            System.out.println("Guardado exitosamente");
            prs.clear();
        } catch (NullPointerException | IOException e) {
            System.out.println("!");
        }
    }
    public void iter() {
        try{
        iterator = set.iterator();
        System.out.println("Los contactos son: ");
        while (iterator.hasNext()) {
            Map.Entry mIn = (Map.Entry) iterator.next();
            toSave = " \n " + mIn.getKey() + " : " + mIn.getValue() + "\n";

            System.out.print(" \n " + mIn.getKey() + " : " + mIn.getValue() + "\n");
        }} catch (NullPointerException e){
            System.out.println("!");
        }
    }
    public void list() {
        iter();
        try {
            br = new BufferedReader(new FileReader("src/contacts.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line + "\n");
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("Finalizado ");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch ( IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public void create() {
        String tel, name;
        System.out.println("Ingrese el numero telefonico");
        tel = sc.nextLine();
        System.out.println("Ingrese el nombre");
        name = sc.nextLine();
        prs.put(tel, name);
        System.out.println("Contacto guardado como " + tel + " : " + name);
    }

    public void delete() {
        String del;
        String conf;
        System.out.println("Ingrese el numero telefonico que desea eliminar");
        del = sc.nextLine();
        System.out.println("Esta seguro que desea eliminar el contacto " + del + "? (S/N)");
        conf = sc.nextLine();
        if (conf.equals("S")) {
            prs.remove(del);
        }
    }
}