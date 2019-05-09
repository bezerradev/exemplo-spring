package com.herokuapp.sci.repository;

import com.herokuapp.sci.model.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {
    
}
