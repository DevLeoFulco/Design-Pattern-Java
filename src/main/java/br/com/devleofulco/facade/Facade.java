package br.com.devleofulco.facade;

import br.com.devleofulco.subsistemaCrm.CrmService;
import br.com.devleofulco.subsistemaCep.CepApi;


public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);

    }
}