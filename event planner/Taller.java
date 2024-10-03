// Clase que representa un evento de taller, que hereda de la clase Evento
public class Taller extends Evento {
    // Constante que define el espacio requerido para un evento de taller
    public static final int ESPACIO_TALLER = 50; // Espacio en metros cuadrados o número de asistentes permitidos

    // Constante que define la duración de un evento de taller (en horas)
    public static final int TIEMPO_TALLER = 2; // Duración de 2 horas

    // Constructor de la clase Taller
    public Taller(String nombre) {
        // Llama al constructor de la clase base Evento con el nombre, espacio y tiempo predefinidos
        super(nombre, ESPACIO_TALLER, TIEMPO_TALLER);
    }
}
