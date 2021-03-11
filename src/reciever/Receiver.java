package reciever;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;

public class Receiver {
    private String filename;
    private int portNumber;
    private DatagramSocket datSock;
    private DatagramPacket datPac;

    public Receiver(String fileName, int portNumber)  {
        this.filename = fileName;
        this.portNumber = portNumber;
        runReceiver();
    }
    public void runReceiver()  {
        try {
            initializeDatagramSocket();
            byte[] bytArr = new byte[1024];
            initializeDatagramPacket(bytArr);
            datSock.receive(datPac);
            String str = new String(datPac.getData(),0, datPac.getLength());
            System.out.println(str);
            fileMaker(str);

        }catch(SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initializeDatagramSocket() throws SocketException {
        datSock = new DatagramSocket(portNumber);
    }
    private void initializeDatagramPacket(byte[] arr) {
        datPac = new DatagramPacket(arr, arr.length);
    }
    private void fileMaker(String content) {
        try(FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    private DatagramSocket mySock;
//    // private int portNumber;
//    // private String quote;
//
//    public Receiver (int port) throws SocketException{
//        mySock = new DatagramSocket(port);
//    }
//    public static void main(String[] args) {
//        int port = Integer.parseInt(args[0]);
//
//        try {
//            Receiver receiver = new Receiver(port);
//            receiver.start();
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void start() throws IOException{
//        while (true) {
//            DatagramPacket data = new DatagramPacket(new byte[1], 1);
//            mySock.receive(data);
//            String text = "Test";
//            byte[] buffy = text.getBytes();
//
//            InetAddress senderAddress = data.getAddress();
//            int senderPort = data.getPort();
//
//            DatagramPacket dataResponse = new DatagramPacket(buffy, buffy.length, senderAddress, senderPort);
//            mySock.send(dataResponse);
//        }
//    }
////    public Receiver (String quote, int portNumber) {
////        this.quote = quote;
////        this.portNumber = portNumber;
////    }
}
