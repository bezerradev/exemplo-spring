/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mocbezerra
 */

@Entity
@Table(name = "destinatarios")
public class Destinatario extends AuditModel {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nome;
    
    @NotNull
    private String token;
    
    private String tipo;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "destinatarios")
    private Set<Mensagem> mensagens = new HashSet<>();

    public Destinatario() {

    }

    public Destinatario(String nome, String token) {
        this.nome = nome;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Set<Mensagem> getMensagens() {
        return this.mensagens;
    }

    public void setMensagens(Set<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

}
