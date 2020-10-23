package br.com.ProjetoMagalu.controllers.impl;

import br.com.ProjetoMagalu.controllers.IAgendamentoEnvioComunicacaoController;
import br.com.ProjetoMagalu.dto.AgendamentoEnvioComunicacaoDTO;
import br.com.ProjetoMagalu.models.AgendamentoEnvioComunicacao;
import br.com.ProjetoMagalu.services.AgendamentoService;
import br.com.ProjetoMagalu.services.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;


@RestController
@CrossOrigin
@RequestMapping("/api/agendamento")
public class AgendamentoEnvioComunicacaoController implements IAgendamentoEnvioComunicacaoController {

    @Autowired
    private AgendamentoService service;

    @Autowired
    private UtilsService utilsService;

    private static final String SEM_PERMISSAO = "Sem acesso";

    @Override
    @PostMapping()
    public ResponseEntity create(@RequestHeader(value = "Authorization") String tokenBearer,
                                 @Valid @RequestBody AgendamentoEnvioComunicacaoDTO comunicacao) {

        if(!utilsService.validaToken(tokenBearer))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).body(SEM_PERMISSAO);

        return ResponseEntity.ok().body(this.service.cadastra(comunicacao));
    }

    @Override
    @GetMapping()
    public ResponseEntity getAll(@RequestHeader(value = "Authorization") String tokenBearer) {

        if(!utilsService.validaToken(tokenBearer))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).body(SEM_PERMISSAO);

        List<AgendamentoEnvioComunicacao> comunicacaoList = this.service.getAll();

        if (comunicacaoList.isEmpty())
            return noContent().build();

        return ok(comunicacaoList);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity get(@RequestHeader(value = "Authorization") String tokenBearer,
                              @PathVariable(value = "id") Long id) {
        if(!utilsService.validaToken(tokenBearer))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).body(SEM_PERMISSAO);

        Optional<AgendamentoEnvioComunicacao> comunicacao = this.service.getById(id);

        if ( !comunicacao.isPresent() )
            return noContent().build();

        return ok(comunicacao.get());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestHeader(value = "Authorization") String tokenBearer,
                                 @PathVariable(value = "id") Long id) {

        if(!utilsService.validaToken(tokenBearer))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).body(SEM_PERMISSAO);

        this.service.deleteById(id);

        return status(HttpStatus.OK).build();
    }
}
