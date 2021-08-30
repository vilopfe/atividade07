package com.atividade07.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "FUNCIONARIO")
@NamedQuery(
        name = "Funcionario.byDependentes",
        query = "from Funcionario f where f.qtdeDependentes =?1")
@NamedNativeQuery(
        name = "findByNomeFuncionarioContaining",
        query = "SELECT * FROM FUNCIONARIO WHERE NOME_FUNCIONARIO LIKE ?1",
        resultClass = Funcionario.class)
@NamedStoredProcedureQuery(
        name = "Funcionario.aumento",
        procedureName = "PROC_AUMENTO",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "arg",
                        type = Integer.class
                ),
                @StoredProcedureParameter(
                        mode = ParameterMode.OUT,
                        name = "res",
                        type = Integer.class
                )
        }
        )/*
@NamedStoredProcedureQuery(
        name ="",
        procedureName = "",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "arg",
                        type = String.class
                ),
                @StoredProcedureParameter(
                        mode = ParameterMode.OUT,
                        name = "res",
                        type = Integer.class
                )
        }
)*/
public class Funcionario extends AbstractPersistable<Long> {
    private String nomeFuncionario;
    private Integer qtdeDependentes;
    private Double salario;
    @ManyToOne
    private Departamento departamento;

}
