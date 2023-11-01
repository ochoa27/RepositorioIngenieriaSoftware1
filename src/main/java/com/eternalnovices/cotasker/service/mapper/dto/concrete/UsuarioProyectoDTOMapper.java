package com.eternalnovices.cotasker.service.mapper.dto.concrete;


import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;
import com.eternalnovices.cotasker.service.dto.UsuarioProyectoDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;

public class UsuarioProyectoDTOMapper implements DTOMapper<UsuarioProyectoDTO, UsuarioProyectoDomain>{
	private static final DTOMapper<UsuarioProyectoDTO, UsuarioProyectoDomain> instancia= new UsuarioProyectoDTOMapper();
	
	private UsuarioProyectoDTOMapper() {
		super();
	}
	
	@Override
	public UsuarioProyectoDomain toDomain(UsuarioProyectoDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000245);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return UsuarioProyectoDomain.crear(ProyectoDTOMapper.convertToDomain(dto.getProyecto()),UsuarioDTOMapper.convertToDomain(dto.getUsuario()));
	}
	
	@Override
	public UsuarioProyectoDTO toDTO(UsuarioProyectoDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000246);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return UsuarioProyectoDTO.crear()
				.setProyecto(ProyectoDTO.crear()
						.setIdProyecto(domain.getProyecto().getIdProyecto()))
				.setUsuario(UsuarioDTO.crear()
						.setIdUsuario(domain.getUsuario().getIdUsuario()));
	}
	
	public static final UsuarioProyectoDomain convertToDomain(final UsuarioProyectoDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final UsuarioProyectoDTO convertToDTO(final UsuarioProyectoDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<UsuarioProyectoDTO>  convertToListDTO(final List<UsuarioProyectoDomain> dto){
		List<UsuarioProyectoDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}
	
	
}


