package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {


    // operand1=11
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1", "11");

        assertThat(queryString).isNotNull();
    }

    // List<QueryString> -> 일급 컬렉션
    // operand1=11&operator=*&operand2=55
    @Test
    void createTest2() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");

        assertThat(queryStrings).isNotNull();
    }

}
