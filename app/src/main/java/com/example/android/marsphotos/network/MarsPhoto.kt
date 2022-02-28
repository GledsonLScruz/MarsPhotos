package com.example.android.marsphotos.network

import com.squareup.moshi.Json

//Moshi analisa dados JSON e converte em objetos Kotlin
// Classe de dados que armazena os resultados do moshi
// Anotação @Json procurar no json por img_src e atribuir a imgSrcUrl (nome do valor diferente do json)
data class MarsPhoto(
  val id: String, @Json(name = "img_src") val imgSrcUrl: String
)