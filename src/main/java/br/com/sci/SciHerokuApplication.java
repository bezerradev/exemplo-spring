package br.com.sci;

import br.com.sci.model.Destinatario;
import br.com.sci.model.Mensagem;
import br.com.sci.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SciHerokuApplication implements CommandLineRunner {
    
        @Autowired
        MensagemRepository mensagemRepositori;

	public static void main(String[] args) {
		SpringApplication.run(SciHerokuApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Mensagem m = new Mensagem("titulo4", "conteudo4");
        Destinatario d1 = new Destinatario("Maria5", "t5");
        Destinatario d2 = new Destinatario("Maria6", "t6");
        m.addDestinatario(d1);
        m.addDestinatario(d2);
        
        mensagemRepositori.save(m);
    }
}
