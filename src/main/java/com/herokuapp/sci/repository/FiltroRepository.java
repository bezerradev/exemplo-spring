package com.herokuapp.sci.repository;

import com.herokuapp.sci.model.Filtro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiltroRepository extends JpaRepository<Filtro, Long> {
    
}
