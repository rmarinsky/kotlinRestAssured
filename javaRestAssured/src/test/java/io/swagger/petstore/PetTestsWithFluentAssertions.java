package io.swagger.petstore;

import io.swagger.petstore.asserts.MessageResponseAssert;
import io.swagger.petstore.asserts.PetAssert;
import io.swagger.petstore.jEntities.JMessageResponse;
import io.swagger.petstore.jEntities.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class PetTestsWithFluentAssertions {

    @Test
    public void addNewPetToStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), //Pet ID
                null, null,
                "available"); //Pet status

        JPet petResponse = new PetActions().addNewPet(testPet);

        PetAssert.assertThat(petResponse).isEqualTo(testPet);
    }

    @Test
    public void deletePetFromStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), null, null, //Pet ID
                "available"); //Pet status

        PetActions petAction = new PetActions();

        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);

        JMessageResponse messageResponse = petAction.getAbsentPet(testPet);

        MessageResponseAssert.assertThat(messageResponse).hasMessage("Pet not found");
    }

}