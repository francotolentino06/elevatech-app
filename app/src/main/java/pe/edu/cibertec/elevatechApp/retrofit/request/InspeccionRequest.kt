package pe.edu.cibertec.elevatechApp.retrofit.request

data class EvidenciaRequest(val nombreArchivo: String, val fotoBase64: String)
data class InspeccionRequest(
    val idOrden: Int,
    val fechaHoraReal: String,
    val observaciones: String,
    val items: List<ItemInspeccionRequest>,
    val evidencias: List<EvidenciaRequest>
)
