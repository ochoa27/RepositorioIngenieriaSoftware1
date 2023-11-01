package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.support.BooleanDomain;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.UsuarioEntityMapper;



public class ModificarUsuarioUseCase implements UseCase<UsuarioDomain>{
	private DAOFactory factoria;
	
	
	public ModificarUsuarioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(UsuarioDomain domain) {
		validarExistenciaId(domain.getIdUsuario());
		validarNoExistenciaCorreoElectronico(domain.getCorreoElectronico());
		actualizar(domain);
		
		
	}
	
	private final void validarExistenciaId(final UUID id) {
		final var resultados = getUsuarioDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000828);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaCorreoElectronico(final String correoElectronico) {
		final var domain = UsuarioDomain.crear(null, null, null, correoElectronico, BooleanDomain.crear(false, true), null);
		final var entity = UsuarioEntityMapper.convertToEntity(domain);
		final var resultados = getUsuarioDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000829);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}

	private void actualizar(final UsuarioDomain domain) {
		getUsuarioDAO().modificar(UsuarioEntityMapper.convertToEntity(domain));
	}
	
	
	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000266);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000267);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	private final UsuarioDAO getUsuarioDAO() {
		return getFactoria().obtenerUsuarioDAO();
	}
}
	


