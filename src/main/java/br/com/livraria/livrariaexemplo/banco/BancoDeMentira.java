/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.banco;

import br.com.livraria.livrariaexemplo.model.Filtro;
import br.com.livraria.livrariaexemplo.model.Mensagem;
import br.com.livraria.livrariaexemplo.model.Destinatario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mocbezerra
 */
public class BancoDeMentira {

    private final List<Destinatario> destinatarios;
    private List<Filtro> filtros;
    private List<Mensagem> mensagens;

    public BancoDeMentira() {
        
        this.destinatarios = new ArrayList<>();

        Destinatario mateus = new Destinatario();
        mateus.setNome("Mateus");
        mateus.setTipo("RESIDENTE");
        mateus.setToken("iajsoidjaufhoefij");

        Destinatario osmar = new Destinatario();
        osmar.setNome("Osmar");
        osmar.setTipo("SERVIDOR");
        osmar.setToken("afdiojoifejoifjao");

        this.destinatarios.add(osmar);
        this.destinatarios.add(mateus);

    }

    public List<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public List<Filtro> getFiltros() {
        return filtros;
    }
    
    public void enviarMensagem() {
        
    }
}
