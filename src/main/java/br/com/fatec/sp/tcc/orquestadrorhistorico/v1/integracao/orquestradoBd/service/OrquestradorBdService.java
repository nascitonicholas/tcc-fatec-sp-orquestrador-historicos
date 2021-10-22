package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.service;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.NotasResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.client.OrquestradorBdClient;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.Materia;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.NotasUsuario;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.OrquestradorBdNotasByUserResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.mapper.NotasUserBdMapper;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.utils.DataUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrquestradorBdService {

    @Autowired
    private OrquestradorBdClient orquestradorBdClient;

    private NotasUserBdMapper notasUserBdMapper = Mappers.getMapper(NotasUserBdMapper.class);

    public List<NotasResponse> getNotasByUser(Long numeroMatricula) {
        final OrquestradorBdNotasByUserResponse notasUser = orquestradorBdClient.getNotasByUsuario(numeroMatricula);
        final List<NotasUsuario> notasUserSemestreAtual = notasUser.getResponseBody().stream().filter(am ->
                DataUtils.buscaAnoMesDoSemestreAtual().equalsIgnoreCase(am.getAnoMesConclusao())).collect(Collectors.toList());
        List<Materia> listaMaterias = new ArrayList<>();
        if (!notasUserSemestreAtual.isEmpty()) {
            notasUserSemestreAtual.forEach(nota -> {
                listaMaterias.add(orquestradorBdClient.getMateria(nota.getMateria().getId()).getResponseBody());
            });
        }
        return notasUserBdMapper.mapNotasUserBdToListaNotasResponse(notasUser.getResponseBody(), listaMaterias);
    }

}
