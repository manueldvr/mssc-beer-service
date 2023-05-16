package com.ms.msscbeerservice.repositories;

import com.ms.msscbeerservice.web.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
