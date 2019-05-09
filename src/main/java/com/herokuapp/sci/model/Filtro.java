package com.herokuapp.sci.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filtro implements Comparable<Filtro>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @ElementCollection(targetClass = Sexo.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="filtro_sexos", joinColumns = @JoinColumn(name = "filtro_id"))
    @Column
    private Set<Sexo> sexos;

    public Filtro() {
    }

    @Override
    public int compareTo(Filtro m) {
        return this.descricao.compareTo(m.getDescricao());
    }
}
