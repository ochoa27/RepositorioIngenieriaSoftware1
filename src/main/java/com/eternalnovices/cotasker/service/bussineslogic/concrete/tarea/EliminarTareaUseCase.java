package com.eternalnovices.cotasker.service.bussineslogic.concrete.tarea;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;


public class EliminarTareaUseCase implements UseCase<TareaDomain> {

	private DAOFactory factoria;
	
	public EliminarTareaUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(TareaDomain domain) {
		validarExistenciaRegistro(domain.getIdTarea());
		eliminar(domain.getIdTarea());
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getTareaDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000824);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private void eliminar(final UUID id) {
		getTareaDAO().eliminar(id);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000818);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000819);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final TareaDAO getTareaDAO() {
		return getFactoria().obtenerTareaDAO();
	}
	
}