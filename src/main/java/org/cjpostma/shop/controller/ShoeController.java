package org.cjpostma.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.cjpostma.shop.exception.ShoeNotFoundException;
import org.cjpostma.shop.model.Shoe;
import org.cjpostma.shop.repository.ShoeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/shoe")
public class ShoeController {

    private final ShoeRepository repository;

    public ShoeController(ShoeRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the shoe",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Shoe.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Shoe not found", content = @Content)}) // @formatter:on
    @GetMapping("/{id}")
    @RetrievalOperation
    public Shoe findById(@Parameter(description = "id of shoe to be searched") @PathVariable long id) {
        return repository.findById(id).orElseThrow(ShoeNotFoundException::new);
    }

    @GetMapping("/all")
    @RetrievalOperation
    public Collection<Shoe> findShoes() {
        return repository.getShoes();
    }
}
