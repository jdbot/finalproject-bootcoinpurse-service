package com.nttdata.bootcoinpurse.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nttdata.bootcoinpurse.document.BootCoinPurse;
import com.nttdata.bootcoinpurse.dto.BootCoinPurchaseDto;
import com.nttdata.bootcoinpurse.dto.BootCoinSellingTicketDto;
import com.nttdata.bootcoinpurse.service.BootCoinPurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller of BootCoinPurse.
 */
@RestController
@RequestMapping("/bootcoinpurse")
public class BootCoinPurseController {

    @Autowired
    private BootCoinPurseService bootCoinPurseService;

    //Method to get all the BootCoinPurse
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootCoinPurse> findAll() {
        return bootCoinPurseService.findAll();
    }

    //Method to insert a new BootCoinPurse
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurse> register(@RequestBody BootCoinPurse bootCoinPurse) {
        return  bootCoinPurseService.register(bootCoinPurse);
    }

    //Method to update a BootCoinPurse
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurse> modify(@RequestBody BootCoinPurse bootCoinPurse) {
        return  bootCoinPurseService.update(bootCoinPurse);
    }

    //Method to get a BootCoinPurse by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinPurse> findById(@PathVariable("id") String id) {
        return bootCoinPurseService.findById(id);
    }

    //Method to delete a BootCoinPurse
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") String id) {
        return bootCoinPurseService.delete(id);
    }

    //Method to publish a bootcoinpurchase
    @PostMapping("/publishbootcoinpurchase")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> publishBootCoinPurchase(@RequestBody BootCoinPurchaseDto bootCoinPurchaseDto) throws JsonProcessingException {
        return bootCoinPurseService.publishBootCoinPurchase(bootCoinPurchaseDto);
    }

    //Method to attend a purchase and sell boot coins
    @PostMapping("/sellbootcoin")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> attendBootCoinPurchase(@RequestBody BootCoinSellingTicketDto bootCoinSellingTicketDto) throws JsonProcessingException {
        return bootCoinPurseService.attendBootCoinPurchase(bootCoinSellingTicketDto);
    }


}
