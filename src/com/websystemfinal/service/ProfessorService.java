package com.websystemfinal.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.websystemfinal.dao.ProfessorDAOInter;
import com.websystemfinal.model.ProfessorModel;

public class ProfessorService implements ProfessorServiceInter {

	@Inject // CDI (Injecao de dependencias)
	private ProfessorDAOInter professorDAOInterface;

	@Override
	@Transactional
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		return professorDAOInterface.salvarProfessor(professorModel);
	}

	@Override
	@Transactional
	public void alterar(ProfessorModel professorModel) {
		professorDAOInterface.alterar(professorModel);
	}

	@Override
	@Transactional
	public void excluir(ProfessorModel professorModel) {
		professorDAOInterface.excluir(professorModel);
	}

	@Override
	public List<ProfessorModel> getProfessores() {
		return professorDAOInterface.getProfessores();
	}

}
