package org.example;

import java.io.IOException;

/**
 * 요청       : GET
 * Path      : /calculate
 * Parameter : [피연산자1]&[연산자]&[피연산자2]
 * <p>
 * GET /calculate?operand1=11&operator=*&operand2=55
 */

public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}