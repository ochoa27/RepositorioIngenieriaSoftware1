package com.eternalnovices.cotasker.service.bussineslogic.concrete.tarea;

import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCaseFind;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.TareaEntityMapper;



public class ConsultarTareaUseCase implements UseCaseFind<TareaDomain>{

	private DAOFactory factoria;
	
	public ConsultarTareaUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<TareaDomain> execute(TareaDomain domain) {
		final var resultadosTmp = getTareaDAO().consultar(TareaEntityMapper.convertToEntity(domain));
		return TareaEntityMapper.convertToListDomain(resultadosTmp);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000805);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000806);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final TareaDAO getTareaDAO() {
		return getFactoria().obtenerTareaDAO();
	}

}
