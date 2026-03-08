package com.mitron.onlinegrocery.validation.implementations;

import org.springframework.stereotype.Component;

import com.mitron.onlinegrocery.domain.entities.Product;
import com.mitron.onlinegrocery.domain.models.service.CategoryServiceModel;
import com.mitron.onlinegrocery.domain.models.service.ProductServiceModel;
import com.mitron.onlinegrocery.validation.ProductValidationService;

import java.util.List;

@Component
public class ProductionValidationServiceImpl implements ProductValidationService {
    @Override
    public boolean isValid(Product product) {
        return product != null;
    }

    @Override
    public boolean isValid(ProductServiceModel product) {
        return product != null
                && areCategoriesValid(product.getCategories());
    }

    private boolean areCategoriesValid(List<CategoryServiceModel> categories) {
        return categories != null && !categories.isEmpty();
    }
}
