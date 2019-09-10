package org.abelsromero.quarkus.utils;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class ErrorAssertions {

    public static void assertErrorMessage(Map<String, Object> responseBody, String message) {
        assertThat(responseBody).containsOnlyKeys(
            "propertyViolations",
            "classViolations",
            "parameterViolations",
            "returnValueViolations");
        final List<Map<String, String>> parameterViolations = (List<Map<String, String>>) responseBody.get("parameterViolations");
        assertThat(parameterViolations).hasSize(1);
        assertThat((parameterViolations).get(0).get("message")).isEqualTo(message);
    }
}
