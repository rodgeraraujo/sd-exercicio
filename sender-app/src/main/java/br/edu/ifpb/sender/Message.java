package br.edu.ifpb.sender;

import java.rmi.Remote;

public interface Message extends Remote {

    String getMessage();

}
