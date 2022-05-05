package com.cricinfo.livescore.util;

import javax.persistence.AttributeConverter;

public class StringTrimConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn( String attribute ) {

        if( attribute == null )
            return attribute;

        return attribute.trim();
    }

    @Override
    public String convertToEntityAttribute( String dbData ) {

        if( dbData == null )
            return dbData;

        return dbData.trim();
    }
}