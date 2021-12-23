package mirea;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Chat {
    public static void main(String[] args) throws Exception {
        try (var socket = new Socket("localhost", 8080)) {

            var login = new Scanner(System.in);
            System.out.println("Login: ");
            String log = login.nextLine();
            System.out.println(log + " on server");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(log + ": " + in.nextLine());
            }
        }
    }
}