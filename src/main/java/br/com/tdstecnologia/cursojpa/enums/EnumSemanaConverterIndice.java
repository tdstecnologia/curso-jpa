package br.com.tdstecnologia.cursojpa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EnumSemanaConverterIndice implements AttributeConverter<EnumSemama, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EnumSemama dia) {
        switch (dia) {
            case DOMINGO:
                return EnumSemama.DOMINGO.indice;
            case SEGUNDA:
                return EnumSemama.SEGUNDA.indice;
            case TERCA:
                return EnumSemama.TERCA.indice;
            default:
                throw new IllegalArgumentException("Dia da semana inválido");
        }
    }

    @Override
    public EnumSemama convertToEntityAttribute(Integer indice) {

        switch (indice) {
            case 11:
                return EnumSemama.DOMINGO;
            case 22:
                return EnumSemama.SEGUNDA;
            case 33:
                return EnumSemama.TERCA;
            default:
                throw new IllegalArgumentException("Dia da semana inválido");
        }

    }

}
