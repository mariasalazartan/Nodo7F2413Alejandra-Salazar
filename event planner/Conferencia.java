// Clase que representa un evento de conferencia, que hereda de la clase Evento
public class Conferencia extends Evento {
    // Constante que define el espacio requerido para un evento de conferencia
    public static final int ESPACIO_CONFERENCIA = 100; // Espacio en metros cuadrados o número de asistentes permitidos

    // Constante que define la duración de un evento de conferencia (en horas)
    public static final int TIEMPO_CONFERENCIA = 3; // Duración de 3 horas

    // Constructor de la clase Conferencia
    public Conferencia(String nombre) {
        // Llama al constructor de la clase base Evento con el nombre, espacio y tiempo predefinidos
        super(nombre, ESPACIO_CONFERENCIA, TIEMPO_CONFERENCIA);
    }
}

