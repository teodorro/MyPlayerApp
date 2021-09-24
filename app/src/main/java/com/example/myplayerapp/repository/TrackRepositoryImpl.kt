package com.example.myplayerapp.repository

import com.example.myplayerapp.dto.Track
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.concurrent.thread

@Singleton
class TrackRepositoryImpl @Inject constructor() : TrackRepository {
    private val client = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).build()
    private val gson = Gson()
    private val typeToken = object : TypeToken<List<Track>>() {}

    companion object {
        //        const val BASE_URL = "http://https://www.soundhelix.com/audio-examples/mp3/"
        const val BASE_URL =
            "https://raw.githubusercontent.com/netology-code/andad-homeworks/master/09_multimedia/data/"
        val jsonType = "application/json".toMediaType()
    }


//    override val data = getTracks()
//        .flowOn(Dispatchers.Default)
////    override val data = flowOf(getTracks())
////        .flowOn(Dispatchers.Default)
//
//    suspend fun getTracks(): Flow<List<Track>> {
//        // check on postman
//            val request: Request = Request.Builder()
//                .url("${BASE_URL}album.json")
//                .build()
//
//            client.newCall(request)
//                .execute()
//                .use { response ->
//                    if (!response.isSuccessful)
//                        println("shit...")
//                    for ((name, value) in response.headers) {
//                        println("$name: $value")
//                    }
//                    println(response.body!!.string())
//                }
//
//        return emptyList()
//
//
////        var a: List<Track> = client.newCall(request)
////            .execute().use { it.body?.string() }
////            .let { gson.fromJson(it, typeToken.type) }
////        return a
//
////        return client.newCall(request)
////            .execute().use { it.body?.string() }
////            .let { gson.fromJson(it, typeToken.type) }
//    }

//    override val data = getTracks()
//        .flowOn(Dispatchers.IO)
    override val data = getTracks()
        .flowOn(Dispatchers.IO)

    fun getTracks(): Flow<List<Track>> {
        // check on postman
        val request: Request = Request.Builder()
            .url("${BASE_URL}album.json")
            .build()

        var a: MutableList<Track> = mutableListOf()
        thread {
            client.newCall(request)
                .execute()
                .use { response ->
                    if (!response.isSuccessful)
                        println("shit...")
                    for ((name, value) in response.headers) {
                        println("$name: $value")
                    }
                    println(response.body!!.string())
                    a.add(0, Track("asd", "qwe.mp3"))
                }
        }

        return flowOf(emptyList())


//        var a: List<Track> = client.newCall(request)
//            .execute().use { it.body?.string() }
//            .let { gson.fromJson(it, typeToken.type) }
//        return a

//        return client.newCall(request)
//            .execute().use { it.body?.string() }
//            .let { gson.fromJson(it, typeToken.type) }
    }


//    fun getTracks(): List<Track> {
//        // check on postman
//        val request: Request = Request.Builder()
//            .url("${BASE_URL}album.json")
//            .build()
//
//
//        client.newCall(request)
//            .execute()
//            .use { response ->
//                if (!response.isSuccessful)
//                    println("shit...")
//                for ((name, value) in response.headers) {
//                    println("$name: $value")
//                }
//                println(response.body!!.string())
//            }
//
//        return emptyList()
//
//    }

    suspend fun getResp(req: Request ){

    }

}