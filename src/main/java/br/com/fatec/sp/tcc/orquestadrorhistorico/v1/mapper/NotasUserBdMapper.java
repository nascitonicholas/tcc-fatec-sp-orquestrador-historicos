package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.mapper;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.NotasResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.Materia;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.NotasUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface NotasUserBdMapper {

    @Mappings({
            @Mapping(target = "id", source = "nota.id"),
            @Mapping(target = "disciplina", source = "materia.codMateria"),
            @Mapping(target = "professor", expression = "java(materia.getProfessores().get(0).getNome())"),
    })
    NotasResponse mapNotaMateriaBdToNotasResponse(final NotasUsuario nota, final Materia materia);

    default List<NotasResponse> mapNotasUserBdToListaNotasResponse(final List<NotasUsuario> notasUsuarios, final List<Materia> listaMaterias) {
        List<NotasResponse> notasResponse = new ArrayList<>();
        notasUsuarios.forEach(nota -> {
            notasResponse.add(mapNotaMateriaBdToNotasResponse(nota, listaMaterias.stream().filter(materia -> nota.getMateria().getId() == materia.getId()).findFirst().get()));
        });
        return notasResponse;
    }
}
