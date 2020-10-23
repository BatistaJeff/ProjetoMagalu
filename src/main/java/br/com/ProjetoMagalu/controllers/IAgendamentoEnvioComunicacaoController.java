package br.com.ProjetoMagalu.controllers;

import br.com.ProjetoMagalu.dto.AgendamentoEnvioComunicacaoDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.Valid;

@Api("Endpoint de Agendamento")
public interface IAgendamentoEnvioComunicacaoController {

    ResponseEntity create(@RequestHeader(value = "Authorization") String tokenBearer,
                          @Valid @RequestBody AgendamentoEnvioComunicacaoDTO comunicacao);


    ResponseEntity getAll(@RequestHeader(value = "Authorization") String tokenBearer);

    ResponseEntity get(@RequestHeader(value = "Authorization") String tokenBearer,
                       @PathVariable(value = "id") Long id);

    ResponseEntity delete(@RequestHeader(value = "Authorization") String tokenBearer,
                          @PathVariable(value = "id") Long id);

}
