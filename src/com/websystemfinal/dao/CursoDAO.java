package com.websystemfinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.websystemfinal.model.CursoModel;

public class CursoDAO implements CursoDAOInter{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CursoModel salvarCurso(CursoModel cursoModel) {

		entityManager.persist(cursoModel);
		System.out.println("Persistiu");
		return cursoModel;
	}

	@Override
	public void alterar(CursoModel cursoModel) {

		CursoModel cursoModelMerge = entityManager.merge(cursoModel);
		entityManager.persist(cursoModelMerge);
	}

	@Override
	public void excluir(CursoModel cursoModel) {

		CursoModel cursoModelMerge = entityManager.merge(cursoModel);
		entityManager.remove(cursoModelMerge);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CursoModel> getCursos() {

		Query query = entityManager.createQuery("from CursoModel");
		return query.getResultList();
	}

	
	
}
