package rmiClient;
import rmiService.IConversion;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {
    public static void main(String[] args){

        try {
            // Adresse et port du registre RMI
            String serverAddress = "localhost";
            int serverPort = 1099;
            // Le montant a convertir
            double montantDinar = 250.00;

            // Obtenir une référence au registre RMI d'objets distant
            Registry registre = LocateRegistry.getRegistry(serverAddress, serverPort);

            // Récupération du service RMI à partir du registre
            IConversion conversionService = (IConversion) registre.lookup("ConversionService");

            // Utilisation du service RMI
            double montantEuros = conversionService.convertirMontant(montantDinar);

            // Affichage avant conversion
            System.out.println("Montant en Dinars : " + montantDinar);
            // Affichage aprés conversion
            System.out.println("Montant converti en Euros : " + montantEuros);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

