package com.nttdata.bootcoinpurse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nttdata.bootcoinpurse.document.BootCoinPurse;
import com.nttdata.bootcoinpurse.dto.BootCoinPurchaseDto;
import com.nttdata.bootcoinpurse.dto.BootCoinSellingTicketDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * BootCoinPurse service interface.
 */
public interface BootCoinPurseService {

    public Flux<BootCoinPurse> findAll();

    public Mono<BootCoinPurse> register(BootCoinPurse bootCoinPurse);

    public Mono<BootCoinPurse> update(BootCoinPurse bootCoinPurse);

    public Mono<Void> delete(String id);

    public Mono<BootCoinPurse> findById(String id);

    public Mono<String> publishBootCoinPurchase(BootCoinPurchaseDto bootCoinPurchaseDto) throws JsonProcessingException;

    public Mono<String> attendBootCoinPurchase(BootCoinSellingTicketDto bootCoinSellingTicketDto) throws JsonProcessingException;
}
