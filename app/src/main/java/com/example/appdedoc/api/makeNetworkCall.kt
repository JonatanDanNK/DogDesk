package com.example.appdedoc.api

import com.example.appdedoc.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
/** Creamos un metodo general para solo enviarle por parametros la land de lo que queremos que se ejecute
 * para no tener que modificar todoo el codigo o hacer las largo y eneficas de lo necesario
 * Igual se utiliza para controlar nuevas excepciones**/

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): /*ApiResponseStatus<T>{
    return withContext(Dispatchers.IO){
        try{
            ApiResponseStatus.SUCCESS(call())
        }catch (e: UnknownHostException){
            ApiResponseStatus.ERROR(R.string.falled_dowload_dog_list)
        }catch (e: Exception){
            ApiResponseStatus.ERROR(R.string.generig_error)
        }
    }
}*/ApiResponseStatus<T> = withContext(Dispatchers.IO){
    try{
        ApiResponseStatus.SUCCESS(call())
    }catch (e: UnknownHostException){
        ApiResponseStatus.ERROR(R.string.falled_dowload_dog_list)
    }catch (e: Exception){
        ApiResponseStatus.ERROR(R.string.generig_error)
    }
}