package com.eternalnovices.cotasker.service.facade.concrete.tarea;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.tarea.RegistrarTareaUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.tarea.RegistrarTareaValidator;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.dto.TareaDTO;
import com.eternalnovices.cotasker.service.facade.Facade;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.TareaDTOMapper;

public class RegistrarTareaFacade implements Facade<TareaDTO>{

	@Override
	public void execute(final TareaDTO dto) {
		final TareaDomain domain = TareaDTOMapper.convertToDomain(dto);
		RegistrarTareaValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new RegistrarTareaUseCase(daofactory);
			useCase.execute(domain);
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException exception) {
			daofactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000812);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000813);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
	}

}
