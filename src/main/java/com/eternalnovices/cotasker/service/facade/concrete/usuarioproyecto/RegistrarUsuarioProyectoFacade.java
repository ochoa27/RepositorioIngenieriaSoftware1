package com.eternalnovices.cotasker.service.facade.concrete.usuarioproyecto;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.usuarioproyecto.RegistroUsuarioProyectoUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuarioproyecto.RegistarUsuarioProyectoValidator;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;
import com.eternalnovices.cotasker.service.dto.UsuarioProyectoDTO;
import com.eternalnovices.cotasker.service.facade.Facade;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.UsuarioProyectoDTOMapper;

public class RegistrarUsuarioProyectoFacade implements Facade<UsuarioProyectoDTO>{

	@Override
	public void execute(UsuarioProyectoDTO dto) {
		final UsuarioProyectoDomain domain = UsuarioProyectoDTOMapper.convertToDomain(dto);
		RegistarUsuarioProyectoValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new RegistroUsuarioProyectoUseCase(daofactory);
			useCase.execute(domain);
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException exception) {
			daofactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000343);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000344);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
	}

}
