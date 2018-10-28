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

import com.websystemfinal.model.CursoModel;
import com.websystemfinal.service.CursoServiceInter;

@Path("/cursos")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class CursoFacade{

	// Sem uso dos Services
	/*@Inject // CDI (Injecao de dependencias)
	CursoDAO cursoDAO;

	@GET
	public List<CursoModel> getCursoes() {
		return cursoDAO.getCursoes();
	}*/
	
	@Inject
	private CursoServiceInter cursoServiceInter;
	
	@GET
	public List<CursoModel> getCursos () {
		return cursoServiceInter.getCursos();
	}
	
	@POST
	public CursoModel salvar(CursoModel cursoModel) {
		return cursoServiceInter.salvarCurso(cursoModel);
	}
	
	@PUT
	public void atualizar(CursoModel cursoModel) {
		cursoServiceInter.alterar(cursoModel);
	}
	
	@DELETE
	@Path("/{codigoCurso}")
	public void excluir (@PathParam("codigoCurso") Integer codigoCurso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setCodigo(codigoCurso);
		cursoServiceInter.excluir(cursoModel);
	}

}
