package com.websystemfinal.service;

import java.util.List;

import com.websystemfinal.model.CursoModel;

public interface CursoServiceInter {

	CursoModel salvarCurso(CursoModel cursoModel);

	void alterar(CursoModel cursoModel);

	void excluir(CursoModel cursoModel);

	List<CursoModel> getCursos();

}
