package pe.edu.cibertec.elevatechApp.retrofit.api

import pe.edu.cibertec.elevatechApp.retrofit.request.InspeccionRequest
import pe.edu.cibertec.elevatechApp.retrofit.request.LoginRequest
import pe.edu.cibertec.elevatechApp.retrofit.response.LoginResponse
import pe.edu.cibertec.elevatechApp.retrofit.response.OrdenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IElevaTechService {

    @POST("api/login")
    fun iniciarSesion(@Body pedido: LoginRequest): Call<LoginResponse>

    @GET("api/ordenes/tecnico/{idTecnico}")
    fun obtenerOrdenes(@Path("idTecnico") idTecnico: Int): Call<List<OrdenResponse>>

    @POST("api/inspecciones")
    fun sincronizarInspeccion(@Body request: InspeccionRequest): Call<Void>
}
