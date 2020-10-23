package br.com.ProjetoMagalu.services;

import br.com.ProjetoMagalu.dto.AgendamentoEnvioComunicacaoDTO;
import br.com.ProjetoMagalu.models.AgendamentoEnvioComunicacao;
import br.com.ProjetoMagalu.repositories.AgendamentoEnvioComunicacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoEnvioComunicacaoRepository repository;


    public AgendamentoEnvioComunicacao cadastra(AgendamentoEnvioComunicacaoDTO comunicacao) {

        LocalDateTime data = this.trataDiaHora(comunicacao.getData(), comunicacao.getHora());

        AgendamentoEnvioComunicacao comunicacaoBuild = AgendamentoEnvioComunicacao.builder()
                .dataHoraDoEnvio(data)
                .destinatario(comunicacao.getDestinatario())
                .mensagem(comunicacao.getMensagem())
                .tipoEnvio(comunicacao.getTipoEnvio())
                .build();

        log.info("Cadastrando um novo Agendamento -> {}", comunicacaoBuild );

        return this.repository.save(comunicacaoBuild);
    }

    public List<AgendamentoEnvioComunicacao> getAll() {

        log.info("Buscando todo o Agendamento da Base");

        return repository.findAll();
    }

    public Optional<AgendamentoEnvioComunicacao> getById(Long id) {

        log.info("Pesquisando o Agendamento -> {}", id );

        return repository.findById(id);
    }

    public void deleteById(Long id) {

        log.info("Apagando o Agendamento -> {}", id );

        this.repository.deleteById(id);
    }

    private LocalDateTime trataDiaHora(String data, String hora) {

        String[] splitData = data.split("/");
        String[] splitHora = hora.split(":");

        LocalDateTime localDateTime = LocalDateTime.of(Integer.parseInt(splitData[2]),
                Integer.parseInt(splitData[1]),
                Integer.parseInt(splitData[0]),
                Integer.parseInt(splitHora[0]),
                Integer.parseInt(splitHora[1]),
                Integer.parseInt(splitHora[2]));

        return localDateTime;
    }


}
