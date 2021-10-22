import java.util.List;

import LexicalAnalyzer.LexicalAnalyzer;
import views.Menu;

public class Application {
    public static void start() {

        boolean exit = false;

        do {
            // Affichage du menu
            Menu.showMenu();
            int indice = 0;
            try {
                indice = Integer.parseInt(Utilitaire.Utils.getInput("\n\tVeuillez choisir une option : "));
            } catch (Exception e) {
                System.out.println("Erreur saisi...");
            }

            switch (indice) {
            case 0: {
                exit = true;
                break;
            }
            default: {
                String path = "main/src/TestsFiles/testFile" + indice;
                List<String> file = Utilitaire.Utils.readFile(path);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Début du traitement d'analyse lexicale
                LexicalAnalyzer analyzer = new LexicalAnalyzer(file);
                analyzer.analyse();
            }
            }
            Utilitaire.Utils.closeScanner();
        } while (!exit);

    }
}