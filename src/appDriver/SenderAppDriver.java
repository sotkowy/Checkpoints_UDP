package appDriver;

import sender.Sender;

public class SenderAppDriver { // The Sender. Client.
    public static void main(String[] args) throws Exception {
        if(args.length < 1 && args.length > 5) {
            throw new Exception("Invalid arguments");
        }
        if(args[0].equalsIgnoreCase("-f")) {
            new Sender(args[1], args[2], Integer.parseInt(args[3]));
        }else {
            new Sender(args[0], args[1], Integer.parseInt(args[2]));
        }

    }
}
