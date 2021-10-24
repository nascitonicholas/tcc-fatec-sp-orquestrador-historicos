package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MateriaResponseSimples {

    @JsonProperty("id_materia")
    private Long id;
    @JsonProperty("cod_materia")
    private String codMateria;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("semestre")
    private String semestre;

}
