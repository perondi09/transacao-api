package com.perondi.transacao_api.business.services;


import com.perondi.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.perondi.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class EstatisticasServices {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticas(Integer intervaloBusca) {

        log.info("Calculando Estatisticas pelo intervaloBusca"+  intervaloBusca);
        List< TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        if(transacoes.isEmpty()){
            return new EstatisticasResponseDTO(0L,0.0,0.0,0.0,0.0);
        }

        DoubleSummaryStatistics estatisticas = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        log.info("Calculo feito com sucesso");
        return new EstatisticasResponseDTO(estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());
    };
}
