package MODELE;

public class CodePromo {
    private String code;
    private int pourcentage;

    public CodePromo(String code, int pourcentage) {
        this.code = code;
        this.pourcentage = pourcentage;
    }

    public String getCode() { return code; }
    public int getPourcentage() { return pourcentage; }
}
