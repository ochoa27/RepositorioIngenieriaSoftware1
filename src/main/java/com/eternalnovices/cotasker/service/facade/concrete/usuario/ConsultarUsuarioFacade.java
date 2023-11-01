package com.eternalnovices.cotasker.service.facade.concrete.usuario;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario.ConsultarUsuarioUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuario.ConsultarUsuarioValidator;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;
import com.eternalnovices.cotasker.service.facade.FacadeFind;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.UsuarioDTOMapper;

public class ConsultarUsuarioFacade implements FacadeFind<UsuarioDTO>{

	@Override
	public List<UsuarioDTO> execute(final UsuarioDTO dto) {
		final UsuarioDomain domain = UsuarioDTOMapper.convertToDomain(dto);
		ConsultarUsuarioValidator.ejecutar(domain);
		List<UsuarioDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarUsuarioUseCase(daofactory);
			resultados = UsuarioDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException exception) {
			daofactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000831);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000832);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}
