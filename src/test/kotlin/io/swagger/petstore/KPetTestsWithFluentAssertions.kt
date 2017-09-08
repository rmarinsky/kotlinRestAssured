package io.swagger.petstore

import io.swagger.petstore.entities.KPet
import org.amshove.kluent.shouldEqual
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Test

class KPetTestsWithFluentAssertions {

    @Test fun `Add new pet to store`(){
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        val petResponse = KPetActions().addNewPet(testPet)

        testPet shouldEqual petResponse
    }

    @Test fun `Delete pet from store test`(){
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        with(KPetActions()) { //with instance of KPetActions class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            getAbsentPet(testPet).message shouldEqual "Pet not found"
        }
    }

}
