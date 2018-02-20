package io.swagger.petstore

import io.swagger.petstore.controllers.KPetController
import io.swagger.petstore.models.KPet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class PetTestsInObjectStyle {

    @Test
    fun `Add new pet to store test`() {
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10).toLong(),
                name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                status = "available")

        val petResponse = KPetController().addNewPet(testPet)

        Assert.assertEquals(testPet, petResponse)
    }

    @Test
    fun `Delete pet from store test`() {
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10).toLong(),
                name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                status = "available")

        KPetController().apply {
            //with instance of KPetController class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            Assert.assertTrue(getPet(testPet).message.equals("Pet not found"))
        }
    }

}