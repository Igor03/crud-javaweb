package com.websystemfinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.websystemfinal.model.ProfessorModel;

public class ProfessorDAO implements ProfessorDAOInter {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {

		entityManager.persist(professorModel);
		System.out.println("Persistiu");
		return professorModel;
	}

	@Override
	public void alterar(ProfessorModel professorModel) {

		ProfessorModel professorModelMerge = entityManager.merge(professorModel);
		entityManager.persist(professorModelMerge);
	}

	@Override
	public void excluir(ProfessorModel professorModel) {

		ProfessorModel professorModelMerge = entityManager.merge(professorModel);
		entityManager.remove(professorModelMerge);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorModel> getProfessores() {

		Query query = entityManager.createQuery("from ProfessorModel");
		return query.getResultList();
	}

}
