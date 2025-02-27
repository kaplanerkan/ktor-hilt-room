package com.android.roomtest.dataservice

import android.content.Context
import android.util.Log
import com.android.roomtest.data.ApiResponse
import com.android.roomtest.data.room.model.Person
import com.android.roomtest.data.room.repository.PersonRepository
import com.google.gson.Gson

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking
import java.util.Date
import javax.inject.Inject

class KtorApplication @Inject constructor(
    private val personRepository: PersonRepository
) {
     fun startServer(context: Context) {
        embeddedServer(Netty, port = 8888) {

            install(ContentNegotiation) {
                json(/*Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }*/
                )
            }

            install(CORS) {
                anyHost()
                allowHeader(HttpHeaders.ContentType)
            }
            routing {
                get("test1/{name}/{lastname}/{phone}/{desc}") {
                    val name = call.parameters["name"]?:"name"
                    val lastName = call.parameters["lastName"]?:"lastName"
                    val phone = call.parameters["phone"]?:"01775555844"
                    val desc = call.parameters["lastName"]?:""
                    Person(
                        id = 0,
                        first_name = name,
                        last_name = lastName,
                        last_update = Date().time,
                        phone = phone,
                        description = desc
                    )
                    runBlocking {
                        personRepository.insertPerson(
                            Person(
                                id = 0,
                                first_name = name,
                                last_name = lastName,
                                last_update = Date().time,
                                phone = phone,
                                description = desc
                            )
                        ).catch {
                            call.respond(HttpStatusCode.InternalServerError, "Internal Server Error")

                        }.collect{
                            when (it) {
                                is ApiResponse.Success -> {
                                    call.respond(HttpStatusCode.OK, Gson().toJson(it.data))
                                }
                                is ApiResponse.Failure -> {
                                    call.respond(HttpStatusCode.InternalServerError, "Internal Server Error")
                                }
                                is ApiResponse.Progress -> {
                                }
                            }
                        }
                    }

                }

                get("test2") {


                    runBlocking {
                        personRepository.getAllPersons().catch {
                            call.respond(HttpStatusCode.InternalServerError, "Internal Server Error")
                        }.collect{
                            when (it) {
                                is ApiResponse.Success -> {
                                    call.respond(HttpStatusCode.OK, Gson().toJson(it.data))
                                }
                                is ApiResponse.Failure -> {
                                    call.respond(HttpStatusCode.InternalServerError, "Internal Server Error")
                                }
                                is ApiResponse.Progress -> {
                                }
                            }
                        }
                    }

                }
            }
        }.start()
    }
}