// Clase que representa un evento de networking, que hereda de la clase Evento
public class Networking extends Evento {
    // Constante que define el espacio requerido para un evento de networking
    public static final int ESPACIO_NETWORKING = 30; // Espacio en metros cuadrados o número de asistentes permitidos

    // Constante que define la duración de un evento de networking (en horas)
    public static final int TIEMPO_NETWORKING = 1; // Duración de 1 hora

    // Constructor de la clase Networking
    public Networking(String nombre) {
        // Llama al constructor de la clase base Evento con el nombre, espacio y tiempo predefinidos
        super(nombre, ESPACIO_NETWORKING, TIEMPO_NETWORKING);
    }
}
