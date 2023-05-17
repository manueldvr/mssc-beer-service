package com.ms.msscbeerservice.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import jakarta.validation.constraints.Null;

/**
 * Beer DTO
 * @version 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    /**
     * '@Null' indicates that we don't want that these properties
     * sets from the outside world.
     * These constrains stop malicious insertions of values and
     * interference of business logic.
     * There are readonly properties for the client side.
     */

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyle beerStyle;

    @Positive
    @NotNull
    private Long upc;

    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;
}
