package br.edu.ifpb.sender;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Sender {

    public static void main(String[] args) throws RemoteException {

        System.out.println("Executando sender...");

        Message message = new MessageImpl();

        Registry registry = LocateRegistry.createRegistry(3333);

        registry.rebind("message", message);

    }

}
