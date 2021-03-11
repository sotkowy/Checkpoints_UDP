package appDriver;

import reciever.Receiver;

import java.net.SocketException;

public class ReceiverAppDriver { // Serve the Reciever.
    public static void main(String[] args) throws Exception {
        if(args.length < 2 && args.length > 3) {
            throw new Exception("Invalid arguments");
        }
        try {
            switch (args[0]) {
                case "-f":
                    new Receiver(args[1], Integer.parseInt(args[2]));
                    break;
                default:
                    throw new Exception("Please -f flag to send quote");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(" port number need's to be number ");
        }
    }
}
