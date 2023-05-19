package com.ms.msscbeerservice.web.mappers;

import com.ms.msscbeerservice.web.domain.Beer;
import com.ms.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;
@Mapper
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer aBeer);

    Beer BeerDtoToBeer(BeerDto aBeerDto);
}
