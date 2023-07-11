package org.cjpostma.shop.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.cjpostma.shop.exception.WebError;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Pulls up common entity retrieval controller method settings.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses({
        @ApiResponse(responseCode = "200", description = RetrievalOperation.S200_TEXT, useReturnTypeSchema = true),
        @ApiResponse(responseCode = "400", description = RetrievalOperation.S400_TEXT, content = @Content(mediaType = "application/json", schema = @Schema(implementation = WebError.class))),
        @ApiResponse(responseCode = "401", description = RetrievalOperation.S401_TEXT, content = @Content),
        @ApiResponse(responseCode = "403", description = RetrievalOperation.S403_TEXT, content = @Content),
        @ApiResponse(responseCode = "404", description = RetrievalOperation.S404_TEXT, content = @Content),
        @ApiResponse(responseCode = "500", description = RetrievalOperation.S500_TEXT, content = @Content),
        @ApiResponse(responseCode = "503", description = RetrievalOperation.S503_TEXT, content = @Content)
})
public @interface RetrievalOperation {
    String S200_TEXT = "Succes";
    String S400_TEXT = "Bad request";
    String S401_TEXT = "Bad credential";
    String S403_TEXT = "Access Forbidden";
    String S404_TEXT = "Object not found";
    String S500_TEXT = "Internal server error";
    String S503_TEXT = "Remote Service unavailable";
}
