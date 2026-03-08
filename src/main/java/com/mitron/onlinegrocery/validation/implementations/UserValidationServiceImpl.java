package com.mitron.onlinegrocery.validation.implementations;

import org.springframework.stereotype.Component;

import com.mitron.onlinegrocery.domain.models.service.UserServiceModel;
import com.mitron.onlinegrocery.validation.UserValidationService;

@Component
public class UserValidationServiceImpl implements UserValidationService {
    @Override
    public boolean isValid(UserServiceModel user) {
        return user != null;
    }
}
