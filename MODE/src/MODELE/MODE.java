import MODELE.Article;
import MODELE.CodePromo;
import Service.Catalogue;
import Service.Panier;

import java.util.Scanner;

public class MODE{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalogue catalogue = new Catalogue();
        Panier panier = new Panier();

   
        catalogue.ajouterArticle(new Article("KIT_BOL1", "Bol végétarien", 5990, 12));
        catalogue.ajouterArticle(new Article("TOMATE3", "Tomates x3", 990, 40));

   
        CodePromo[] codes = {
            new CodePromo("KENDI10", 10),
            new CodePromo("KENDI20", 20)
        };

        System.out.println("=== Bienvenue chez KendiFood ===");

        boolean continuer = true;
        while (continuer) {
            System.out.println("\n1. Afficher catalogue");
            System.out.println("2. Ajouter au panier");
            System.out.println("3. Voir panier");
            System.out.println("4. Appliquer code promo");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            String choix = sc.nextLine();

            switch (choix) {
                case "1":
                    catalogue.afficherCatalogue();
                    break;
                case "2":
                    System.out.print("ID article : ");
                    String id = sc.nextLine();
                    int index = catalogue.trouverIndexParId(id);
                    if (index == -1) {
                        System.out.println("Article introuvable !");
                        break;
                    }
                    System.out.print("Quantité : ");
                    try {
                        int qte = Integer.parseInt(sc.nextLine());
                        panier.ajouterAuPanier(catalogue.getArticle(index), qte);
                    } catch (NumberFormatException e) {
                        System.out.println(" Quantité invalide !");
                    }
                    break;
                case "3":
                    panier.afficherPanier();
                    break;
                case "4":
                    panier.afficherPanier();
                    System.out.print("Entrez le code promo : ");
                    String code = sc.nextLine();
                    int total = panier.totalBrut();
                    boolean trouve = false;
                    for (CodePromo c : codes) {
                        if (c.getCode().equals(code)) {
                            trouve = true;
                            int net = total - (c.getPourcentage() * total / 100);
                            System.out.println(" Code appliqué : -" + c.getPourcentage() + "%");
                            System.out.println("Total à payer : " + net + " cts");
                        }
                    }
                    if (!trouve) System.out.println("❌ Code inconnu !");
                    break;
                case "5":
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }

        sc.close();
        System.out.println("Merci d'avoir utilisé KendiFood !");
    }
}
