package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrquestradorBdMateriaResponse {

    @JsonProperty("data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Materia responseBody;

    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  message;

    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  description;

}
