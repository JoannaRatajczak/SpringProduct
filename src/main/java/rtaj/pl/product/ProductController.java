package rtaj.pl.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class ProductController {

    private ProductRepo productRepo; //tworzymy pole prywatne

    public ProductController(ProductRepo productRepo) { //inicjujemy i wstrzykujemy dane
        this.productRepo = productRepo;
    }

    @ResponseBody
    @GetMapping("/kategoria")
    public String prodList(@RequestParam(name = "cat") String cat) {

        Set<Product> prodList = productRepo.getAll();

        String result = "";
        double priceSum = 0;

        for (Product product : prodList) {
            if (product.getCategory().equals(cat)) {
                result += product.toString() + "<br/>";
                priceSum += product.getProdPrice();
            } else if ("all".equals(cat)) {
                result += product.toString() + "<br/>";
                priceSum += product.getProdPrice();
            }
        }

        return result + "<br/>" + "Suma cen produktów: " + priceSum;
    }


    @GetMapping("/add")
    public String addUsers(@RequestParam(name = "cat") String cat,
                           @RequestParam(name = "prodName") String name,
                           @RequestParam(name = "prodPrice", defaultValue = "0" ) double price) {

        if (cat.isEmpty() || name.isEmpty() || price==0) {

            return "redirect:/error.html";
        } else {
            Set<Product> prodList = productRepo.getAll();
            prodList.add(new Product(Category.valueOf(cat), name, price));
            return "redirect:/dodano.html";
        }
    }
}



