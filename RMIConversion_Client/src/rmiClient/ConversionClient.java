package rmiClient;
import rmiService.IConversion;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Obtenir le registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Rechercher l'objet distant dans le registre sous le nom spécifié
            IConversion conversionService = (IConversion) registry.lookup("ConversionService");

            // Utiliser l'objet distant
            double montantDinar = 100.0;
            double montantEuros = conversionService.convertirMontant(montantDinar);

            System.out.println("Montant en Dinar : " + montantDinar);
            System.out.println("Montant converti en Euros : " + montantEuros);
        } catch (Exception e) {
            System.err.println("Erreur côté client : " + e.toString());
            e.printStackTrace();
        }
    }
}

