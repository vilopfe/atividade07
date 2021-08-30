package com.atividade07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade07.entity.Departamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByNomeDepartamento(String nomeDepartamento);
    Departamento findFirstByOrderByNomeDepartamentoAsc();


}
