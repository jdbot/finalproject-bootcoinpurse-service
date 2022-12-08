package com.nttdata.bootcoinpurse.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcoinpurse.dto.BootCoinPurchaseDto;
import com.nttdata.bootcoinpurse.dto.BootCoinSellingTicketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate,  ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendBootCoinPurchase(BootCoinPurchaseDto bootCoinPurchaseDto) throws JsonProcessingException {
        LOGGER.info("Sending boot coin purchase intent");
        String bootCoinPurchaseString = objectMapper.writeValueAsString(bootCoinPurchaseDto);
        kafkaTemplate.send("bootcoin-purchase",bootCoinPurchaseString);
        return "published purchase";
    }

    public String attendBootCoinPurchase(BootCoinSellingTicketDto bootCoinSellingTicketDto) throws JsonProcessingException {
        LOGGER.info("Sending boot coin selling ticket");
        String bootCoinSellingTicketString = objectMapper.writeValueAsString(bootCoinSellingTicketDto);
        kafkaTemplate.send("bootcoin-sell",bootCoinSellingTicketString);
        return "answered a purchase";
    }
}
