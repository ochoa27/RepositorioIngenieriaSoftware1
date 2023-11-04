package com.eternalnovices.cotasker.service.bussineslogic.concrete.listatareas;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.dto.EstadoDTO;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.PrioridadDTO;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.EstadoDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.FechasDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.PrioridadDTOMapper;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.ProyectoDTOMapper;
import com.eternalnovices.cotasker.service.mapper.entity.concrete.TareaEntityMapper;


public class EliminarListaTareasUseCase implements UseCase<ListaTareasDomain> {

	private DAOFactory factoria;
	
	public EliminarListaTareasUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ListaTareasDomain domain) {
		validarExistenciaRegistro(domain.getIdListaTareas());
		validarNoExistenciaRelacion(domain.getIdListaTareas());
		eliminar(domain.getIdListaTareas());
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getListaTareasDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000295);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaRelacion(final UUID id) {
		final var listaTareas = ListaTareasDomain.crear(id, null, null, FechasDTOMapper.convertToDomain(FechasDTO.crear()), 
				PrioridadDTOMapper.convertToDomain(PrioridadDTO.crear()), ProyectoDTOMapper.convertToDomain(ProyectoDTO.crear()));
		final var tarea = TareaDomain.crear(null, null, null, FechasDTOMapper.convertToDomain(FechasDTO.crear()),
				PrioridadDTOMapper.convertToDomain(PrioridadDTO.crear()), EstadoDTOMapper.convertToDomain(EstadoDTO.crear()),
				listaTareas);
		
		final var resultados = getTareaDAO().consultar(TareaEntityMapper.convertToEntity(tarea));
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000292);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
	
	private void eliminar(final UUID id) {
		getListaTareasDAO().eliminar(id);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000293);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000294);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ListaTareaDAO getListaTareasDAO() {
		return getFactoria().obtenerListaTareaDAO();
	}
	
	private final TareaDAO getTareaDAO() {
		return getFactoria().obtenerTareaDAO();
	}
}
