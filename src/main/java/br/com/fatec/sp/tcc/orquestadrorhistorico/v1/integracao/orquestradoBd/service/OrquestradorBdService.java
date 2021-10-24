package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.service;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.client.OrquestradorBdClient;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.Materia;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.NotaUsuario;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.OrquestradorBdNotasByUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class OrquestradorBdService {

    @Autowired
    private OrquestradorBdClient orquestradorBdClient;

    public OrquestradorBdNotasByUserResponse buscaNotasByUser(final Long numeroMatricula) {
        try {
            return orquestradorBdClient.getNotasByUsuario(numeroMatricula);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível buscar notas por usuario: Erro - " + e);
        }
    }

    public Materia buscaMateriaById(final NotaUsuario nota) {
        try {
            if (Objects.nonNull(nota)){
                if (Objects.nonNull(nota.getMateria())) {
                    return orquestradorBdClient.getMateria(nota.getMateria().getId()).getResponseBody();
                }
            }
            return null;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível buscar materia por id: Erro - " + e);
        }
    }

}
