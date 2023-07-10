package org.cjpostma.shop.controller;

import org.cjpostma.shop.model.Shoe;
import org.cjpostma.shop.repository.PriceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    private final PriceRepository repository;

    public PriceController(PriceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{style}/{price}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePrice(@PathVariable final String style, BigDecimal price) {

        repository.setPrice(Shoe.Style.getStyle(style), price);
    }
}
