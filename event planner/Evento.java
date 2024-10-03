// Clase abstracta que representa un evento genérico
public abstract class Evento {
    protected String nombre; // Nombre del evento
    protected int espacioNecesario; // Espacio requerido para el evento (en metros cuadrados o número de asistentes)
    protected int tiempoNecesario; // Tiempo necesario para el evento (en horas)
    protected boolean cancelado; // Indica si el evento ha sido cancelado
    protected String horario; // Horario en el que se llevará a cabo el evento

    // Constructor de la clase Evento
    public Evento(String nombre, int espacioNecesario, int tiempoNecesario) {
        this.nombre = nombre; // Inicializa el nombre del evento
        this.espacioNecesario = espacioNecesario; // Inicializa el espacio necesario
        this.tiempoNecesario = tiempoNecesario; // Inicializa el tiempo necesario
        this.cancelado = false; // Inicializa el estado de cancelación como falso
        this.horario = null; // Inicializa el horario como nulo
    }

    // Método para planificar el evento en un horario específico
    public void planificar(String horario) {
        if (!this.cancelado) { // Verifica si el evento no ha sido cancelado
            this.horario = horario; // Asigna el horario al evento
            System.out.println("El evento '" + this.nombre + "' ha sido planificado para las " + horario + "."); // Mensaje de confirmación
        } else {
            System.out.println("El evento '" + this.nombre + "' está cancelado y no puede planificarse."); // Mensaje de error si está cancelado
        }
    }

    // Método para cancelar el evento
    public void cancelar() {
        this.cancelado = true; // Cambia el estado de cancelación a verdadero
        System.out.println("El evento '" + this.nombre + "' ha sido cancelado."); // Mensaje de confirmación
    }

    // Método para modificar el horario del evento
    public void modificarHorario(String nuevoHorario) {
        if (!this.cancelado) { // Verifica si el evento no ha sido cancelado
            this.horario = nuevoHorario; // Asigna el nuevo horario al evento
            System.out.println("El evento '" + this.nombre + "' ha cambiado de horario a las " + nuevoHorario + "."); // Mensaje de confirmación
        } else {
            System.out.println("No se puede modificar el horario de un evento cancelado."); // Mensaje de error si está cancelado
        }
    }

    // Método para mostrar la información del evento
    public void mostrarInfo() {
        if (!this.cancelado) { // Verifica si el evento no ha sido cancelado
            System.out.println("Evento: " + this.nombre + ", Horario: " + this.horario + 
                ", Espacio: " + this.espacioNecesario + ", Duración: " + this.tiempoNecesario + " horas."); // Muestra información del evento
        }
    }

    // Método para obtener el horario del evento
    public String getHorario() {
        return horario; // Retorna el horario del evento
    }

    // Método para obtener el tiempo necesario para el evento
    public int getTiempoNecesario() {
        return tiempoNecesario; // Retorna el tiempo necesario para el evento
    }
}
