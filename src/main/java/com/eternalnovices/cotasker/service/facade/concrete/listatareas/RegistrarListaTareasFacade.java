package com.eternalnovices.cotasker.service.facade.concrete.listatareas;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.listatareas.RegistrarListaTareasUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.listatareas.RegistrarListaTareasValidator;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.dto.ListaTareasDTO;
import com.eternalnovices.cotasker.service.facade.Facade;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ListaTareasDTOMapper;


public class RegistrarListaTareasFacade implements Facade<ListaTareasDTO>{

	@Override
	public void execute(final ListaTareasDTO dto) {
		final ListaTareasDomain domain = ListaTareasDTOMapper.convertToDomain(dto);
		RegistrarListaTareasValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new RegistrarListaTareasUseCase(daofactory);
			useCase.execute(domain);
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException exception) {
			daofactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000815);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000816);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
	}

}
