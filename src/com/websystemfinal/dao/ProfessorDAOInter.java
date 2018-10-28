package com.websystemfinal.dao;

import java.util.List;

import com.websystemfinal.model.ProfessorModel;

// DAO: Data Object Access
public interface ProfessorDAOInter {

	// Estes s�o os m�todos
	
	ProfessorModel salvarProfessor(ProfessorModel professorModel);

	void alterar(ProfessorModel professorModel);

	void excluir(ProfessorModel professorModel);

	List<ProfessorModel> getProfessores();

}
