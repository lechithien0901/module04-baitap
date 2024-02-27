package com.example.demo1.model;

import javax.persistence.AttributeConverter;

public class ConvertLanguages implements AttributeConverter<String[],String> {
    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        return attribute!=null?String.join(",",attribute):null;
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        return dbData!=null?dbData.split(","):null
;    }
}
