/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.sci.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author italo
 */
@Entity
@Getter
@Setter
public class Destinatario implements Comparable<Destinatario>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 12)
    private String tituloEleitor;

    @Column(nullable = false)
    private String token;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mensagem_destinatario", 
            joinColumns={
               @JoinColumn(name = "destinatario_id")}, 
            inverseJoinColumns={
                @JoinColumn(name = "mensagem_id")})
    private Set<Mensagem> mensagens;
    
    public Destinatario() {
        this.token = Destinatario.gerarToken(10);
    }

    public Destinatario(String nome, String token) {
        this.nome = nome;
        this.token = Destinatario.gerarToken(10);
    }

    public static String gerarToken(int tamanhoToken) {
        String possibilidadesAlfaNumericas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(tamanhoToken);

        for (int i = 0; i < tamanhoToken; i++) {
            int index = (int) (possibilidadesAlfaNumericas.length()
                    * Math.random());

            sb.append(possibilidadesAlfaNumericas.charAt(index));
        }

        return sb.toString();
    }

    @Override
    public int compareTo(Destinatario d) {
        return this.nome.compareTo(d.getNome());
    }
}
