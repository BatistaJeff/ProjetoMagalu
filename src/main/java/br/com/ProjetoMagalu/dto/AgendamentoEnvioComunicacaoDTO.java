package br.com.ProjetoMagalu.dto;

import br.com.ProjetoMagalu.models.TipoEnvioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoEnvioComunicacaoDTO {

    private String data;

    private String Hora;

    private String destinatario;

    private String mensagem;

    private TipoEnvioEnum tipoEnvio;

}
