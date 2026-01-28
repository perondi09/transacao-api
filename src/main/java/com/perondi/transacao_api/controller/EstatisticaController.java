package com.perondi.transacao_api.controller;

import com.perondi.transacao_api.business.services.EstatisticasServices;
import com.perondi.transacao_api.controller.dtos.EstatisticasResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor

public class EstatisticaController {

    private final EstatisticasServices estatisticasServices;

    @GetMapping
    @Operation(description = "Endpoint responsavel por buscar estatisticas de transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca feita com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(@RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca) {

        return ResponseEntity.ok(estatisticasServices.calcularEstatisticas(intervaloBusca));
    }
}
