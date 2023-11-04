package com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto;

import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.service.bussineslogic.UseCaseId;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.FechasDTOMapper;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.ProyectoEntityMapper;


public class RegistrarProyectoUseCase implements UseCaseId<ProyectoDomain, UUID> {
	private DAOFactory factoria;
	
	public RegistrarProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public UUID execute(ProyectoDomain domain, UUID id) {
		validarExistenciaUsuario(id);
		validarNoExistenciaMismoNombre(domain.getNombre(), id);
		domain = obtenerIdentificadorProyecto(domain);
		getProyectoDAO().crear(ProyectoEntityMapper.convertToEntity(domain));
		return domain.getIdProyecto();
	}
	
	private final ProyectoDomain obtenerIdentificadorProyecto(final ProyectoDomain domain) {
		Optional<ProyectoEntity> optional;
		UUID uuid;
		do {
			uuid=UtilUUID.generarRandomUUID();
			optional=getProyectoDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		return ProyectoDomain.crear(uuid, domain.getNombre(), domain.getDescripcion(),
				FechasDomain.crear(domain.getFecha().getFechaCreacion(),
						domain.getFecha().getFechaEstimadaInicio(),
						domain.getFecha().getFechaEstimadaFin()));
	}
	
	private void validarNoExistenciaMismoNombre(String nombre, UUID id) {
		final var domainProyecto = ProyectoDomain.crear(null, nombre, null,
				FechasDTOMapper.convertToDomain(FechasDTO.crear()));
		final var resultadosTmp = getProyectoDAO().consultar(ProyectoEntityMapper.convertToEntity(domainProyecto));
		
		if(!resultadosTmp.isEmpty()) {
			final var resultados = getUsuarioProyectoDAO().consultarPorId(resultadosTmp.get(0).getIdProyecto(), id);
			if(!resultados.isEmpty()) {
				final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000272);
				throw ServiceCoTaskerException.crear(mensajeUsuario);	
			}
		}
	}
	
	private void validarExistenciaUsuario(UUID id) {
		final var resultadosTmp = getUsuarioDAO().consultarPorId(id);
		if(resultadosTmp.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000349);
			throw ServiceCoTaskerException.crear(mensajeUsuario);	
		}
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000270);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000271);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ProyectoDAO getProyectoDAO() {
		return getFactoria().obtenerProyectoDAO();
	}
	
	private final UsuarioProyectoDAO getUsuarioProyectoDAO() {
		return getFactoria().obtenerUsuarioProyectoDAO();
	}
	
	private final UsuarioDAO getUsuarioDAO() {
		return getFactoria().obtenerUsuarioDAO();
	}
}
