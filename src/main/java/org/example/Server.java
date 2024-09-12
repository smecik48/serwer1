package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(5000);

        while(true){
            socket = serverSocket.accept();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedReader = new BufferedReader(inputStreamReader);
            String login = null;
            login = bufferedReader.readLine();

            while(true){
                String msgFromClient = bufferedReader.readLine();
                System.out.println(login + ": " + msgFromClient);
                bufferedWriter.write("MSG Received!");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if(msgFromClient.equalsIgnoreCase("BYE")){
                    break;
                }
            }
        }

    }
}