package io.swagger.petstore

import io.swagger.petstore.entities.KPet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class KPetTestsWithLibrary{

    @Test
    fun addNewPetTest(){
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        val petResponse = KPetActions().addNewPet(testPet)

        Assert.assertEquals(testPet, petResponse)
    }

    @Test fun deletePet(){
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")
        val petAction = KPetActions()

        petAction.addNewPet(testPet)
        petAction.deletePet(testPet)

        Assert.assertTrue(KPetActions().petIsAbsent(testPet))
    }

}