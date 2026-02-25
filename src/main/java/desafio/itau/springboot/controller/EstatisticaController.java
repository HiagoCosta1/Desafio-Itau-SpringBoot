package desafio.itau.springboot.controller;

import desafio.itau.springboot.dto.EstatisticaResponse;
import desafio.itau.springboot.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final TransacaoService transacaoService;

    public EstatisticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponse> stats(){
        DoubleSummaryStatistics statistics = transacaoService.getStatistics();
        return ResponseEntity.ok(new EstatisticaResponse(statistics));
    }

}
