package com.eternalnovices.cotasker.service.facade.concrete.usuario;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario.ModificarUsuarioUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuario.ModificarUsuarioValidator;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;
import com.eternalnovices.cotasker.service.facade.Facade;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.UsuarioDTOMapper;

public final class ModificarUsuarioFacade implements Facade<UsuarioDTO>{

	@Override
	public void execute(final UsuarioDTO dto) {
		final UsuarioDomain domain = UsuarioDTOMapper.convertToDomain(dto);
		ModificarUsuarioValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ModificarUsuarioUseCase(daofactory);
			useCase.execute(domain);
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000837);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000838);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
	}
}
