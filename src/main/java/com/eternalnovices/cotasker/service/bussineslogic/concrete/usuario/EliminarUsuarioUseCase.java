package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;


public class EliminarUsuarioUseCase implements UseCase<UsuarioDomain>{
	private DAOFactory factoria;
	
	
	public EliminarUsuarioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(UsuarioDomain domain) {
		validarExistenciaRegistro(domain.getIdUsuario());
		eliminar(domain.getIdUsuario());
	}
	
	private void eliminar(final UUID idUsuario) {
		getUsuarioDAO().eliminar(idUsuario);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000263);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000264);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	private final UsuarioDAO getUsuarioDAO() {
		return getFactoria().obtenerUsuarioDAO();
	}
	
	private void validarExistenciaRegistro(final UUID idUsuario) {
		final var resultado = getUsuarioDAO().consultarPorId(idUsuario);
		
		if(resultado.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000265);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
	


