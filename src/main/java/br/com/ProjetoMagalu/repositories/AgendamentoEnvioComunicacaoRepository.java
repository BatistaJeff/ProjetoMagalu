package br.com.ProjetoMagalu.repositories;

import br.com.ProjetoMagalu.models.AgendamentoEnvioComunicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoEnvioComunicacaoRepository extends JpaRepository<AgendamentoEnvioComunicacao, Long> {

}
