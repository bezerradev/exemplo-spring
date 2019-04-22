package br.com.sci.view;

import javax.annotation.ManagedBean;

@ManagedBean
public class HelloMBean {
  
    public String getMensagemInicial() {
        return "Alô mundo Loko! ";
    }
}
