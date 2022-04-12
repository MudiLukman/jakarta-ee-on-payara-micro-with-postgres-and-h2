package com.kontrol.javaeedemo.grocery.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

@Converter
public class UUIDConverter implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return uuid.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String s) {
        return UUID.fromString(s);
    }
}
