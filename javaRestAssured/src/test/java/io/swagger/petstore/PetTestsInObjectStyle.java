package io.swagger.petstore;

import io.swagger.petstore.controllers.JPetController;
import io.swagger.petstore.models.JMessage;
import io.swagger.petstore.models.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class PetTestsInObjectStyle {

    @Test
    public void addNewPetToStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), //Pet ID
                null, null,
                "available"); //Pet status

        JPet petResponse = new JPetController().addNewPet(testPet);
        Assert.assertEquals(testPet, petResponse);
    }

    @Test
    public void deletePetFromStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), //Pet ID
                null, null,
                "available"); //Pet status

        JPetController petAction = new JPetController();
        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);

        JMessage messageResponse = petAction.getPet(testPet);

        Assert.assertTrue(messageResponse.getMessage().equals("Pet not found"));
    }

}
