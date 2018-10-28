package com.websystemfinal.dao;

import java.util.List;

import com.websystemfinal.model.CursoModel;

public interface CursoDAOInter {

	CursoModel salvarCurso(CursoModel cursoModel);

	void alterar(CursoModel cursoModel);

	void excluir(CursoModel cursoModel);

	List<CursoModel> getCursos();
	
}
