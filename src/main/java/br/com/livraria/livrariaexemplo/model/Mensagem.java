/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.model;

import java.util.List;

/**
 *
 * @author mocbezerra
 */
public class Mensagem {

    private String titulo;

    private String texto;

    private List<Destinatario> destinatarios;
    
    private Filtro filtro;

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Destinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public List<Destinatario> enviar() {
        List<Destinatario> destinatariosFinais = this.filtro.getDestinatariosFinais();
        
        for (Destinatario d : destinatariosFinais) {
            this.enviaNotificacao(d.getNome(), this.titulo, this.texto);
        }
        return destinatariosFinais;
    }

    public void enviaNotificacao(String nome, String titulo, String texto) {
        System.out.println("Nome: " + nome + " Titulo: " + titulo + " Texto: " + texto + ".");
    }
}
