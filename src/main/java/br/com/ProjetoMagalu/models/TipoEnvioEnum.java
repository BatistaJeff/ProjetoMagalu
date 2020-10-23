package br.com.ProjetoMagalu.models;

import lombok.Getter;

import java.util.stream.Stream;

public enum TipoEnvioEnum {

    WHATSAPP(0, "Whatsapp"),
    EMAIL(1, "Email"),
    SMS(2, "SMS"),
    PUSH(9, "Push");

    @Getter
    private final Integer status;

    @Getter
    private final String texto;

    TipoEnvioEnum(Integer status, String texto) {
        this.status = status;
        this.texto = texto;
    }

    public static TipoEnvioEnum fromValue(Integer status) {
        if (status == null) {
            return null;
        }

        return Stream.of(TipoEnvioEnum.values())
                .filter(s -> s.getStatus().equals(status))
                .findFirst().orElse(null);

    }

}
