package com.nttdata.bootcoinpurse.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Data
public class BootCoinSellingTicketDto {

    private String bootCoinPurchaseId;
    private String sellerAccount;
    private String bootCoinSellerPurseId;
    private String bootCoinBuyerPurseId;
    private float amountToPay;
    private float soldBootCoinAmount;

}
