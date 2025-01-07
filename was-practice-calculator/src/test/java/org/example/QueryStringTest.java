package org.example;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;

public class QueryStringTest {


    // operand1=11
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1", "11");

        // null check, value-key check case 1
        assertThat(queryString).isNotNull();
        assertThat(queryString.exists("operand1")).as("key is not exist").isTrue();
        assertThat(queryString.getValue()).as("Value is not same").isEqualTo("11");

        // null check, value-key check case 2
        assertThat(queryString).isNotNull().satisfies(v -> {
            assertThat(queryString.exists("operand1")).isTrue();
            assertThat(queryString.getValue()).isEqualTo("11");
        });
    }

    // List<QueryString> -> 일급 컬렉션
    // operand1=11&operator=*&operand2=55
    @Test
    void createTest2() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");

        assertThat(queryStrings).isNotNull();
    }

}
