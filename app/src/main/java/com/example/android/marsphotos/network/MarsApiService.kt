package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Crie um objeto Retrofit com o URL base e a fábrica de conversores.
//Crie uma interface que explique como a Retrofit se comunica com nosso servidor da Web.
//Crie um serviço Retrofit e exponha a instância ao serviço da API no restante do app.

//URL do servidor
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//builder do moshi que vai interpretar o Json do Response
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//como a Retrofit se comunicará com o servidor da Web usando solicitações HTTP.
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>
}

//objeto singleton que sera acessado pelo resto do app
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}