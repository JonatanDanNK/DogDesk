package com.example.appdedoc.api

import com.example.appdedoc.api.response.Dog
import com.example.appdedoc.api.response.DogList

/** Claese para controlar errores al descargar la informacion de API de los DOGS
 * Remplazamos el enum por una seled class**/
sealed class ApiResponseStatus<T>() {
    /* los valores deben deben de ser clases que ereran de la clase padre o la sealed class
    * y estas clases deben de ir con sus argumento*/
    class SUCCESS<T>(val data: T): ApiResponseStatus<T>()
    class LOADING<T>: ApiResponseStatus<T>()
    class ERROR<T>(val messageId: Int): ApiResponseStatus<T>()
}