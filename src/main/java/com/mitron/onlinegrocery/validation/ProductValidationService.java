package com.mitron.onlinegrocery.validation;

import com.mitron.onlinegrocery.domain.entities.Product;
import com.mitron.onlinegrocery.domain.models.service.ProductServiceModel;

public interface ProductValidationService {
    boolean isValid(Product product);

    boolean isValid(ProductServiceModel product);
}
