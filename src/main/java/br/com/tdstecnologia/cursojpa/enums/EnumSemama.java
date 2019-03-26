package br.com.tdstecnologia.cursojpa.enums;

public enum EnumSemama {

    DOMINGO("Domingo",11), SEGUNDA("Segunda-Feira",22), TERCA("Terça-Feira",33);

    public final String nome;
    public final Integer indice;

    private EnumSemama(final String nome, final Integer indice) {
        this.nome = nome;
        this.indice = indice;
    }

}
