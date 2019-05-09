/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.sci.model;

/**
 *
 * @author mocbezerra
 */
public enum Sexo {
    MASCULINO("Masculino"), FEMININO("Feminino");
    
    private final String label;
    
    Sexo(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
}
