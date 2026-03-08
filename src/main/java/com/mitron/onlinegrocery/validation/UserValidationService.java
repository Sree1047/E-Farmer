package com.mitron.onlinegrocery.validation;

import com.mitron.onlinegrocery.domain.models.service.UserServiceModel;

public interface UserValidationService {
    boolean isValid(UserServiceModel user);
}
