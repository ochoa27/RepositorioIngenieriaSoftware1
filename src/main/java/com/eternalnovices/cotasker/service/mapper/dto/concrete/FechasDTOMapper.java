package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;

public class FechasDTOMapper implements DTOMapper<FechasDTO, FechasDomain> {
	public static final DTOMapper<FechasDTO, FechasDomain> instancia = new FechasDTOMapper();
	
	private FechasDTOMapper() {
		super();
	}
	
	@Override
	public FechasDomain toDomain(final FechasDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000142);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return FechasDomain.crear(dto.getFechaCreacion(), dto.getFechaEstimadaInicio(), dto.getFechaEstimadaFin());
	}

	@Override
	public FechasDTO toDTO(final FechasDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000143);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return FechasDTO.crear()
				.setFechaCreacion(domain.getFechaCreacion())
				.setFechaEstimadaInicio(domain.getFechaEstimadaInicio())
				.setFechaEstimadaFin(domain.getFechaEstimadaFin());
	}
	
	public static final FechasDomain convertToDomain(final FechasDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final FechasDTO convertToDTO(final FechasDomain domain) {
		return instancia.toDTO(domain);
	}
}
