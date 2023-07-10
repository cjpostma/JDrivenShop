package org.cjpostma.shop.repository;

import org.cjpostma.shop.model.Shoe;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class ShoeRepository {

    private final AtomicLong latestShoeId = new AtomicLong(0);
    private final Map<Long, Shoe> shoes = Arrays.stream(Shoe.Style.values())
            .flatMap(style -> IntStream.rangeClosed(35, 47).boxed().map(size -> new Shoe(latestShoeId.incrementAndGet(), style, size)))
            .collect(Collectors.toMap(Shoe::getId, Function.identity()));

    public Optional<Shoe> findById(long id) {
        return Optional.ofNullable(shoes.get(id));
    }

    public Collection<Shoe> getShoes() {
        return shoes.values();
    }
}
