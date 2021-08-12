package com.atividade05.service;

import com.atividade05.entity.Departamento;
import com.atividade05.entity.Funcionario;
import com.atividade05.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository ;

    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscaPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> buscarPorNome(String nomeFuncionario) {return funcionarioRepository.findByNomeFuncionario(nomeFuncionario); }

    public List<Funcionario> buscarPorQtdeDependentes(Integer qtdeDependentes) {return funcionarioRepository.findByQtdeDependentes(qtdeDependentes); }

    public List<Funcionario> buscarPorDepartamento(Departamento departamento) {return funcionarioRepository.findByDepartamento(departamento); };

    public List<Funcionario> buscarPorSalarioMaior() {return funcionarioRepository.findFirstByOrderBySalarioDesc();}
    public List<Funcionario> buscarPor3SalarioMaior() {return funcionarioRepository.findFirst3ByOrderBySalarioDesc();}
    public List<Funcionario> buscarPorSemDependente() {return funcionarioRepository.findByFuncionarioSemDependenteByNomeAsc();}
    public List<Funcionario> buscarPorSalarioMaiorQue(Double salario) {return funcionarioRepository.findBySalarioGreater(salario);}
    public List<Funcionario> buscarPorSalarioIgual(Double salario) {return funcionarioRepository.findBySalario(salario);}
    public List<Funcionario> buscarPorDependentesIgual(Integer qtdeDependentes) {return funcionarioRepository.findByDependentes(qtdeDependentes);}
    public List<Funcionario> buscarPorNomeCom(String caracter) {return funcionarioRepository.findByNomeFuncionarioContaining(caracter);}

}

