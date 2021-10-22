package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.facade;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.NotasResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.service.OrquestradorBdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotasFacade {

    @Autowired
    private OrquestradorBdService orquestradorBdService;

    public List<NotasResponse> getNotasByUser(Long numeroMatricula) {
        List<NotasResponse> listaNotas = orquestradorBdService.getNotasByUser(numeroMatricula);
        return listaNotas;
    }

}
