package com.atividade07;

import java.util.Optional;

import com.atividade07.entity.Funcionario;
import com.atividade07.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atividade07.entity.Departamento;
import com.atividade07.service.DepartamentoService;

@SpringBootApplication
public class Atividade07Application {
	
	private static final Logger log = LoggerFactory.getLogger(Atividade07Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Atividade07Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService, FuncionarioService funcionarioService) {
		return (args) -> {
			Departamento dep1 = Departamento.builder()
					.nomeDepartamento("TI")
					.build();
			Departamento dep2 = Departamento.builder()
					.nomeDepartamento("Financeiro")
					.build();

			departamentoService.salvar(dep1);
			departamentoService.salvar(dep2);
			
			// retornando todos os departamentos
			log.info("Departamentos encontrados com findAll():");
			log.info("-------------------------------");
			for (Departamento departamento : departamentoService.buscarTodos()) {
				log.info(departamento.getNomeDepartamento());
			}
			log.info("");

			//retornando dept por nome
			log.info("Departamentos encontrados com byNomeDepartamento(TI):");
			log.info("-------------------------------");
			for (Departamento departamento : departamentoService.buscarPorNome("TI")){
				log.info(departamento.toString());
			}
			
			Funcionario fun1 = Funcionario.builder()
					.nomeFuncionario("vinicius")
					.qtdeDependentes(0)
					.salario(10000.00)
					.departamento(dep1)
					.build();
			Funcionario fun2 = Funcionario.builder()
			        .nomeFuncionario("fernandez")
					.qtdeDependentes(2)
					.salario(1000.00)
					.departamento(dep2)
					.build();
			Funcionario fun3 = Funcionario.builder()
					.nomeFuncionario("lopes")
					.qtdeDependentes(3)
					.salario(2000.00)
					.departamento(dep1)
					.build();

			funcionarioService.salvar(fun1);
			funcionarioService.salvar(fun2);
			funcionarioService.salvar(fun3);

			//retornando funcionario by all
			log.info("Funcionarios encontrados com findAll():");
			log.info("-------------------------------");
			for (Funcionario funcionario : funcionarioService.buscarTodos()) {
				log.info(funcionario.toString());
			}
			log.info("");

			//retornando funcionario by name
			log.info("Funcionarios encontrados by name vinicius");
			log.info("--------------------------------");
			for(Funcionario funcionario : funcionarioService.buscarPorNome("vinicius")){
				log.info(funcionario.toString());
			}
			log.info("");

			//retornando funcionario by dependentes
			log.info("Funcionarios encontrados by dependentes =1");
			log.info("---------------------------------");
			for (Funcionario funcionario : funcionarioService.buscarPorQtdeDependentes(1)){
				log.info(funcionario.toString());
			}
			log.info("");


			//findByDepartamento(String departamento);
			for (Funcionario funcionario : funcionarioService.buscarPorDepartamento(departamentoService.buscarPorNome("TI").get(0))){
				log.info("Listar todos os funcionários de um determinado departamento por JPQL via @Query");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findFirstByDepartamentoAsc(String departamento);
			Departamento departamento2 = departamentoService.buscarPrimeiroDepartamento();
			log.info("Listar o primeiro departamento cadastrado");
			log.info("--------------------------------");
			log.info(departamento2.toString());

			log.info("");


			//findFirstByOrderBySalarioDesc();
			for(Funcionario funcionario : funcionarioService.buscarPorSalarioMaior()) {
				log.info("Listar o primeiro funcionário que tem o maior salário");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findFirst3ByOrderBySalarioAsc();
			for(Funcionario funcionario : funcionarioService.buscarPor3SalarioMaior()) {
				log.info("Listar os 3 (três) primeiros funcionários que tem os maiores salários.");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findByFuncionarioSemDependenteByNomeAsc();
			for(Funcionario funcionario : funcionarioService.buscarPorSemDependente()) {
				log.info("Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL\n" +
						"via @Query.");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findBySalarioGreater(Double salario);
			for (Funcionario funcionario : funcionarioService.buscarPorSalarioMaiorQue(1000.00)) {
				log.info("Listar os funcionários que tem salário maior que um determinado valor por JPQL sobrescrevendo palavras-chaves @Query.");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findBySalario(Double salario);
			for (Funcionario funcionario : funcionarioService.buscarPorSalarioIgual(1000.00)) {
				log.info("Listar os funcionários que tem salário maior que um determinado valor por @Query\n" +
						"com native query.\n");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findByDependentes(Integer qtdeDependentes);
			for (Funcionario funcionario : funcionarioService.buscarPorDependentesIgual(1)) {
				log.info("Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma\n" +
						"determinada quantidade de dependentes por @NamedQuery.\n");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//findByNomeLike(String caracter);
			for (Funcionario funcionario : funcionarioService.buscarPorNomeCom("vinicius")) {
				log.info("Alterar a classe Funcionario e criar uma consulta para listar os funcionários que\n" +
						"contenham em qualquer parte do seu nome um determinado nome por\n" +
						"@NamedNativeQuery.");
				log.info("--------------------------------");
				log.info(funcionario.toString());
			}
			log.info("");

			//retornando funcionario por ID
			Optional<Funcionario> funcionario = funcionarioService.buscaPorId(1L);
			log.info("Funcionario encontrado com findById(1L):");
			log.info("--------------------------------");
			log.info(funcionario.toString());
			log.info("");

			// retornando um endereço pelo ID
			Optional<Departamento> departamento = departamentoService.buscaPorId(1L);
			log.info("Departamento encontrado com findById(1L):");
			log.info("--------------------------------");
			log.info(departamento.toString());
			log.info("");

			//atualiza salario
			funcionarioService.atualizaSalario(1);
		};
	}
}
