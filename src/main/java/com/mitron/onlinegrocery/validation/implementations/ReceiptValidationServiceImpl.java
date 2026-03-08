package com.mitron.onlinegrocery.validation.implementations;

import org.springframework.stereotype.Component;

import com.mitron.onlinegrocery.domain.entities.Product;
import com.mitron.onlinegrocery.domain.entities.Receipt;
import com.mitron.onlinegrocery.domain.models.service.CategoryServiceModel;
import com.mitron.onlinegrocery.domain.models.service.ProductServiceModel;
import com.mitron.onlinegrocery.domain.models.service.ReceiptServiceModel;
import com.mitron.onlinegrocery.validation.ProductValidationService;
import com.mitron.onlinegrocery.validation.ReceiptValidationService;

import java.util.List;

@Component
public class ReceiptValidationServiceImpl implements ReceiptValidationService {
    @Override
    public boolean isValid(Receipt receipt) {
        return receipt != null;
    }

    @Override
    public boolean isValid(ReceiptServiceModel receiptServiceModel) {
        return receiptServiceModel != null;
    }
}
