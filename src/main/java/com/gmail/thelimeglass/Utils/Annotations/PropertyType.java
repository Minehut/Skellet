package com.gmail.thelimeglass.Utils.Annotations;

import ch.njol.skript.lang.ExpressionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PropertyType {
    public ExpressionType value();
}

