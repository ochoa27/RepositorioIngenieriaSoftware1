package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.ListaTareasDTO;
import com.eternalnovices.cotasker.service.dto.PrioridadDTO;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;



public class ListaTareasDTOMapper implements DTOMapper<ListaTareasDTO, ListaTareasDomain> {
	private static final DTOMapper<ListaTareasDTO, ListaTareasDomain> instancia= new ListaTareasDTOMapper();

	private ListaTareasDTOMapper() {
		super();
	}
	
	@Override
	public ListaTareasDomain toDomain(ListaTareasDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000247);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ListaTareasDomain.crear(dto.getIdListaTareas(),dto.getNombre(),dto.getDescripcion(),FechasDTOMapper.convertToDomain(dto.getFecha()),
				PrioridadDTOMapper.convertToDomain(dto.getPrioridad()), ProyectoDTOMapper.convertToDomain(dto.getProyecto()));
	}

	@Override
	public ListaTareasDTO toDTO(ListaTareasDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000248);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ListaTareasDTO.crear()
				.setIdListaTareas(domain.getIdListaTareas())
				.setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion())
				.setFecha(FechasDTO.crear().setFechaCreacion(domain.getFecha().getFechaCreacion())
						.setFechaEstimadaInicio(domain.getFecha().getFechaEstimadaInicio())
						.setFechaEstimadaFin(domain.getFecha().getFechaEstimadaFin()))
				.setPrioridad(PrioridadDTO.crear().setIdPrioridad(domain.getPrioridad().getIdPrioridad()))
				.setProyecto(ProyectoDTO.crear().setIdProyecto(domain.getProyecto().getIdProyecto()));
				
	}
	
	public static final ListaTareasDomain convertToDomain(final ListaTareasDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final ListaTareasDTO convertToDTO(final ListaTareasDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<ListaTareasDTO>  convertToListDTO(final List<ListaTareasDomain> dto){
		List<ListaTareasDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}
	
	
}
