package com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto;

import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCaseFind;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.ProyectoEntityMapper;


public class ConsultarProyectoUseCase implements UseCaseFind<ProyectoDomain>{
	private DAOFactory factoria;
	
	
	
	public ConsultarProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public List<ProyectoDomain> execute(ProyectoDomain domain) {
		final var resultados  = getProyectoDAO().consultar(ProyectoEntityMapper.convertToEntity(domain));
		return ProyectoEntityMapper.convertToListDomain(resultados);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000268);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000269);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	private final ProyectoDAO getProyectoDAO() {
		return getFactoria().obtenerProyectoDAO();
	}
}
