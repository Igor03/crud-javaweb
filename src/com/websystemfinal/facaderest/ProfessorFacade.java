package com.websystemfinal.facaderest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.websystemfinal.model.ProfessorModel;
import com.websystemfinal.service.ProfessorServiceInter;

@Path("/professores")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorFacade{

	// Sem uso dos Services
	/*@Inject // CDI (Injecao de dependencias)
	ProfessorDAO professorDAO;

	@GET
	public List<ProfessorModel> getProfessores() {
		return professorDAO.getProfessores();
	}*/
	
	@Inject
	private ProfessorServiceInter professorServiceInter;
	
	@GET
	public List<ProfessorModel> getProfessores () {
		return professorServiceInter.getProfessores();
	}
	
	@POST
	public ProfessorModel salvar(ProfessorModel professorModel) {
		return professorServiceInter.salvarProfessor(professorModel);
	}
	
	@PUT
	public void atualizar(ProfessorModel professorModel) {
		professorServiceInter.alterar(professorModel);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void excluir (@PathParam("codigoProfessor") Integer codigoProfessor) {
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setCodigo(codigoProfessor);
		professorServiceInter.excluir(professorModel);
	}

}
