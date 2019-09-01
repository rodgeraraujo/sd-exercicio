package br.edu.ifpb.sender;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageImpl extends UnicastRemoteObject implements Message {

    private AtomicInteger atomic = new AtomicInteger(0);


    protected MessageImpl() throws RemoteException {
        super();
    }

    @Override
    public synchronized String getMessage() {
        return "Opa, mensagem " + atomic.incrementAndGet();
    }
}
