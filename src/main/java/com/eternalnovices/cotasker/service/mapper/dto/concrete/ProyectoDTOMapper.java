package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;



public class ProyectoDTOMapper implements DTOMapper<ProyectoDTO, ProyectoDomain> {
	private static final DTOMapper<ProyectoDTO, ProyectoDomain> instancia= new ProyectoDTOMapper();

	private ProyectoDTOMapper() {
		super();
	}
	
	@Override
	public ProyectoDomain toDomain(ProyectoDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000243);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ProyectoDomain.crear(dto.getIdProyecto(),dto.getNombre(),dto.getDescripcion(),FechasDTOMapper.convertToDomain(dto.getFecha()));
	}

	@Override
	public ProyectoDTO toDTO(ProyectoDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000244);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ProyectoDTO.crear()
				.setIdProyecto(domain.getIdProyecto())
				.setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion())
				.setFecha(FechasDTO.crear().setFechaCreacion(domain.getFecha().getFechaCreacion())
						.setFechaEstimadaInicio(domain.getFecha().getFechaEstimadaInicio())
						.setFechaEstimadaFin(domain.getFecha().getFechaEstimadaFin()));
	}
	
	public static final ProyectoDomain convertToDomain(final ProyectoDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final ProyectoDTO convertToDTO(final ProyectoDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<ProyectoDTO>  convertToListDTO(final List<ProyectoDomain> dto){
		List<ProyectoDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}
	
	
}
