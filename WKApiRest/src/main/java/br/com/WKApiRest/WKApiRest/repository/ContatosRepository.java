package br.com.WKApiRest.WKApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.WKApiRest.WKApiRest.model.Contatos;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {

}
