package io.swagger.petstore

import io.swagger.petstore.entities.KPet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class KPetTestsWithLibrary{

    @Test
    fun addNewPetTest(){
        val randomPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        val petResponse = KPetActions().addNewPet(randomPet)

        Assert.assertEquals(randomPet, petResponse)
    }

    @Test fun deletePet(){
        val randomPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")
        val petAction = KPetActions()

        petAction.addNewPet(randomPet)
        petAction.deletePet(randomPet)

        Assert.assertTrue(KPetActions().petIsAbsent(randomPet))
    }

}