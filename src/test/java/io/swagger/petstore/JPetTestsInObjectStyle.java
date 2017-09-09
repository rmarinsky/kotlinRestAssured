package io.swagger.petstore;

import io.swagger.petstore.jEntities.JMessageResponse;
import io.swagger.petstore.jEntities.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class JPetTestsInObjectStyle {

    @Test
    public void addNewPetToStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), //Pet ID
                null, null,
                "available"); //Pet status

        JPet petResponse = new JPetActions().addNewPet(testPet);
        Assert.assertEquals(testPet, petResponse);
    }

    @Test
    public void deletePetFromStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), //Pet ID
                null, null,
                "available"); //Pet status

        JPetActions petAction = new JPetActions();

        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);

        JMessageResponse messageResponse = petAction.getAbsentPet(testPet);

        Assert.assertTrue(messageResponse.getMessage().equals("Pet not found"));
    }

}
