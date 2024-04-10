package app.mapl.util.converters;

import app.mapl.models.Authority;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;


public class BooleanConverter implements AttributeConverter<Boolean, String> {
    /**
     * @param booleanValue
     * @return
     */
    @Override
    public String convertToDatabaseColumn(Boolean booleanValue) {
        if (booleanValue == null) {
            return null;
        }
        return booleanValue ? "Y" : "N";
    }

    /**
     * @param s
     * @return Boolean
     */
    @Override
    public Boolean convertToEntityAttribute(String s) {
        return s != null && s.equalsIgnoreCase("Y");
    }



}
