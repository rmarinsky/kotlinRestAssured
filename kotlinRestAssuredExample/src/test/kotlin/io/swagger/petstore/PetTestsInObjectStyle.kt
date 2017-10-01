package io.swagger.petstore

import io.swagger.petstore.kEntities.KPet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class PetTestsInObjectStyle {

    @Test fun `Add new pet to store test`() {
        val testPet = KPet( id = RandomStringUtils.randomNumeric(10),
                            name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                            status = "available")

        val petResponse = KPetActions().addNewPet(testPet)

        Assert.assertEquals(testPet, petResponse)
    }

    @Test fun `Delete pet from store test`() {
        val testPet = KPet( id = RandomStringUtils.randomNumeric(10),
                            name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                            status = "available")

        KPetActions().apply {
            //with instance of KPetActions class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            Assert.assertTrue(getPet(testPet).message.equals("Pet not found"))
        }
    }

}