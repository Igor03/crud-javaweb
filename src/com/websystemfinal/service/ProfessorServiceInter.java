package com.websystemfinal.service;

import java.util.List;

import com.websystemfinal.model.ProfessorModel;

public interface ProfessorServiceInter {

	ProfessorModel salvarProfessor(ProfessorModel professorModel);

	void alterar(ProfessorModel professorModel);

	void excluir(ProfessorModel professorModel);

	List<ProfessorModel> getProfessores();

}
