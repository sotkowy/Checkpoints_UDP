package appDriver;

import reciever.Receiver;

import java.net.SocketException;

public class ReceiverAppDriver { // Serve the Reciever.
    public static void main(String[] args) throws Exception {
        if(args.length < 1 && args.length > 3) {
            throw new Exception("Invalid arguments");
        }
        try {
            switch (args[0]) {
                case "-f":
                    new Receiver(args[1], Integer.parseInt(args[2]));
                    break;
                default:
                    new Receiver(Integer.parseInt(args[0]));
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(" port number need's to be number ");
        }
    }
}
