package com.ms.msscbeerservice.bootstrap;

import com.ms.msscbeerservice.repositories.BeerRepository;
import com.ms.msscbeerservice.web.domain.Beer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerobjects();
    }

    private void loadBeerobjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder().beerName("Quilmes").price(new BigDecimal("3.9"))
                            .beerStyle("Cristal").quantityToBrew(200).upc(20003562L).minOnHand(24).build());
            beerRepository.save(Beer.builder().beerName("Quilmes Block").price(new BigDecimal("2.9"))
                    .beerStyle("Block").quantityToBrew(200).upc(20003762L).minOnHand(24).build());
            beerRepository.save(Beer.builder().beerName("Quilmes Light").price(new BigDecimal("1.9")).beerStyle("Cristal")
                    .quantityToBrew(200).upc(20003111L).minOnHand(24).build());
        }
        //System.out.println("Loading finished with: " + beerRepository.count());
    }
}
