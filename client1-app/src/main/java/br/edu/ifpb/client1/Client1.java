package br.edu.ifpb.client1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class Client1 {

    public static void main(String[] args) throws RemoteException, NotBoundException, SQLException, ClassNotFoundException {

        Client1Service service = new Client1Service();

        int count = 0;

        Registry registry = LocateRegistry.getRegistry(3333);

        while (count == 50) {
            count++;

            Message message = (Message) registry.lookup("message");
            String msg = message.getMessage();

            service.save(msg);

            
        }

    }

}
