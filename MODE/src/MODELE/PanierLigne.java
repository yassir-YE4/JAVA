package MODELE;

public class PanierLigne {
    private Article article;
    private int quantite;

    public PanierLigne(Article article, int quantite) {
        if (quantite <= 0) throw new IllegalArgumentException(" Quantité doit être > 0");
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() { return article; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public int getTotal() {
        return article.getPrixCentimes() * quantite;
    }

    @Override
    public String toString() {
        return String.format("%-10s x%-2d => %d cts", article.getId(), quantite, getTotal());
    }
}
