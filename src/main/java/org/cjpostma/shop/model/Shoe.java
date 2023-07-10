package org.cjpostma.shop.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.util.Arrays;

public class Shoe {

    public enum Brand {
        NIKE,
        PUMA,
        ADIDAS,
        VANS
    }

    public enum Style {
        OLD_SKOOL(Brand.VANS, new BigDecimal(80)),
        SK8_HI(Brand.VANS, new BigDecimal(90)),
        RBD(Brand.PUMA, new BigDecimal(100)),
        SUPERSTAR(Brand.ADIDAS, new BigDecimal(95)),
        FORUM(Brand.ADIDAS, new BigDecimal(110)),
        AIR(Brand.NIKE, new BigDecimal(150)),
        AIR_FORCE1(Brand.NIKE, new BigDecimal(130));
        private final Brand brand;
        private BigDecimal defaultPrice = null;

        Style(Brand brand, BigDecimal price) {

            this.brand = brand;
            this.defaultPrice = price.subtract(new BigDecimal("0.01"));
        }

        public Brand getBrand() {
            return brand;
        }

        public BigDecimal getDefaultPrice() {
            return defaultPrice;
        }

        public static Style getStyle(String style) {
            return Arrays.stream(values()).filter(s -> s.name().equalsIgnoreCase(style)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown style: " + style));
        }
    }

    private final long id;

    private final Style style;

    @Min(35)
    @Max(47)
    private final int size;

    public Shoe(long id, Style style, int size) {
        this.id = id;
        this.style = style;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {

        return style.brand.name();
    }

    public String getStyle() {
        return style.name();
    }

    public int getSize() {
        return size;
    }
}
