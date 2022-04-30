/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act12;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alexm
 */
public class Act12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
        AddressBook addressBook = new AddressBook();
         Scanner scanner = new Scanner(System.in);
          int select = -1;
          String Nombre;
         String telefono;

        //Mientras la opción elegida sea 0, se termina el programa
        while(select != 0){
            //Try catch para evitar que el programa termine si hay un error
            try {
                System.out.println("Bienvenido a AddressBook!\n"+"Elige un opción:\n1.- Agregar Contacto" +
                        "\n2.- Mostar Contactos\n" +
                        "3.- Eliminar contacto\n" +
                        "0.- Salir");
                select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        System.out.println("Dame el nombre:");
                        Nombre = scanner.nextLine();
                        addressBook.setNombre(Nombre);
                        System.out.println("Dame el telefono:");
                        telefono = scanner.nextLine();
                         addressBook.setTelefono(telefono);
                        addressBook.guardar(addressBook.getTelefono(),addressBook.getNombre(), addressBook.contacto);
                        break;
                    case 2:
                        addressBook.mostarContacto(addressBook.contacto);
                        break;
                    case 3:
                        System.out.print("introduzca el numero de telefono: ");
                        telefono = scanner.nextLine();
                         addressBook.setTelefono(telefono);
                        addressBook.eliminarContacto(addressBook.getTelefono(), addressBook.contacto);
                        break;
                    case 0:
                        System.out.println("Gracias por su visita");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            }catch (Exception e){
                System.out.println("Error");
            }
        }
    }
    
}
