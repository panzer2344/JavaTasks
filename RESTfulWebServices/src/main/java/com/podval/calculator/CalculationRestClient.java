package com.podval.calculator;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Scanner;

public class CalculationRestClient {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc");

        Scanner scanner = new Scanner(System.in);
        int answer = -1;
        while(answer != 0) {

            System.out.println("0. Exit");
            System.out.println("1. Sum");
            System.out.println("2. Sub");
            System.out.println("3. Mul");
            System.out.println("4. Div");
            System.out.print("what do u want to do: ");
            answer = scanner.nextInt();

            if(answer != 0) {
                System.out.println("Input a:");
                Integer a = scanner.nextInt();

                System.out.println("Input b:");
                Integer b = scanner.nextInt();

                WebTarget currentWebTarget = null;
                switch (answer){
                    case 1:
                        currentWebTarget = webTarget.path("add/" + a + "/" + b);
                        break;
                    case 2:
                        currentWebTarget = webTarget.path("sub/" + a + "/" + b);
                        break;
                    case 3:
                        currentWebTarget = webTarget.path("mul/" + a + "/" + b);
                        break;
                    case 4:
                        currentWebTarget = webTarget.path("div/" + a + "/" + b);
                        break;
                }

                if(currentWebTarget != null) {
                    String response = currentWebTarget.request().get(String.class);
                    System.out.println("" + a + " + " + b + " = " +  response);
                } else {
                    System.out.println("Choose right option!");
                }
            }
        }
    }
}
