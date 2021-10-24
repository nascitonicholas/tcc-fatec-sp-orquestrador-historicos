package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.facade;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.HistoricoResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.NotasResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.Materia;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.NotaUsuario;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.OrquestradorBdNotasByUserResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.service.OrquestradorBdService;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.mapper.NotasUserBdMapper;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.utils.DataUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class NotasFacade {

    @Autowired
    private OrquestradorBdService orquestradorBdService;

    private NotasUserBdMapper notasUserBdMapper = Mappers.getMapper(NotasUserBdMapper.class);

    public List<NotasResponse> getNotasByUser(final Long numeroMatricula) {
        final OrquestradorBdNotasByUserResponse notasUser = orquestradorBdService.buscaNotasByUser(numeroMatricula);
        final List<NotaUsuario> notasUserSemestreAtual = filtraNotasAtualByUser(notasUser);
        final List<NotasResponse> notasUsuarioSemestreatual = mapToListaNotasResponse(notasUserSemestreAtual);
        return notasUsuarioSemestreatual;
    }

    public List<HistoricoResponse> getHistoricoByUser(final Long numeroMatricula) {
        final OrquestradorBdNotasByUserResponse notasUser = orquestradorBdService.buscaNotasByUser(numeroMatricula);
        final List<HistoricoResponse> historicoUsuario = mapToListaHistoricoResponse(notasUser);
        return historicoUsuario;
    }

    private List<NotaUsuario> filtraNotasAtualByUser(final OrquestradorBdNotasByUserResponse notasUser) {
        try {
            if (Objects.nonNull(notasUser.getResponseBody())) {
                return notasUser.getResponseBody().stream().filter(am ->
                        DataUtils.buscaAnoMesDoSemestreAtual().equalsIgnoreCase(am.getAnoMesConclusao())).collect(Collectors.toList());
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível filtrar as notas do semestre atual: Erro - " + e.getMessage());
        }
    }

    private List<NotasResponse> mapToListaNotasResponse(final List<NotaUsuario> notasUserSemestreAtual) {
        try {
            if(Objects.nonNull(notasUserSemestreAtual) && !notasUserSemestreAtual.isEmpty()) {
                List<NotasResponse> saida = new ArrayList<>();
                notasUserSemestreAtual.forEach(nota -> {
                    Materia materia = orquestradorBdService.buscaMateriaById(nota);
                    saida.add(notasUserBdMapper.mapNotaMateriaBdToNotasResponse(nota, materia));
                });
                return saida;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível mapear para a saída: Erro - " + e.getMessage());
        }
    }

    private List<HistoricoResponse> mapToListaHistoricoResponse(final OrquestradorBdNotasByUserResponse notasUser) {
        try {
            if(Objects.nonNull(notasUser)) {
                if(Objects.nonNull(notasUser.getResponseBody()) && !notasUser.getResponseBody().isEmpty()) {
                    List<HistoricoResponse> saida = new ArrayList<>();
                    notasUser.getResponseBody().forEach(nota -> {
                        Materia materia = orquestradorBdService.buscaMateriaById(nota);
                        saida.add(notasUserBdMapper.mapNotaMateriaBdToHistoricoResponse(nota, materia));
                    });
                    return saida;
                }
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível mapear para a saída: Erro - " + e.getMessage());
        }
    }

}
