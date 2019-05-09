package com.herokuapp.sci.view;

import com.herokuapp.sci.model.Destinatario;
import com.herokuapp.sci.repository.DestinatarioRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class DestinatarioMBean implements Serializable {
    
    @Getter
    @Setter
    private Destinatario bean;
 
    @Inject
    DestinatarioRepository destinatarioRepository;
    
    public DestinatarioMBean() {
        bean = new Destinatario();
    }
    
    public void insert() {
        try {
            destinatarioRepository.save(bean);
            FacesContext.getCurrentInstance().addMessage("destinatarioForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:", "Destinatário adicionado com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("destinatarioForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível adicionar o destinatário."));        
        }
        bean = new Destinatario();
    }
    
    public List<Destinatario> getDestinatarios() {
        return destinatarioRepository.findAll();
    }
}
