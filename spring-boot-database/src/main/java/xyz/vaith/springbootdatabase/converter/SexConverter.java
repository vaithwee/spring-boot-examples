package xyz.vaith.springbootdatabase.converter;

import xyz.vaith.springbootdatabase.enumeration.Sex;

import javax.persistence.AttributeConverter;

public class SexConverter implements AttributeConverter<Sex, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Sex sex) {
        return sex.getId();
    }

    @Override
    public Sex convertToEntityAttribute(Integer integer) {
        return Sex.getEnumById(integer);
    }
}
