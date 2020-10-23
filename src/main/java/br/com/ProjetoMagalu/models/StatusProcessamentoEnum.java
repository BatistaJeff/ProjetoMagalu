package br.com.ProjetoMagalu.models;

import lombok.Getter;

import java.util.stream.Stream;

public enum StatusProcessamentoEnum {

    A_PROCESSAR(0, "Aguardando Processar"),
    EM_PROCESSAMENTO(1, "Em Processamento"),
    PROCESSADO(2, "Processado"),
    ERRO_PROCESSAMENTO(9, "Erro ao Processar");

    @Getter
    private final Integer status;

    @Getter
    private final String texto;

    StatusProcessamentoEnum(Integer status, String texto) {
        this.status = status;
        this.texto = texto;
    }

    public static StatusProcessamentoEnum fromValue(Integer status) {
        if (status == null) {
            return null;
        }

        return Stream.of(StatusProcessamentoEnum.values())
                .filter(s -> s.getStatus().equals(status))
                .findFirst().orElse(null);

    }

}
