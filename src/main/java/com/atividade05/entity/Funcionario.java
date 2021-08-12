package com.atividade05.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Builder
@Table(name = "FUNCIONARIO")
@NamedQuery(
        name = "Funcionario.byDependentes",
        query = "from Funcionario f where f.qtdeDependentes =?1")
@NamedNativeQuery(
        name = "Funcionario.byNomeLike",
        query = "select * from Funcionario where nomeFuncionario like ?1",
        resultClass = Funcionario.class)

public class Funcionario extends AbstractPersistable<Long> {
    private String nomeFuncionario;
    private Integer qtdeDependentes;
    private Double salario;
    @ManyToOne
    private Departamento departamento;

}
