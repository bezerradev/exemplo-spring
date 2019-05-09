package com.herokuapp.sci.view;

import com.herokuapp.sci.model.Filtro;
import com.herokuapp.sci.model.Sexo;
import com.herokuapp.sci.repository.FiltroRepository;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class FiltroMBean implements Serializable {

    @Getter
    @Setter
    private Filtro bean;

    @Getter
    @Setter
    private Filtro beanUpdate;
    
    
    @Getter
    @Setter
    private Set<Sexo> sexoTemp;

    @Inject
    FiltroRepository filtroRepository;

    public FiltroMBean() {
        String label = Sexo.FEMININO.getLabel();

        System.out.println(label);

        bean = new Filtro();

    }

    @PostConstruct
    private void insereBean() {
        beanUpdate = filtroRepository.findAll().get(0);
        sexoTemp = new TreeSet<>();
    }

    public void insert() {
        try {
            filtroRepository.save(bean);
            FacesContext.getCurrentInstance().addMessage("filtroForm",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:", "Filtro adicionado com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("filtroForm",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível adicionar o filtro."));
        }
        bean = new Filtro();
    }

    public void insertUpdate() {
        try {
            filtroRepository.save(beanUpdate);
            FacesContext.getCurrentInstance().addMessage("filtroForm",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:", "Filtro adicionado com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("filtroForm",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível adicionar o filtro."));
        }
    }

    public List<Filtro> getFiltros() {
        return filtroRepository.findAll();
    }

    public List<Sexo> getSexoValues() {
        return Arrays.asList(Sexo.values());
    }
    
    
//    public Set<Sexo> getSexoTemp() {
//    
//        sexoTemp = beanUpdate.getSexos();
//        
//        return sexoTemp;
//    }
//
//    public void SetSexoTemp(Set<Sexo> sexoTemp) {
//        beanUpdate.setSexos(sexoTemp);
//    }
}
