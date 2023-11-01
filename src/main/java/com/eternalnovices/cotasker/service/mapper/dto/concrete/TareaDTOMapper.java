package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.dto.EstadoDTO;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.ListaTareasDTO;
import com.eternalnovices.cotasker.service.dto.PrioridadDTO;
import com.eternalnovices.cotasker.service.dto.TareaDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;



public class TareaDTOMapper implements DTOMapper<TareaDTO, TareaDomain> {
	private static final DTOMapper<TareaDTO, TareaDomain> instancia= new TareaDTOMapper();

	private TareaDTOMapper() {
		super();
	}
	
	@Override
	public TareaDomain toDomain(TareaDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000249);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TareaDomain.crear(dto.getIdTarea(),dto.getNombre(),dto.getDescripcion(),FechasDTOMapper.convertToDomain(dto.getFecha()),
				PrioridadDTOMapper.convertToDomain(dto.getPrioridad()) , EstadoDTOMapper.convertToDomain(dto.getEstado()), ListaTareasDTOMapper.convertToDomain(dto.getListaTareas()));

	}

	@Override
	public TareaDTO toDTO(TareaDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000250);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TareaDTO.crear()
				.setIdTarea(domain.getIdTarea())
				.setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion())
				.setFecha(FechasDTO.crear().setFechaCreacion(domain.getFecha().getFechaCreacion())
						.setFechaEstimadaInicio(domain.getFecha().getFechaEstimadaInicio())
						.setFechaEstimadaFin(domain.getFecha().getFechaEstimadaFin()))
				.setPrioridad(PrioridadDTO.crear().setIdPrioridad(domain.getPrioridad().getIdPrioridad()))
				.setEstado(EstadoDTO.crear().setIdEstado(domain.getEstado().getIdEstado()))
				.setListaTareas(ListaTareasDTO.crear().setIdListaTareas(domain.getListaTareas().getIdListaTareas()));
				
	}
	
	public static final TareaDomain convertToDomain(final TareaDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final TareaDTO convertToDTO(final TareaDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<TareaDTO>  convertToListDTO(final List<TareaDomain> dto){
		List<TareaDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}
	
	
}
