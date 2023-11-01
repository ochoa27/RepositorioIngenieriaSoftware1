package com.eternalnovices.cotasker.service.bussineslogic.concrete.listatareas;

import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCaseFind;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.ListaTareasEntityMapper;


public class ConsultarListaTareasUseCase implements UseCaseFind<ListaTareasDomain>{

	private DAOFactory factoria;
	
	public ConsultarListaTareasUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<ListaTareasDomain> execute(ListaTareasDomain domain) {
		final var resultadosTmp = getListaTareasDAO().consultar(ListaTareasEntityMapper.convertToEntity(domain));
		return ListaTareasEntityMapper.convertToListDomain(resultadosTmp);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000801);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000802);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ListaTareaDAO getListaTareasDAO() {
		return getFactoria().obtenerListaTareaDAO();
	}

}
