package org.example;


import java.util.Objects;

public class RequestLine {

    private final String method;    // GET

    private final String urlPath;   // /calculate

    private QueryStrings queryStrings;     // operand1=11&operator=*&operand2=55

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    // "GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1"
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    @Override
    public boolean equals(Object o) {
        //if (!(o instanceof RequestLine that)) return false;
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public boolean isGetRequest() {
        return method.equals("GET");
    }

    public boolean matchPath(String path) {
        return urlPath.equals(path);
    }

    public QueryStrings getQuerySrings() {
        return queryStrings;
    }
}
