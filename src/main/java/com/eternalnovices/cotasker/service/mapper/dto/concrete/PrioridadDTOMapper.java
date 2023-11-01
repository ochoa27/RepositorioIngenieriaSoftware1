package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;
import com.eternalnovices.cotasker.service.dto.PrioridadDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;

public class PrioridadDTOMapper implements DTOMapper<PrioridadDTO, PrioridadDomain> {
	public static final DTOMapper<PrioridadDTO, PrioridadDomain> instancia = new PrioridadDTOMapper();
	
	private PrioridadDTOMapper() {
		super();
	}
	
	@Override
	public PrioridadDomain toDomain(final PrioridadDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000144);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return PrioridadDomain.crear(dto.getIdPrioridad(), dto.getDescripcion());
	}

	@Override
	public PrioridadDTO toDTO(final PrioridadDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000145);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PrioridadDTO.crear()
				.setIdPrioridad(domain.getIdPrioridad())
				.setDescripcion(domain.getDescripcion());
	}
	
	public static final PrioridadDomain convertToDomain(final PrioridadDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final PrioridadDTO convertToDTO(final PrioridadDomain domain) {
		return instancia.toDTO(domain);
	}
}
