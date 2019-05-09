package com.herokuapp.sci.model;

import java.io.Serializable;
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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mensagem implements Comparable<Mensagem>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String corpo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mensagem_destinatario", 
            joinColumns={
               @JoinColumn(name = "mensagem_id")}, 
            inverseJoinColumns={
                @JoinColumn(name = "destinatario_id")})
    private Set<Destinatario> destinatarios;

    public Mensagem() {
    }

    public Mensagem(String titulo, String corpo) {
        this.titulo = titulo;
        this.corpo = corpo;
    }

    @Override
    public int compareTo(Mensagem m) {
        return this.titulo.compareTo(m.getTitulo());
    }
}
