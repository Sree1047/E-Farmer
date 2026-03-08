package com.mitron.onlinegrocery.validation;

import com.mitron.onlinegrocery.domain.entities.Receipt;
import com.mitron.onlinegrocery.domain.models.service.ReceiptServiceModel;

public interface ReceiptValidationService {
    boolean isValid(Receipt receipt);

    boolean isValid(ReceiptServiceModel receiptServiceModel);
}
