package pe.edu.cibertec.elevatechApp
import android.app.Application
class ElevaTechApplication : Application() {
    override fun onCreate() { super.onCreate(); instancia=this }
    companion object { lateinit var instancia: ElevaTechApplication; private set }
}
