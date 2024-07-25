package br.com.devleofulco.subsistemaCrm;

public class CrmService {

    public CrmService() {
        super();
    }

    public static void gravarCliente(String nome, String cep, String cidade, String estado){
        System.out.println("Cliente salvo na camada de sistema de crm:");
        System.out.println(nome);
        System.out.println(cidade);
        System.out.println(cep);
        System.out.println(estado);
    }

}
