package org.abelsromero.quarkus;

import com.github.database.rider.cdi.api.DBUnitInterceptor;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.abelsromero.quarkus.model.Conference;
import org.abelsromero.quarkus.repository.ConferenceRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;

@QuarkusTest
@DBUnitInterceptor
public class ConferencesResourceTest {

    @Inject
    ConferenceRepository repository;

    @Test
    @DataSet(value = "conferences.yml")
    public void should_fail_creating_a_conference_with_an_existing_name() {
        final Conference conf = new Conference();
        conf.setName("Test Conf");

        given()
            .when()
            .contentType(ContentType.JSON)
            .body(conf)
            .post("/conferences")
            //
            .then()
            .statusCode(418)
            .body("message", not(isEmptyOrNullString()))
        ;
    }

}
