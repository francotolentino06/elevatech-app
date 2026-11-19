package pe.edu.cibertec.elevatechApp.retrofit.request

/** Cuerpo de POST api/login. La clave solo viaja en esta llamada; nunca se guarda en el celular. */
data class LoginRequest(
    val usuario: String,
    val clave: String
)
