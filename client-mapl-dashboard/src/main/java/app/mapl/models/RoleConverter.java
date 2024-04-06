package app.mapl.models;

import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;


public class RoleConverter implements AttributeConverter<Authority, String> {
    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if(authority == null) {
            return null;
        }
        return authority.getValue();
    }
/// TODO: Implement the convertToEntityAttribute method
    @Override
    public Authority convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return null;
//return Stream.of(Authority.values())
//                .filter(c -> c.getValue().equals(dbData))
//                .findFirst()
//                .orElseThrow(IllegalAccessError::new);
    }
}
