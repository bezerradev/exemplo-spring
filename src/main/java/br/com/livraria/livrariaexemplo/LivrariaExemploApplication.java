package br.com.livraria.livrariaexemplo;

import br.com.livraria.livrariaexemplo.model.Destinatario;
import br.com.livraria.livrariaexemplo.model.Mensagem;
import br.com.livraria.livrariaexemplo.repository.DestinatarioRepository;
import br.com.livraria.livrariaexemplo.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LivrariaExemploApplication implements CommandLineRunner {
    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private DestinatarioRepository destinatarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaExemploApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // Cleanup the tables
        mensagemRepository.deleteAllInBatch();
        destinatarioRepository.deleteAllInBatch();

        // =======================================
        // Create a Post
        Mensagem mensagem = new Mensagem("Titulo1", "Conteudo 1");

        // Create two tags
        Destinatario d1 = new Destinatario("Nome1", "token1");
        Destinatario  d2 = new Destinatario("Nome2", "token2");

        // Add tag references in the post
        mensagem.getDestinatarios().add(d1);
        mensagem.getDestinatarios().add(d2);

        // Add post reference in the tags
        d1.getMensagens().add(mensagem);
        d2.getMensagens().add(mensagem);

        mensagemRepository.save(mensagem);

        // =======================================
    }

}
