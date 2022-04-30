/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alexm
 */
public class AddressBook {
    
     String Nombre;
     String telefono;

    HashMap<String,String> contacto;
    public AddressBook() throws IOException {
        contacto = new HashMap<String, String>();
        guardar(telefono, Nombre, contacto);
        mostarContacto(contacto);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HashMap<String, String> getContacto() {
        return contacto;
    }

    public void setContacto(HashMap<String, String> contacto) {
        this.contacto = contacto;
    }
    
    

    public void guardar(String telefono, String nombre,  HashMap<String, String> contacto) throws IOException {
        //Verifica si el telefono se repite o no en dado caso que no se repita hara el push
        if (contacto.containsKey(telefono)){
            System.out.println("No se puede introducir el contato. El numero de telfono esta repetido\n");
        }else{
            contacto.put(telefono,  " " + nombre);
            System.out.println();
        }
        //crea el archivo si no existe, en dado caso de existir solo pondra los datos que no tengan el
        //telefono repetido
        File Contactos =new File("Contactos.txt");
        FileOutputStream fos=new FileOutputStream(Contactos);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(contacto);
        oos.flush();
        oos.close();
        fos.close();


    }

    public void mostarContacto(HashMap<String, String> contacto)  {
        try{
            //busca todos los datos del txt y los muestra
            File Contactos = new File("Contactos.txt");
            FileInputStream fis = new FileInputStream(Contactos);
            ObjectInputStream ois = new ObjectInputStream(fis);

            contacto = (HashMap<String, String>) ois.readObject();

            ois.close();
            fis.close();
            for(Map.Entry<String,String> m :contacto.entrySet()){
                System.out.println(m.getKey()+" : "+m.getValue());
            }
        }catch (Exception e){

        }

    }

    public void eliminarContacto(String telefono, HashMap<String, String> contacto) throws IOException {
        //Verifica que el numero exista y en dado caso de existir elimina el numero
        if (contacto.containsKey(telefono)){
            contacto.remove(telefono);
            System.out.println("Se ha eliminado con exito el usuario.\n");
        }else{
            System.out.println("No existe el contacto.\n");
        }
        //se hace una actualizacion al archivo txt
        File Contactos =new File("Contactos.txt");
        FileOutputStream fos=new FileOutputStream(Contactos);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(contacto);
        oos.flush();
        oos.close();
        fos.close();
    }
    
    
}
