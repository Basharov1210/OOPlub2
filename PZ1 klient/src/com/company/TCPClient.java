package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        try (
                Socket clientSocket = new Socket("localhost", 60001);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        ) {
            System.out.println("Введите числа через запятю для отправки серверу");
            String message = br.readLine();
            String type = new String();
            type = message.split(" ")[0];
            ArrayList<String> x = new ArrayList<String>();
            int len = message.split(" ").length;

            String buf[] = new String[len];
            buf = message.split(" ");

     /*       for (int i = 0; i < buf.length; i ++)
            {
                System.out.println(buf[i]);
            }
*/
            for (int i = 1; i < len; i++)
            {
                x.add(buf[i].replace(",", "").replace(" ", ""));
            }

            Object Obj = new Object(x, message, type);
            out.writeObject(Obj);

            try {
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                String  obj = (String)in.readUTF();
                System.out.println(obj);

            } catch (EOFException eof) {

            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}