/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author mocbezerra
 */
@Entity
@Table(name = "mensagens")
public class Mensagem extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String titulo;

    private String conteudo;
    
    
    //private List<Destinatario> destinatarios;
    
    private Filtro filtro;
    
    // contrutor vazio
    public Mensagem(){
    }
    
    // contrutor 
    public Mensagem(String titulo, String conteudo  ){
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    
    // Many-to-many relationship
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "mensagem_destinatarios",
            joinColumns = {
                @JoinColumn(name = "mensagem_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "destinatario_id")})
    private Set<Destinatario> destinatarios = new HashSet<>();
    
    
    
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
        public Set<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatariso(Set<Destinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }
    
    public List<Destinatario> enviar() {
        List<Destinatario> destinatariosFinais = this.filtro.getDestinatariosFinais();
        
        for (Destinatario d : destinatariosFinais) {
            this.enviaNotificacao(d.getNome(), this.getTitulo(), this.getConteudo());
        }
        return destinatariosFinais;
    }

    public void enviaNotificacao(String nome, String titulo, String conteudo) {
        System.out.println("Nome: " + nome + " Titulo: " + titulo + " conteudo: " + conteudo + ".");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
