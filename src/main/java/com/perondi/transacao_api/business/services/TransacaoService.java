package com.perondi.transacao_api.business.services;

import com.perondi.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.perondi.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacao = new ArrayList<>();

    public void adicionarTransacao(TransacaoRequestDTO dto) {

        log.info("Iniciado a gravação de transações" +  dto.toString());

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que data atual.");
            throw new UnprocessableEntity("Data e hora maiores que data e hora atual.");
        }

        if (dto.valor() < 0){
            log.error("Valor não pode ser menor que 0");
            throw new UnprocessableEntity("Valor não pode ser menor que 0");
        }

        listaTransacao.add(dto);
        log.info("Transação feito com sucesso");
    }

    public void limparTransacoes(){

        log.info("Iniciando processamento para deletar transacoes");
        listaTransacao.clear();
        log.info("Deletada com sucesso");

    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){

        log.info("Iniciando processamento para deletar transacoes" +  intervaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        log.info("Retorno feito com sucesso");
        return listaTransacao.stream().filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo)).toList();

    }
}
