package com.nttdata.bootcoinpurse.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcoinpurse.dto.BootCoinPaymentDto;
import com.nttdata.bootcoinpurse.repository.BootCoinPurseRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }
    @Autowired
    private BootCoinPurseRepository bootCoinPurseRepository;

    @KafkaListener(topics = "coin-payment" , groupId = "default")
    public void receiveBootCoinPayment(String message) throws JsonProcessingException {
        BootCoinPaymentDto payment = objectMapper.readValue(message, BootCoinPaymentDto.class);
        bootCoinPurseRepository.findById(payment.getBootCoinPurseId()).subscribe(purse -> {
            purse.setBootCoinAmount(purse.getBootCoinAmount() + payment.getBootCoinAmount());
            bootCoinPurseRepository.save(purse).subscribe();
        });
    }
}
