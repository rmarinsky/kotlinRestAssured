package io.swagger.petstore

import io.swagger.petstore.kEntities.KPet
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Assert
import org.junit.Test

class KPetTestsInObjectStyle {

    @Test fun `Add new pet to store test`(){
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        val petResponse = KPetActions().addNewPet(testPet)

        Assert.assertEquals(testPet, petResponse)
    }

    @Test fun `Delete pet from store test`(){
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10), name = "Pet_${RandomStringUtils.randomAlphabetic(8)}", status = "available")

        with(KPetActions()) { //with instance of KPetActions class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            Assert.assertTrue(getAbsentPet(testPet).message.equals("Pet not found"))
        }
    }

}