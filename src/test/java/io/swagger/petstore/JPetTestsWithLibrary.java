package io.swagger.petstore;

import io.swagger.petstore.entities.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class JPetTestsWithLibrary {

    @Test
    public void addNewPet() {
        JPet petRequest = new JPet(null, RandomStringUtils.randomAlphabetic(8), "Pet_" + RandomStringUtils.randomNumeric(8), null, null, "available");

        JPet petResponse = new JPetActions().addNewPet(petRequest);
        Assert.assertEquals(petRequest, petResponse);
    }

}
