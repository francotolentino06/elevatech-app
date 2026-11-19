package pe.edu.cibertec.elevatechApp.retrofit

import okhttp3.OkHttpClient
import pe.edu.cibertec.elevatechApp.retrofit.api.IElevaTechService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClienteElevaTechRetrofit {

    /**
     * URL base de la API de ElevaTech. Es el único lugar donde aparece.
     * 10.0.2.2 es la computadora vista desde el emulador de Android.
     * Para un celular real se cambia por la IP de la computadora en la red local
     * (por ejemplo "http://192.168.1.50:5080/"), con la API escuchando en 0.0.0.0:5080.
     */
    private const val URL_BASE = "http://10.0.2.2:5080/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { cadena ->
            val token=pe.edu.cibertec.elevatechApp.Sesion.token(pe.edu.cibertec.elevatechApp.ElevaTechApplication.instancia)
            val pedido=cadena.request().newBuilder()
            if(token.isNotBlank()) pedido.header("Authorization", "Bearer "+token)
            cadena.proceed(pedido.build())
        }
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitElevaTechService: IElevaTechService by lazy {
        buildRetrofit().create(IElevaTechService::class.java)
    }
}
