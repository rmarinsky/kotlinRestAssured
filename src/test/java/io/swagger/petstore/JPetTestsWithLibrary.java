package io.swagger.petstore;

import io.swagger.petstore.entities.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class JPetTestsWithLibrary {

    @Test
    public void addNewPet() {
        JPet testPet = new JPet(null, "Pet_" + RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomNumeric(8), null, null, "available");

        JPet petResponse = new JPetActions().addNewPet(testPet);
        Assert.assertEquals(testPet, petResponse);
    }

    @Test
    public void deletePetById(){
        JPet testPet = new JPet(null, "Pet_" + RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomNumeric(8), null, null, "available");
        JPetActions petAction = new JPetActions();

        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);
        Assert.assertTrue(petAction.petIsAbsent(testPet));
    }

}
