package online.javafun.vatcalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VatController {

    private final VatCalculatorService vatService;

    public VatController(VatCalculatorService vatService) {
        this.vatService = vatService;
    }

    @PostMapping("/calculate")
    String calculate(@RequestParam double nettoPrice,
                     @RequestParam String category,
                     Model model) {
        VatDto vat = vatService.calculateVat(nettoPrice, category);
        model.addAttribute("vat", vat);
        return "result";
    }
}
