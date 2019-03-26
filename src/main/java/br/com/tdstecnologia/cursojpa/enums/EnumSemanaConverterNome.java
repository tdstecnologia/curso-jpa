package br.com.tdstecnologia.cursojpa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EnumSemanaConverterNome implements AttributeConverter<EnumSemama, String> {

    @Override
    public String convertToDatabaseColumn(EnumSemama dia) {
        switch (dia) {
            case DOMINGO:
                return EnumSemama.DOMINGO.nome;
            case SEGUNDA:
                return EnumSemama.SEGUNDA.nome;
            case TERCA:
                return EnumSemama.TERCA.nome;
            default:
                throw new IllegalArgumentException("Dia da semana inválido");
        }
    }

    @Override
    public EnumSemama convertToEntityAttribute(String nome) {

        switch (nome) {
            case "DOMINGO":
                return EnumSemama.DOMINGO;
            case "SEGUNDA":
                return EnumSemama.SEGUNDA;
            case "TERCA":
                return EnumSemama.TERCA;
            default:
                throw new IllegalArgumentException("Dia da semana inválido");
        }

    }

}
