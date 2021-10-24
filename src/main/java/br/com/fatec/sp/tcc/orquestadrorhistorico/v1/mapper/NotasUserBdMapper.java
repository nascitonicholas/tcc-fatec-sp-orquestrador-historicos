package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.mapper;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response.NotasResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.Materia;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.NotaUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface NotasUserBdMapper {

    @Mappings({
            @Mapping(target = "id", source = "nota.id"),
            @Mapping(target = "disciplina", source = "materia.codMateria"),
            @Mapping(target = "professor", expression = "java(materia.getProfessores().get(0).getNome())"),
    })
    NotasResponse mapNotaMateriaBdToNotasResponse(final NotaUsuario nota, final Materia materia);

}
