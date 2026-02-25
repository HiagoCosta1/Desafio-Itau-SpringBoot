package desafio.itau.springboot.service;


import desafio.itau.springboot.model.Transacao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransacaoService {

    private final Queue<Transacao> lista = new ConcurrentLinkedQueue<>();

    @PostMapping
    public void salvar(Transacao transacao){
        OffsetDateTime agora = OffsetDateTime.now();
        if(transacao.getValor() <= 0 || transacao.getDataHora().isAfter(agora) || transacao.getDataHora().isBefore(agora.minusSeconds(60))){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_CONTENT);
        }
        lista.add(transacao);
    }

    public void deletar(){
        lista.clear();
    }
}
