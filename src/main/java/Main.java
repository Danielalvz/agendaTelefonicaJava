import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contacto a = new Contacto("Armando Casas", "3108255252");
        Contacto b = new Contacto("Armando Tejares", "3108255253");
        Agenda.agregarContacto(a);
        Agenda.agregarContacto(b);
        Agenda.listarContactos();

        int contador = 1;
        int opcion = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a su agenda telefonica");
        do {
            System.out.println("Menu agenda:");
            System.out.println("1 para agregar contacto");
            System.out.println("2 para ver contactos");
            System.out.println("3 para eliminar contactos");
            System.out.println("4 para buscar contacto");
            System.out.println("5 para salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Contacto #" + contador);
                    System.out.println("Escriba nombre de contacto: ");
                    String nombre = sc.nextLine();

                    System.out.println("Escriba teléfono de contacto: ");
                    String telefono = sc.nextLine();

                    Contacto c = new Contacto(nombre, telefono);

                    if(Agenda.agregarContacto(c)) {
                        contador++;
                    }
                    break;
                case 2:
                    Agenda.listarContactos();
                    break;
                case 3:
                    System.out.println("Escriba el nombre del contacto que desee eliminar");
                    String contactoAEliminar = sc.nextLine();

                    if(Agenda.eliminarContacto(contactoAEliminar)) {
                        contador--;
                    }
                    break;
                case 4:
                    System.out.println("Escriba el nombre del contacto que quiere buscar");
                    String nombreABuscar = sc.nextLine();

                    Agenda.buscarContacto(nombreABuscar);
                    break;
                case 5:
                    System.out.println("Estas saliendo de la agenda telefónica..");
                    break;
                default:
                    System.out.println("Esta opción no está disponible");
                    break;
            }
        } while (opcion != 5);
    }
}
