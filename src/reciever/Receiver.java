package reciever;

import java.io.*;
import java.net.*;
import java.util.*;

public class Receiver {

    private DatagramSocket mySock;
    // private int portNumber;
    // private String quote;

    public Receiver (int port) throws SocketException{
        mySock = new DatagramSocket(port);
    }
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        try {
            Receiver receiver = new Receiver(port);
            receiver.start();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException{
        while (true) {
            DatagramPacket data = new DatagramPacket(new byte[1], 1);
            mySock.receive(data);
            String text = "Test";
            byte[] buffy = text.getBytes();

            InetAddress senderAddress = data.getAddress();
            int senderPort = data.getPort();

            DatagramPacket dataResponse = new DatagramPacket(buffy, buffy.length, senderAddress, senderPort);
            mySock.send(dataResponse);
        }
    }
//    public Receiver (String quote, int portNumber) {
//        this.quote = quote;
//        this.portNumber = portNumber;
//    }
}
