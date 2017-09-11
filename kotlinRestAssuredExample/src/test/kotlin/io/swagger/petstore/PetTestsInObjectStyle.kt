package io.swagger.petstore

import io.swagger.petstore.kEntities.Pet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class PetTestsInObjectStyle {

    @Test fun `Add new pet to store test`() {
        val testPet = Pet( id = RandomStringUtils.randomNumeric(10),
                            name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                            status = "available")

        val petResponse = PetActions().addNewPet(testPet)

        Assert.assertEquals(testPet, petResponse)
    }

    @Test fun `Delete pet from store test`() {
        val testPet = Pet( id = RandomStringUtils.randomNumeric(10),
                            name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                            status = "available")

        with(PetActions()) {
            //with instance of KPetActions class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            Assert.assertTrue(getAbsentPet(testPet).message.equals("Pet not found"))
        }
    }

}