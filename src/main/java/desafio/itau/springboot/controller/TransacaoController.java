package desafio.itau.springboot.controller;

import desafio.itau.springboot.dto.TransacaoRequest;
import desafio.itau.springboot.model.Transacao;
import desafio.itau.springboot.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody TransacaoRequest dto){
        Transacao novo = new Transacao(dto.getValor(), dto.getDataHora());
        transacaoService.salvar(novo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(){
        transacaoService.deletar();
        return ResponseEntity.ok().build();
    }

}
