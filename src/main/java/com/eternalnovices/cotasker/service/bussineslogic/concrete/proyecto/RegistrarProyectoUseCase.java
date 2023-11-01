package com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto;

import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.FechasDTOMapper;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.ProyectoEntityMapper;


public class RegistrarProyectoUseCase implements UseCase<ProyectoDomain> {
	private DAOFactory factoria;
	
	public RegistrarProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	@Override
	public void execute(ProyectoDomain domain) {
		validarNoExistenciaMismoNombre(domain.getNombre());
		domain = obtenerIdentificadorProyecto(domain);
		getProyectoDAO().crear(ProyectoEntityMapper.convertToEntity(domain));
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
	
	private void validarNoExistenciaMismoNombre(String nombre) {
		final var domain = ProyectoDomain.crear(null, nombre, null,
				FechasDTOMapper.convertToDomain(FechasDTO.crear()));
		final var entity = ProyectoEntityMapper.convertToEntity(domain);
		final var resultados = getProyectoDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000272);
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

}
