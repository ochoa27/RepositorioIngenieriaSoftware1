package com.eternalnovices.cotasker.service.bussineslogic.concrete.listatareas;

import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.PrioridadDTO;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.FechasDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.PrioridadDTOMapper;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.ListaTareasEntityMapper;


public class RegistrarListaTareasUseCase implements UseCase<ListaTareasDomain>{

	private DAOFactory factoria;
	
	public RegistrarListaTareasUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ListaTareasDomain domain) {
		validarNoExistenciaMismoNombre(domain.getNombre(), domain.getProyecto());
		domain = obtenerIdentificadorListaTareas(domain);
		registrar(domain);
	}
	
	private final ListaTareasDomain obtenerIdentificadorListaTareas(ListaTareasDomain domain) {
		Optional<ListaTareasEntity> optional;
		UUID uuid;
		
		do {
			uuid = UtilUUID.generarRandomUUID();
			optional = getListaTareasDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return ListaTareasDomain.crear(uuid, domain.getNombre(), domain.getDescripcion(), FechasDomain.crear(domain.getFecha().getFechaCreacion(),
						domain.getFecha().getFechaEstimadaInicio(),
						domain.getFecha().getFechaEstimadaFin()),
				domain.getPrioridad(), domain.getProyecto());
	}
	
	
	private final void validarNoExistenciaMismoNombre(final String nombre, final ProyectoDomain proyecto) {
		final var domain = ListaTareasDomain.crear(null, nombre, null, FechasDTOMapper.convertToDomain(FechasDTO.crear()),
				PrioridadDTOMapper.convertToDomain(PrioridadDTO.crear()),
				proyecto);
		final var entity = ListaTareasEntityMapper.convertToEntity(domain);
		final var resultados = getListaTareasDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000809);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private void registrar(final ListaTareasDomain domain) {
		getListaTareasDAO().crear(ListaTareasEntityMapper.convertToEntity(domain));
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000810);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000811);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}

	private final ListaTareaDAO getListaTareasDAO() {
		return getFactoria().obtenerListaTareaDAO();
	}
}
