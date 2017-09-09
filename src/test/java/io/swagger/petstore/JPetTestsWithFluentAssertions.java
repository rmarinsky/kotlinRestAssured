package io.swagger.petstore;

import io.swagger.petstore.asserts.JMessageResponseAssert;
import io.swagger.petstore.asserts.JPetAssert;
import io.swagger.petstore.jEntities.JMessageResponse;
import io.swagger.petstore.jEntities.JPet;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class JPetTestsWithFluentAssertions {

    @Test
    public void addNewPetToStoreTest() {
        JPet testPet = new JPet(null, "Pet_" + RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomNumeric(8), null, null, "available");

        JPet petResponse = new JPetActions().addNewPet(testPet);

        JPetAssert.assertThat(petResponse).isEqualTo(testPet);
    }

    @Test
    public void deletePetFromStoreTest() {
        JPet testPet = new JPet(null, "Pet_" + RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomNumeric(8), null, null, "available");
        JPetActions petAction = new JPetActions();

        petAction.addNewPet(testPet);
        petAction.deletePet(testPet);

        JMessageResponse messageResponse = petAction.getAbsentPet(testPet);

        JMessageResponseAssert.assertThat(messageResponse).hasMessage("Pet not found");
    }

}
