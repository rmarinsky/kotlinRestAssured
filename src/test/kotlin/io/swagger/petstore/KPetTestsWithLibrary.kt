package io.swagger.petstore

import io.swagger.petstore.entities.KPet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class KPetTestsWithLibrary{

    @Test
    fun addNewPetTest(){
        val petRequest = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        val petResponse = KPetActions().addNewPet(petRequest)
        Assert.assertEquals(petRequest, petResponse)
    }

}