package com.mitron.onlinegrocery.service;

import java.util.List;

import com.mitron.onlinegrocery.domain.models.service.ReceiptServiceModel;

public interface ReceiptService {

    List<ReceiptServiceModel> findAllReceiptsByUsername(String userId);

    List<ReceiptServiceModel> findAllReceipts();

    void receiptRegister(ReceiptServiceModel receiptServiceModel);

    ReceiptServiceModel getReceiptById(String id);

    void createReceipt(String orderId, String name);

    ReceiptServiceModel findReceiptById(String receiptId);
}
