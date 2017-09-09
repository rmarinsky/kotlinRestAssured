package io.swagger.petstore;

import io.swagger.petstore.jEntities.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class JPetTestsInObjectStyle {

    @Test
    public void addNewPetToStoreTest() {
        JPet testPet = new JPet(null, "Pet_" + RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomNumeric(8), null, null, "available");

        JPet petResponse = new JPetActions().addNewPet(testPet);
        Assert.assertEquals(testPet, petResponse);
    }

    @Test
    public void deletePetFromStoreTest() {
        JPet testPet = new JPet(null, "Pet_" + RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomNumeric(8), null, null, "available");
        JPetActions petAction = new JPetActions();

        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);

        Assert.assertTrue(petAction.getAbsentPet(testPet).getMessage().equals("Pet not found"));
    }

}
