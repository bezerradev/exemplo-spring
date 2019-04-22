/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.livrariaexemplo.repository;

import br.com.livraria.livrariaexemplo.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author italo
 */

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
}
