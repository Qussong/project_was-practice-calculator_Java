package org.example;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * HTTP 요청 메세지의 구조 :
 *       Request line
 *       Header
 *       Blank line
 *       Body
 */

public class HttpRequest {
    private final RequestLine requestLine;
    //private final HttpHeaders httpheaders;
    //private final Body body;

    /**
     *
     * GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1   <- request line
     * User-Agent: IntelliJ HTTP Client/IntelliJ IDEA 2024.3.1.1
     * Accept-Encoding: br, deflate, gzip, x-gzip
     * Accept: `*`/
     * host:localhost:8080
     *
     */
    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());  // protocol 의 첫번째 라인이 request line 이다.
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQuerySrings();
    }
}
