package org.cjpostma.shop.repository;

import org.cjpostma.shop.model.Shoe;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PriceRepository {

    private final Map<Shoe.Style, BigDecimal> prices = new HashMap<>();

    public BigDecimal findByStyle(Shoe.Style style) {

        return prices.entrySet().stream().filter(e -> e.getKey() == style).findFirst().map(Map.Entry::getValue).orElseGet(() -> style.getDefaultPrice());
    }

    public void setPrice(Shoe.Style style, BigDecimal price) {
        prices.put(style, price);
    }
}
