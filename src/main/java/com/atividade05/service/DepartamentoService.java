package com.atividade05.service;

import java.util.List;
import java.util.Optional;

import com.atividade05.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade05.entity.Departamento;
import com.atividade05.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;

	public void salvar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	public Optional<Departamento> buscaPorId(Long id) {
		return departamentoRepository.findById(id);
	}

	public List<Departamento> buscarTodos() {
		return departamentoRepository.findAll();
	}

	public List<Departamento> buscarPorNome(String nomeDepartamento) {return departamentoRepository.findByNomeDepartamento(nomeDepartamento); }

	public Departamento buscarPrimeiroDepartamento() {return departamentoRepository.findFirstByOrderByNomeDepartamentoAsc();}


}
