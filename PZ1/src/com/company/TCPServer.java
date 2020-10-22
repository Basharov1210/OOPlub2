package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer implements Runnable{
    private static ServerSocket server;
    public static final int SERVER_PORT = 60001;

    public static void main(String[] args)
    {
        try
        {
            server = new ServerSocket(SERVER_PORT);
            new Thread(new TCPServer()).start();
            new Thread(new TCPServer()).start();
            new Thread(new TCPServer()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Object Obj;

        String message = null;
        while (!"STOP".equals(message)) {
            System.out.println("Ожидание соединения");
            try {
                Socket connectionSocket = server.accept();
                ObjectInputStream incoming = new
                        ObjectInputStream(connectionSocket.getInputStream());
                ObjectOutputStream outgoing = new
                        ObjectOutputStream(connectionSocket.getOutputStream());

                System.out.println("Ожидание сообщения клиента");
                Obj = (Object) incoming.readObject();
                message = Obj.getMess();
                System.out.println("Получено от клиента сообщение " + message);

                String s = new String("STOP");
                String str = new String("");

                if (!message.equals(s)) {
                    FourthVar fourthVar = null;
                    switch (Obj.getType()) {
                        case "String": {
                            fourthVar = new FourthVar(Obj.getSt());
                            break;
                        }
                        case "Array": {
                            fourthVar = new FourthVar(Obj.getArray());
                            break;
                        }
                        case "List": {
                            fourthVar = new FourthVar(Obj.getSl());
                            break;
                        }

                        default:
                            break;

                    }

                    ArrayList<Integer> chetnost = new ArrayList<Integer>();

                    chetnost = fourthVar.getResultat();
                    str = "Сообщение сервером получено";
                    str = str + " Кол-во четных= " + chetnost.get(0) + " Кол-во нечетные = " + chetnost.get(1);
                } else {
                    str = "Соединение с сервером закрыто";
                }

                outgoing.writeUTF(str);

                outgoing.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}

