package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.client;

import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.OrquestradorBdMateriaResponse;
import br.com.fatec.sp.tcc.orquestadrorhistorico.v1.integracao.orquestradoBd.response.OrquestradorBdNotasByUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orquestradorBdClient", url = "${orquestrador.bd.url}")
public interface OrquestradorBdClient {

    @GetMapping(value="/historicoDisciplinar/{nrMatricula}", consumes = MediaType.APPLICATION_JSON_VALUE)
    OrquestradorBdNotasByUserResponse getNotasByUsuario(@PathVariable Long numeroMatricula);

    @GetMapping(value="/materias/{id_materia}", consumes = MediaType.APPLICATION_JSON_VALUE)
    OrquestradorBdMateriaResponse getMateria(@PathVariable Long idMateria);
}
