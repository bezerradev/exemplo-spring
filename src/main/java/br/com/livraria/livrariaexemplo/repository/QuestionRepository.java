package br.com.livraria.livrariaexemplo.repository;


import br.com.livraria.livrariaexemplo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
