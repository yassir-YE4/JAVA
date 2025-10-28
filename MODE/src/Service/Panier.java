package Service;
import MODELE.Article;
import MODELE.PanierLigne;

public class Panier {
    private PanierLigne[] lignes;
    private int tailleCourante;

    public Panier() {
        lignes = new PanierLigne[5];
        tailleCourante = 0;
    }

    public void ajouterAuPanier(Article a, int qte) {
        if (a.getStock() < qte) {
            System.out.println(" Stock insuffisant pour " + a.getId());
            return;
        }

        a.setStock(a.getStock() - qte);

        for (int i = 0; i < tailleCourante; i++) {
            if (lignes[i].getArticle().getId().equals(a.getId())) {
                lignes[i].setQuantite(lignes[i].getQuantite() + qte);
                return;
            }
        }

        if (tailleCourante == lignes.length)
            agrandirPanier();

        lignes[tailleCourante++] = new PanierLigne(a, qte);
    }

    private void agrandirPanier() {
        PanierLigne[] nouveau = new PanierLigne[lignes.length + 5];
        for (int i = 0; i < lignes.length; i++) nouveau[i] = lignes[i];
        lignes = nouveau;
    }

    public int totalBrut() {
        int total = 0;
        for (int i = 0; i < tailleCourante; i++)
            total += lignes[i].getTotal();
        return total;
    }

    public void afficherPanier() {
        System.out.println("\n[PANIER]");
        int total = 0;
        for (int i = 0; i < tailleCourante; i++) {
            System.out.println("- " + lignes[i]);
            total += lignes[i].getTotal();
        }
        System.out.println("Total brut : " + total + " cts");
    }
}
