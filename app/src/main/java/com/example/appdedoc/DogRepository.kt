package com.example.appdedoc

import com.example.appdedoc.api.ApiResponseStatus
import com.example.appdedoc.api.DogApi.retrofitGetDogList
import com.example.appdedoc.api.dto.DogDTOMapper
import com.example.appdedoc.api.makeNetworkCall
import com.example.appdedoc.api.response.Dog
import com.example.appdedoc.api.retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {

    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>>{
        /** solo enviamos el metodo de la lista de perro ya que la excepcion ya la estamos manejando en un metodo
         * mas genera con la fucion de makeNetworkCall solo enviamos la landa que necsita ete metodo, en funcion
         * de metodo que queremos**/
        /*
        return withContext(Dispatchers.IO){
            try {
                val doglistApiResponse = retrofitGetDogList.getListDogs()
                val dogDTOlist = doglistApiResponse.data.dogs
                val dogDTOMapper = DogDTOMapper()
                ApiResponseStatus.SUCCESS( dogDTOMapper.fromDogDTOListToDomainList(dogDTOlist))
            }catch (e: Exception){
                ApiResponseStatus.ERROR(R.string.generig_error)
            }catch (e: UnknownHostException){
                ApiResponseStatus.ERROR(R.string.falled_dowload_dog_list)
            }
        } */
        /**ew funcion que rempla a la anterior enviamos la landa a la funcion generica */
        return  makeNetworkCall {
            val doglistApiResponse = retrofitGetDogList.getListDogs()
            val dogDTOlist = doglistApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDomainList(dogDTOlist)
        }
    }

/*
    private fun getFakeDogs(): MutableList<Dogs> {
        val dogList = mutableListOf<Dogs>()
        dogList.add(
            Dogs(
                1, 1, "Chihuahua", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dogs(
                2, 1, "Labrador", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dogs(
                3, 1, "Retriever", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dogs(
                4, 1, "San Bernardo", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dogs(
                5, 1, "Husky", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        dogList.add(
            Dogs(
                6, 1, "Xoloscuincle", "Toy", 5.4,
                6.7, "", "12 - 15", "", 10.5,
                12.3
            )
        )
        return dogList
    }
    */
}