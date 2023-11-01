package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.estado.EstadoDomain;
import com.eternalnovices.cotasker.service.dto.EstadoDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;

public class EstadoDTOMapper implements DTOMapper<EstadoDTO, EstadoDomain> {
	public static final DTOMapper<EstadoDTO, EstadoDomain> instancia = new EstadoDTOMapper();
	
	private EstadoDTOMapper() {
		super();
	}
	
	@Override
	public EstadoDomain toDomain(final EstadoDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000146);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return EstadoDomain.crear(dto.getIdEstado(), dto.getDescripcion());
	}

	@Override
	public EstadoDTO toDTO(final EstadoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000147);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return EstadoDTO.crear()
				.setIdEstado(domain.getIdEstado())
				.setDescripcion(domain.getDescripcion());
	}
	
	public static final EstadoDomain convertToDomain(final EstadoDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final EstadoDTO convertToDTO(final EstadoDomain domain) {
		return instancia.toDTO(domain);
	}
}
