package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotaUsuario {

    @JsonProperty("id_historico_disciplinar")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("aluno")
    private UsuarioResponseSimples aluno;

    @JsonProperty("materia")
    private MateriaResponseSimples materia;

    @JsonProperty("ano_mes_conclusao")
    private String anoMesConclusao;

    @JsonProperty("faltas")
    private String faltas;

    @JsonProperty("nota_final")
    private String notaFinal;

    @JsonProperty("conceito")
    private String conceito;

    @JsonProperty("data_criacao")
    private String dataCriacao;

    @JsonProperty("data_ultima_alteracao")
    private String dataUltimaAlteracao;

}
