package com.nttdata.bootcoinpurse.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nttdata.bootcoinpurse.document.BootCoinPurse;
import com.nttdata.bootcoinpurse.dto.BootCoinPurchaseDto;
import com.nttdata.bootcoinpurse.dto.BootCoinSellingTicketDto;
import com.nttdata.bootcoinpurse.repository.BootCoinPurseRepository;
import com.nttdata.bootcoinpurse.service.BootCoinPurseService;
import com.nttdata.bootcoinpurse.service.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinPurseServiceImpl implements BootCoinPurseService {

    @Autowired
    BootCoinPurseRepository bootCoinPurseRepository;

    private final Producer producer;

    @Autowired
    public BootCoinPurseServiceImpl(Producer producer) {
        this.producer = producer;
    }
    @Override
    public Flux<BootCoinPurse> findAll() {
        return bootCoinPurseRepository.findAll();
    }

    @Override
    public Mono<BootCoinPurse> register(BootCoinPurse bootCoinPurse) {
        return bootCoinPurseRepository.save(bootCoinPurse);
    }

    @Override
    public Mono<BootCoinPurse> update(BootCoinPurse bootCoinPurse) {
        return bootCoinPurseRepository.save(bootCoinPurse);
    }

    @Override
    public Mono<Void> delete(String id) {
        return bootCoinPurseRepository.deleteById(id);
    }

    @Override
    public Mono<BootCoinPurse> findById(String id) {
        return bootCoinPurseRepository.findById(id);
    }

    @Override
    public Mono<String> publishBootCoinPurchase(BootCoinPurchaseDto bootCoinPurchaseDto) throws JsonProcessingException {
        return Mono.just(producer.sendBootCoinPurchase(bootCoinPurchaseDto));
    }

    @Override
    public Mono<String> attendBootCoinPurchase(BootCoinSellingTicketDto bootCoinSellingTicketDto) throws JsonProcessingException {
        bootCoinSellingTicketDto.setAmountToPay(bootCoinSellingTicketDto.getSoldBootCoinAmount() * 3);
        return Mono.just(producer.attendBootCoinPurchase(bootCoinSellingTicketDto));
    }
}
