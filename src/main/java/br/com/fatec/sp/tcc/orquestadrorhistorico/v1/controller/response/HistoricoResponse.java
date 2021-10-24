package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoResponse {

    private String disciplina;
    private String nomeDisciplina;
    private String conclusao;
    private String media;
    private String conceito;
    private String semestre;

}
