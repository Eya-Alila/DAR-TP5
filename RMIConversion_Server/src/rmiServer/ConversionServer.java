package rmiServer;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmiService.IConversion;
import rmiService.ConversionImpl;

public class ConversionServer {
    public static void main(String []args){
                try {
                    // Créer une instance de l'implémentation du serveur
                    ConversionImpl conversionImpl = new ConversionImpl();

                    // Exporter l'objet distant sur un port spécifique (par exemple, 1099)
                    IConversion stub = (IConversion) UnicastRemoteObject.exportObject((Remote)conversionImpl, 0);

                    // Obtenir le registre RMI (ou en créer un s'il n'existe pas)
                    Registry registry = LocateRegistry.createRegistry(1099);

                    // Enregistrer l'objet distant dans le registre sous un nom spécifique
                    registry.rebind("ConversionService", (Registry) conversionImpl);

                    System.out.println("Serveur RMI prêt.");
                } catch (Exception e) {
                    System.err.println("Erreur côté serveur : " + e.toString());
                    e.printStackTrace();
                }
    }
}
