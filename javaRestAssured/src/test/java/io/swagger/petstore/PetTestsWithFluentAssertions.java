package io.swagger.petstore;

import io.swagger.petstore.asserts.JMessageResponseAssert;
import io.swagger.petstore.asserts.JPetAssert;
import io.swagger.petstore.controllers.JPetController;
import io.swagger.petstore.models.JMessageResponse;
import io.swagger.petstore.models.JPet;
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

        JPet petResponse = new JPetController().addNewPet(testPet);

        JPetAssert.assertThat(petResponse).isEqualTo(testPet);
    }

    @Test
    public void deletePetFromStoreTest() {
        JPet testPet = new JPet(null,
                "Pet_" + RandomStringUtils.randomAlphabetic(8), //Pet name
                RandomStringUtils.randomNumeric(8), null, null, //Pet ID
                "available"); //Pet status

        JPetController petAction = new JPetController();

        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);

        JMessageResponse messageResponse = petAction.getPet(testPet);

        JMessageResponseAssert.assertThat(messageResponse).hasMessage("Pet not found");
    }

}
