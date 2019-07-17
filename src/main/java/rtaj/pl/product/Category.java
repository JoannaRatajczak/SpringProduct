package rtaj.pl.product;

public enum Category {
    DOMOWE("DOMOWE"), SPOZYWCZE("SPOZYWCZE"), INNE("INNE"),
    ;
    private final String text;

    Category(final String text) {
        this.text = text;
    }
}
