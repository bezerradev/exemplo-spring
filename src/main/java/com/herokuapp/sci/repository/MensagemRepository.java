package com.herokuapp.sci.repository;

import com.herokuapp.sci.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
}
