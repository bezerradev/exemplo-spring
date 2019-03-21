/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.view;

import br.com.livraria.livrariaexemplo.banco.BancoDeMentira;
import br.com.livraria.livrariaexemplo.model.Destinatario;
import br.com.livraria.livrariaexemplo.model.Filtro;
import br.com.livraria.livrariaexemplo.model.Mensagem;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import org.springframework.stereotype.Component;

/**
 *
 * @author mocbezerra
 */
@Component
@ViewScoped
public class MensagemMBean implements Serializable {
    private String titulo;

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

    public boolean isResidente() {
        return residente;
    }

    public void setResidente(boolean residente) {
        this.residente = residente;
    }

    public boolean isServidor() {
        return servidor;
    }

    public void setServidor(boolean servidor) {
        this.servidor = servidor;
    }
    private String texto;
    private boolean residente;
    private boolean servidor;
    
    private static final long serialVersionUID = 1L;
    
    
    public List<Destinatario> getDestinatarios() {
        return (new BancoDeMentira()).getDestinatarios();
    }
    
   public void enviar() {
       Filtro f = new Filtro();
       f.setIsResidente(residente);
       f.setIsServidor(servidor);
       
       Mensagem m = new Mensagem();
       m.setTitulo(titulo);
       m.setTexto(texto);
       m.setFiltro(f);
       
       m.enviar();
   }
           
}
