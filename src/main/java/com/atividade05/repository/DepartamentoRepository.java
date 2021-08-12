package com.atividade05.repository;

import com.atividade05.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade05.entity.Departamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByNomeDepartamento(String nomeDepartamento);
    Departamento findFirstByOrderByNomeDepartamentoAsc();


}
