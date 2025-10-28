package MODELE;

public class Article {
    private String id;
    private String libelle;
    private int prixCentimes;
    private int stock;

    public Article(String id, String libelle, int prixCentimes, int stock) {
        if (id == null || id.isEmpty() || libelle == null || libelle.isEmpty())
            throw new IllegalArgumentException("❌ ID et libellé ne peuvent pas être vides.");
        if (prixCentimes < 0 || stock < 0)
            throw new IllegalArgumentException("❌ Prix et stock doivent être positifs.");

        this.id = id;
        this.libelle = libelle;
        this.prixCentimes = prixCentimes;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getLibelle() { return libelle; }
    public int getPrixCentimes() { return prixCentimes; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %5d cts | stock=%d", id, libelle, prixCentimes, stock);
    }
}

