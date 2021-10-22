package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Materia {

    @JsonProperty("id_materia")
    private Long id;
    @JsonProperty("cod_materia")
    private String codMateria;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("semestre")
    private String semestre;
    @JsonProperty("professores")
    private List<UsuarioResponseSimples> professores;
    @JsonProperty("data_criacao")
    private String dataCriacao;
    @JsonProperty("data_ultima_alteracao")
    private String dataUltimaAlteracao;

}
