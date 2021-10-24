package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.config.AbstractController;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.config.SaidaDefault;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.HistoricoResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.NotasResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.facade.NotasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController implements AbstractController<SaidaDefault> {

    @Autowired
    private NotasFacade notasFacade;

    @GetMapping("/semestre-atual/{nrMatricula}")
    public ResponseEntity<?> getNotasSemestreAtualByUser (@PathVariable(name = "nrMatricula") final Long numeroMatricula) {
        List<NotasResponse> response = notasFacade.getNotasByUser(numeroMatricula);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message("Lista de Notas retornado com sucesso").build(), HttpStatus.OK);
    }

    @GetMapping("/{nrMatricula}")
    public ResponseEntity<?> getNotasByUser (@PathVariable(name = "nrMatricula") final Long numeroMatricula) {
        List<HistoricoResponse> response = notasFacade.getHistoricoByUser(numeroMatricula);
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message("Lista de Notas retornado com sucesso").build(), HttpStatus.OK);
    }


}
