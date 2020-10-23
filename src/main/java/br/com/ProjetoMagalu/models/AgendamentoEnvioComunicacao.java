package br.com.ProjetoMagalu.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoEnvioComunicacao {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_envio")
    private LocalDateTime dataHoraDoEnvio;

    @Column(name="destinatario")
    private String destinatario;

    @Column(name="mensagem")
    private String mensagem;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name="status_processamento")
    private StatusProcessamentoEnum statusProcessamento;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_envio")
    private TipoEnvioEnum tipoEnvio;

    @PrePersist
    public void prePersiste() {
        this.dataCriacao = LocalDateTime.now();
        this.statusProcessamento = StatusProcessamentoEnum.A_PROCESSAR;
    }


}
