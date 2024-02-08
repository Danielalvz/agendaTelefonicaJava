import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private static List<Contacto> contactos = new ArrayList<>();
    private static final int limiteContactos = 10;

    public static boolean agregarContacto(Contacto contacto) {
        if(contactos.size() < limiteContactos) {
            if(!existeContacto(contacto)) {
                contactos.add(contacto);
                espaciosLibres(); //muestra en pantalla cuantos espacios libres quedan
                return true;
            } else {
                System.out.println("No puedes añadir un contacto ya existente");
                return false;
            }
        } else {
            agendaLlena();
            return false;
        }
    }

    public static void listarContactos() {
        for (Contacto contacto: contactos) {
            System.out.println(contacto);
        }
    }

    public static boolean existeContacto(Contacto contacto) {
        for (Contacto c : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(c.getNombre())) {
                System.out.println("El contacto ya existe");
                return true;
            }
        }
        return false;
    }

    public static void agendaLlena() {
        if(contactos.size() == limiteContactos) {
            System.out.println("Agenda llena");
        }
    }

    public static boolean eliminarContacto(String nombre) {
        for (Contacto c: contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(c);
                System.out.println("Contacto eliminado");
                return true;
            }
        }
        System.out.println("No se encontró ese contacto");
        return false;
    }

    public static void buscarContacto(String nombre) {
        boolean encontrado = false;

        for (Contacto c: contactos) {
            if(c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado");
                System.out.println(c);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ese contacto");
        }
    }

    public static void espaciosLibres() {
        if(contactos.size() >= limiteContactos) {
            System.out.println("Espacios disponibles: 0");
        } else {
            System.out.println("Espacios disponibles: " + (limiteContactos - contactos.size()));
        }
    }
}
