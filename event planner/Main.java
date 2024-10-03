import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas
import java.util.Scanner;   // Importa la clase Scanner para la entrada de datos

public class Main {
    // Lista de eventos planificados
    private static ArrayList<Evento> eventos = new ArrayList<>(); // Crea una lista que almacena objetos de tipo Evento
    private static Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

    public static void main(String[] args) {
        mostrarMenu(); // Llama al método para mostrar el menú principal
    }

    // Método que muestra el menú de opciones al usuario
    public static void mostrarMenu() {
        while (true) { // Bucle infinito que se ejecuta hasta que el usuario decida salir
            System.out.println("\n---- Menú de Planificación de Eventos ----");
            System.out.println("1. Planificar una conferencia");
            System.out.println("2. Planificar un taller");
            System.out.println("3. Planificar un evento de networking");
            System.out.println("4. Cancelar un evento");
            System.out.println("5. Modificar horario de un evento");
            System.out.println("6. Ver todos los eventos planificados");
            System.out.println("7. Salir");

            System.out.print("Selecciona una opción: "); // Pide al usuario que seleccione una opción
            String opcion = sc.nextLine(); // Lee la opción elegida por el usuario

            // Estructura de control que ejecuta la acción correspondiente según la opción elegida
            switch (opcion) {
                case "1":
                    planificarEvento(new Conferencia(pedirNombre("conferencia"))); // Planifica una conferencia
                    break;
                case "2":
                    planificarEvento(new Taller(pedirNombre("taller"))); // Planifica un taller
                    break;
                case "3":
                    planificarEvento(new Networking(pedirNombre("evento de networking"))); // Planifica un evento de networking
                    break;
                case "4":
                    cancelarEvento(); // Cancela un evento existente
                    break;
                case "5":
                    modificarHorario(); // Modifica el horario de un evento existente
                    break;
                case "6":
                    verEventos(); // Muestra todos los eventos planificados
                    break;
                case "7":
                    System.out.println("Saliendo del simulador de planificación."); // Mensaje de salida
                    return; // Sale del método y termina el programa
                default:
                    System.out.println("Opción no válida. Intente de nuevo."); // Manejo de opciones no válidas
            }
        }
    }

    // Método para pedir el nombre de un evento
    public static String pedirNombre(String tipo) {
        System.out.print("Ingresa el nombre del " + tipo + ": "); // Pide al usuario que ingrese el nombre del evento
        return sc.nextLine(); // Retorna el nombre ingresado
    }

    // Método para planificar un nuevo evento
    public static void planificarEvento(Evento evento) {
        System.out.print("Ingresa el horario para el evento '" + evento.nombre + "' (formato HH:MM): "); // Solicita el horario
        String horario = sc.nextLine(); // Lee el horario ingresado por el usuario

        // Verifica si el horario está disponible antes de planificar el evento
        if (horarioDisponible(horario, evento.getTiempoNecesario())) {
            evento.planificar(horario); // Si está disponible, planifica el evento
            eventos.add(evento); // Añade el evento a la lista de eventos
        } else {
            System.out.println("El horario " + horario + " ya está ocupado."); // Informa que el horario ya está ocupado
        }
    }

    // Método que verifica si un horario está disponible para un nuevo evento
    public static boolean horarioDisponible(String horario, int duracion) {
        for (Evento evento : eventos) { // Itera sobre la lista de eventos
            // Verifica si el horario del evento actual coincide con el horario deseado
            if (evento.getHorario() != null && evento.getHorario().equals(horario)) {
                return false; // Devuelve false si hay un conflicto de horarios
            }
        }
        return true; // Devuelve true si el horario está disponible
    }

    // Método para cancelar un evento existente
    public static void cancelarEvento() {
        System.out.print("Ingresa el nombre del evento a cancelar: "); // Pide al usuario el nombre del evento a cancelar
        String nombre = sc.nextLine(); // Lee el nombre ingresado

        // Busca el evento por su nombre en la lista de eventos
        for (Evento evento : eventos) {
            if (evento.nombre.equals(nombre)) { // Si encuentra el evento
                evento.cancelar(); // Cancela el evento
                return; // Sale del método
            }
        }
        System.out.println("No se encontró ningún evento con el nombre '" + nombre + "'."); // Informa si no se encontró el evento
    }

    // Método para modificar el horario de un evento existente
    public static void modificarHorario() {
        System.out.print("Ingresa el nombre del evento para modificar su horario: "); // Pide el nombre del evento
        String nombre = sc.nextLine(); // Lee el nombre ingresado

        // Busca el evento en la lista
        for (Evento evento : eventos) {
            if (evento.nombre.equals(nombre)) { // Si encuentra el evento
                System.out.print("Selecciona el nuevo horario para '" + nombre + "' (formato HH:MM): "); // Solicita el nuevo horario
                String nuevoHorario = sc.nextLine(); // Lee el nuevo horario

                // Verifica si el nuevo horario está disponible
                if (horarioDisponible(nuevoHorario, evento.getTiempoNecesario())) {
                    evento.modificarHorario(nuevoHorario); // Modifica el horario del evento
                } else {
                    System.out.println("El nuevo horario " + nuevoHorario + " ya está ocupado."); // Informa de un conflicto
                }
                return; // Sale del método
            }
        }
        System.out.println("No se encontró ningún evento con el nombre '" + nombre + "'."); // Informa si no se encontró el evento
    }

    // Método para mostrar todos los eventos planificados
    public static void verEventos() {
        if (eventos.isEmpty()) { // Comprueba si la lista de eventos está vacía
            System.out.println("No hay eventos planificados."); // Informa que no hay eventos
        } else {
            // Si hay eventos, muestra la información de cada uno
            for (Evento evento : eventos) {
                evento.mostrarInfo(); // Llama al método para mostrar la información del evento
            }
        }
    }
}
