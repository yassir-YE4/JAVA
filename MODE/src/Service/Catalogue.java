package Service;
import MODELE.Article;

public class Catalogue {
    private Article[] articles;
    private int tailleCourante;

    public Catalogue() {
        this.articles = new Article[10];
        this.tailleCourante = 0;
    }

    public void ajouterArticle(Article a) {
        if (tailleCourante == articles.length)
            agrandirCatalogue();
        articles[tailleCourante++] = a;
    }

    private void agrandirCatalogue() {
        Article[] nouveau = new Article[articles.length + 5];
        for (int i = 0; i < articles.length; i++)
            nouveau[i] = articles[i];
        articles = nouveau;
    }

    public int trouverIndexParId(String id) {
        for (int i = 0; i < tailleCourante; i++) {
            if (articles[i].getId().equals(id))
                return i;
        }
        return -1;
    }

    public Article getArticle(int index) {
        return articles[index];
    }

    public void afficherCatalogue() {
        System.out.println("\n[CATALOGUE]");
        for (int i = 0; i < tailleCourante; i++)
            System.out.println("- " + articles[i]);
    }
}