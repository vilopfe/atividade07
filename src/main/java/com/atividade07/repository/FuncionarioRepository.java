package com.atividade07.repository;

import com.atividade07.entity.Departamento;
import com.atividade07.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    List<Funcionario> findByNomeFuncionario(String nomeFuncionario);
    List<Funcionario> findByQtdeDependentes(Integer qtdeDependentes);
    List<Funcionario> findByDepartamento(Departamento departamento);
    List<Funcionario> findFirstByOrderBySalarioDesc();
    List<Funcionario> findFirst3ByOrderBySalarioDesc();
    @Query("Select f from Funcionario f where qtdeDependentes = 0 order by nomeFuncionario")
    List<Funcionario> findByFuncionarioSemDependenteByNomeAsc();
    @Query("select f from Funcionario f where f.salario > ?1")
    List<Funcionario> findBySalarioGreater(Double salario);
    @Query(value = "select * from Funcionario where salario = ?1", nativeQuery = true)
    List<Funcionario> findBySalario(Double salario);
    @Query(name="Funcionario.byDependentes")
    List<Funcionario> findByDependentes(Integer qtdeDependentes);
    @Query(name="findByNomeFuncionarioContaining")
    List<Funcionario> findByNomeFuncionarioContaining(String caracter);
    //@Procedure("proc_aumento")
    @Procedure("Funcionario.aumento")
    String procedureAumento(Integer valor);
    @Procedure
    String proc_aumento(Integer valor);



}
