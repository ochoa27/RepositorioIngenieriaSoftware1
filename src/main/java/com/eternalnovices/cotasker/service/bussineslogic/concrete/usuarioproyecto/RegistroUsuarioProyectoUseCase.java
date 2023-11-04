package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuarioproyecto;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.UsuarioProyectoEntityMapper;

public class RegistroUsuarioProyectoUseCase implements UseCase<UsuarioProyectoDomain> {
	private DAOFactory factoria;
	
	
	public RegistroUsuarioProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(UsuarioProyectoDomain domain) {
		validarExistenciaUsuario(domain.getUsuario());
		validarExistenciaProyecto(domain.getProyecto());
		validarNoExistenciaRegistro(domain);
		registrar(domain);
	}
	
	private void validarNoExistenciaRegistro(final UsuarioProyectoDomain domain) {
		final var resultados = getUsuarioProyectoDAO().consultarPorId(domain.getProyecto().getIdProyecto(), domain.getUsuario().getIdUsuario());
				
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000330);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private void validarExistenciaUsuario(final UsuarioDomain domain) {
		final var resultados = getUsuarioDAO().consultarPorId(domain.getIdUsuario());
				
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000349);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private void validarExistenciaProyecto(final ProyectoDomain domain) {
		final var resultados = getProyectoDAO().consultarPorId(domain.getIdProyecto());
				
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000350);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000351);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000331);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000332);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria=factoria;
	}
	
	private void registrar(final UsuarioProyectoDomain domain) {
		getUsuarioProyectoDAO().crear(UsuarioProyectoEntityMapper.convertToEntity(domain));
	}
	
	private final UsuarioProyectoDAO getUsuarioProyectoDAO() {
		return getFactoria().obtenerUsuarioProyectoDAO();
	}

	private final ProyectoDAO getProyectoDAO() {
		return getFactoria().obtenerProyectoDAO();
	}
	
	private final UsuarioDAO getUsuarioDAO() {
		return getFactoria().obtenerUsuarioDAO();
	}
}
