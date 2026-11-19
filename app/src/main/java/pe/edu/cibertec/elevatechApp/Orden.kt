package pe.edu.cibertec.elevatechApp

/** Orden de trabajo tal como se guarda en la tabla local `orden`. */
data class Orden(
    val idOrden: Int,
    val cliente: String,
    val direccion: String,
    val equipoTipo: String,
    val equipoCodigo: String,
    val ubicacion: String,
    val fechaProgramada: String,
    val estado: String
)
