package com.herokuapp.sci.view;

import com.herokuapp.sci.model.Destinatario;
import com.herokuapp.sci.model.Mensagem;
import com.herokuapp.sci.repository.MensagemRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class MensagemMBean implements Serializable{

    @Getter
    @Setter
    private Mensagem bean;

    @Getter
    @Setter
    private List<Destinatario> destinatariosSelecionados;

    @Inject
    MensagemRepository mensagemRepository;

    public MensagemMBean() {
        bean = new Mensagem();
        destinatariosSelecionados = new ArrayList<>();
    }

    public void insert() {
        
        bean.setDestinatarios(new TreeSet<>(destinatariosSelecionados));
        
        mensagemRepository.save(bean);

        bean = new Mensagem();
    }

    public List<Mensagem> getMensagens() {
        return mensagemRepository.findAll();
    }
}
