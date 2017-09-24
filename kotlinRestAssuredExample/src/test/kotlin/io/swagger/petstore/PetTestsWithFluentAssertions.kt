package io.swagger.petstore

import io.swagger.petstore.kEntities.Pet
import org.amshove.kluent.shouldEqual
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Test

class PetTestsWithFluentAssertions {

    @Test fun `Add new pet to store`() {
        val testPet = Pet( id = RandomStringUtils.randomNumeric(10),
                            name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                            status = "available")

        val petResponse = PetActions().addNewPet(testPet)

        petResponse shouldEqual testPet
    }

    @Test fun `Delete pet from store test`() {
        val testPet = Pet( id = RandomStringUtils.randomNumeric(10),
                            name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                            status = "available")

        PetActions().apply {
            //with instance of KPetActions class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            getAbsentPet(testPet).message shouldEqual "Pet not found"
        }
    }

}
