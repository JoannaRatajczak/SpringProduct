package rtaj.pl.product;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepo {

    private Set<Product> prodList;

    public ProductRepo() {
        prodList = new HashSet<>();
        this.prodList.add(new Product(Category.INNE, "Filodendron", 24.99));
        this.prodList.add(new Product(Category.DOMOWE, "Gumowa Kaczuszka", 10.50));
        this.prodList.add(new Product(Category.DOMOWE, "Maskotka Żubr", 44.50));
        this.prodList.add(new Product(Category.SPOZYWCZE, "Czekolada", 4.99));
    }

    public Set<Product> getAll() {
        return prodList;
    }

    public void add(Product product) {
        prodList.add(product);
    }


}
