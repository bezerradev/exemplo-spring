/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.model;

import br.com.livraria.livrariaexemplo.banco.BancoDeMentira;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mocbezerra
 */
public class Filtro {

    private boolean isResidente;
    private boolean isServidor;

    public boolean isIsResidente() {
        return isResidente;
    }

    public void setIsResidente(boolean isResidente) {
        this.isResidente = isResidente;
    }

    public boolean isIsServidor() {
        return isServidor;
    }

    public void setIsServidor(boolean isServidor) {
        this.isServidor = isServidor;
    }

    public List<Destinatario> getDestinatariosFinais() {
        List<Destinatario> destinatarios = (new BancoDeMentira()).getDestinatarios();
        List<Destinatario> destinatariosFinais = new ArrayList<>();

        for (Destinatario d : destinatarios) {
            if (d.getTipo().equals("RESIDENTE") == this.isResidente) {
                destinatariosFinais.add(d);
            } else if (d.getTipo().equals("SERVIDOR") == this.isServidor) {
                destinatariosFinais.add(d);
            }
        }

        return destinatariosFinais;
    }
}
