package com.mitron.onlinegrocery.validation.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import static com.mitron.onlinegrocery.util.constants.AppConstants.EMPTY_STRING;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Validator {

    @AliasFor(
            annotation = Component.class
    )
    String value() default EMPTY_STRING;
}
