package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversionImpl extends UnicastRemoteObject implements IConversion {
    public ConversionImpl() throws RemoteException {
        // Constructeur par défaut
    }
    public double convertirMontant(double mt) throws RemoteException{
        return mt*3.38;
    }
}


