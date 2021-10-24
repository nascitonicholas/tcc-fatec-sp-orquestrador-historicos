package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotasResponse {

    private String id;
    private String disciplina;
    private String faltas;
    private String professor;
    @JsonProperty("nota")
    private String notaFinal;

}
