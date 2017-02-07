package com.guiga.twds.converter;

import com.guiga.twds.enumeration.TypeItemEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * Created by guilherme on 30/01/17.
 */
@Converter(autoApply = true)
public class TypeItemConverter implements AttributeConverter<TypeItemEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TypeItemEnum attribute) {
        return Objects.nonNull(attribute) ? attribute.getId() : null;
    }

    @Override
    public TypeItemEnum convertToEntityAttribute(Integer dbData) {
        return TypeItemEnum.lookup(dbData);
    }
}
