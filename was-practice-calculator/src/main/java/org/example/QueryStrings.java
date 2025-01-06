package org.example;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;

public class QueryStrings {

    private List<QueryString> queryStrings = new ArrayList<>(); // 0 : operand1, 1 : operator, 2 : operand2

    // operand1=11&operator=*&operand2=55 -> operand1=11  operator=*  operand2=55
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");

        //Arrays.stream(queryStringTokens)
        Stream.of(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if (values.length != 2) {
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열 입니다.");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
