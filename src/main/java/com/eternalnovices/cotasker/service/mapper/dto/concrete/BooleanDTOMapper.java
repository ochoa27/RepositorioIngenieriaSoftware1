package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.support.BooleanDomain;
import com.eternalnovices.cotasker.service.dto.BooleanDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;


public class BooleanDTOMapper implements DTOMapper<BooleanDTO, BooleanDomain>{
	private static final DTOMapper<BooleanDTO, BooleanDomain> instancia = new BooleanDTOMapper();
	
	private BooleanDTOMapper() {
		super();
	}
	
	@Override
	public BooleanDomain toDomain(BooleanDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000903);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanDomain.crear(dto.isValor(), dto.isValorDefecto());
	}

	@Override
	public BooleanDTO toDTO(BooleanDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000137);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanDTO.crear()
				.setValor(domain.isValor())
				.setValorDefecto(domain.isValorDefecto());
	}
	
	public static final BooleanDomain convertToDomain(final BooleanDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final BooleanDTO convertToDTO(final BooleanDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<BooleanDTO>  convertToListDTO(final List<BooleanDomain> dto){
		List<BooleanDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}