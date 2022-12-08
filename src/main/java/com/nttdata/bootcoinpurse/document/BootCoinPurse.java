package com.nttdata.bootcoinpurse.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * BootCoinPurse document.
 */
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Document(collection = "bootcoinpurses")
public class BootCoinPurse {

    @Id
    private String id;

    private String idDocument;

    private String phoneNumber;

    private String email;

    private float bootCoinAmount;
}
