package com.websystemfinal.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.websystemfinal.dao.CursoDAOInter;
import com.websystemfinal.model.CursoModel;

public class CursoService implements CursoServiceInter {

	@Inject // CDI (Injecao de dependencias)
	private CursoDAOInter cursoDAOInterface;

	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel cursoModel) {
		return cursoDAOInterface.salvarCurso(cursoModel);
	}

	@Override
	@Transactional
	public void alterar(CursoModel cursoModel) {
		cursoDAOInterface.alterar(cursoModel);
	}

	@Override
	@Transactional
	public void excluir(CursoModel cursoModel) {
		cursoDAOInterface.excluir(cursoModel);
	}

	@Override
	public List<CursoModel> getCursos() {
		return cursoDAOInterface.getCursos();
	}

}
