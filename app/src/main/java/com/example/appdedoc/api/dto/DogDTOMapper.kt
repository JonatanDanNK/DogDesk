package com.example.appdedoc.api.dto

import com.example.appdedoc.api.response.Dog

class DogDTOMapper {

    fun fromDogDTOToDogDomain(dogDTO: DogDTO): Dog {
        return Dog(
            dogDTO.createdAt,
            dogDTO.type,
            dogDTO.heightFemale,
            dogDTO.heightMale,
            dogDTO.id,
            dogDTO.imageUrl,
            dogDTO.index,
            dogDTO.lifeExpectancy,
            dogDTO.mlId,
            dogDTO.nameEn,
            dogDTO.nameEs,
            dogDTO.temperament,
            dogDTO.temperamentEn,
            dogDTO.updatedAt,
            dogDTO.weightFemale,
            dogDTO.weightMale)
    }
    fun fromDogDTOListToDomainList(dogDTOList: List<DogDTO>): List<Dog>{
        return dogDTOList.map { fromDogDTOToDogDomain(it) }
    }
}