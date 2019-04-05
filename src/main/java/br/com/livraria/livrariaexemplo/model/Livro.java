package br.com.livraria.livrariaexemplo.model;

import javax.faces.view.ViewScoped;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class Livro implements Compravel {
    
    Livro (int preco){
        this.preco = preco;
    }
    
    Livro (){
        this.preco = preco;
    }

    @Override
    public int informarPreco() {
        this.preco = 10;
        return this.preco;
    }
    
    public void setPreco(int preco) {
        this.preco = preco;
    }
    private int preco;
        
    public int getPreco() {
        return this.preco;
    }
    
}
