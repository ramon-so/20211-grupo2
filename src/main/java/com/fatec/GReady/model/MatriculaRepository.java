package com.fatec.GReady.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long> {
	public Matricula findByCpf(@Param("cpf") String cpf);
}
