package com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto;


import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.UsuarioProyectoDTO;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ProyectoDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.UsuarioProyectoDTOMapper;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.UsuarioProyectoEntityMapper;

public class EliminarProyectoUseCase implements UseCase<ProyectoDomain> {
	private DAOFactory factoria; 
	
	
	public EliminarProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	@Override
	public void execute(ProyectoDomain domain) {
		validarExistenciaRegistro(domain.getIdProyecto());
		validarNoExistenciaRelacion(domain.getIdProyecto());
		eliminar(domain.getIdProyecto());
	}
	
	private void eliminar(final UUID idProyecto) {
		getProyectoDAO().eliminar(idProyecto);
		
	}
	
	private void validarNoExistenciaRelacion(final UUID idProyecto) {
		final var proyecto=ProyectoDomain.crear(idProyecto, null, null, null);
		final var usuarioProyecto=UsuarioProyectoDTOMapper.convertToDomain(
				UsuarioProyectoDTO.crear().setProyecto(ProyectoDTOMapper.convertToDTO(proyecto)));
		final var resultados= getUsuarioProyectoDAO().consultar(UsuarioProyectoEntityMapper.convertToEntity(usuarioProyecto));
		if(!resultados.isEmpty()) {
			final var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000336);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	
	private void validarExistenciaRegistro(final UUID idProyecto) {
		final var resultados = getProyectoDAO().consultarPorId(idProyecto);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000337);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
		
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000334);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000335);
			throw ServiceCoTaskerException.crear(mensajeUsuario,mensajeTecnico);
			}
		this.factoria=factoria;
	}
	
	private final ProyectoDAO getProyectoDAO() {
		return getFactoria().obtenerProyectoDAO();
	}
	
	private final UsuarioProyectoDAO getUsuarioProyectoDAO() {
		return getFactoria().obtenerUsuarioProyectoDAO();
	}
	
	
	
}
