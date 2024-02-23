import java.sql.SQLOutput;
import java.util.Scanner;

public class MainTelefono {
    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefono = new TelefonoMovil("987654321");

    public static void main(String[] args) {
        boolean seguir = true;
        int eleccion;
        printMenu();
        while (seguir) {
            System.out.print("Ingrese una opción: ");
            eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 0:
                    seguir = false;
                    break;
                case 1:
                    telefono.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("0. Salir");
        System.out.println("1. Imprimir contactos");
        System.out.println("2. Agregar un nuevo contacto");
        System.out.println("3. Actualizar un contacto existente");
        System.out.println("4. Eliminar contacto de la lista");
        System.out.println("5. Buscar/encontrar contacto por nombre");
        System.out.println("6. Volver a imprimir la lista de opciones");
    }

    private static void addNewContact() {
        System.out.println("Nombre del contacto: ");
        String name = scanner.nextLine();
        System.out.println("Número de telefono: ");
        String phoneNumber = scanner.nextLine();
        Contacto nuevoContacto = Contacto.createContact(name,phoneNumber);
        if (telefono.addNewContact(nuevoContacto)){
            System.out.println("Contacto añadido");
        } else {
            System.out.println("Comprueba que lo hayas puesto bien o que no exista");
        }
    }

    private static void updateContact() {
        System.out.println("¿Cual quieres actualizar? Ingresa su nombre");
        String antiguoNombre = scanner.nextLine();
        int index = telefono.findContact(antiguoNombre);
        if (index >= 0) {
            Contacto contactoViejo = telefono.queryContact(antiguoNombre);
            System.out.print("Ingresa el nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo número de teléfono del contacto: ");
            String nuevoNumero = scanner.nextLine();
            Contacto contactoNuevo = Contacto.createContact(nuevoNombre, nuevoNumero);
            if (telefono.updateContact(contactoViejo, contactoNuevo)) {
                System.out.println("Contacto actualizado exitosamente.");
            } else {
                System.out.println("No se puede actualizar el contacto. Ya existe un contacto con el mismo nombre o número de teléfono.");
            }
        } else {
            System.out.println("El contacto no existe.");
        }

    }

    private static void removeContact() {
        System.out.println("¿A quien quieres eliminar?");
        String name = scanner.nextLine();
        Contacto contacto = telefono.queryContact(name);
        if (contacto != null) {
            if (telefono.removeContact(contacto)) {
                System.out.println(contacto.toString() + "ha sido eliminado correctamente");
            } else {
                System.out.println("No se ha podido eliminar");
            }
        } else {
            System.out.println("El contacto no existe");
        }
    }

    private static void searchContact() {
        System.out.println("Ingrese el nombre del contacto que desea buscar: ");
        String name = scanner.nextLine();
        Contacto contacto = telefono.queryContact(name);
        if (contacto != null) {
            System.out.println("Contacto encontrado: "+ contacto.toString());
        } else {
            System.out.println("El contacto no existe");
        }

    }



    }