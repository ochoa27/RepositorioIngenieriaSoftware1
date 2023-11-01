package com.eternalnovices.cotasker.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.controller.support.request.SolicitarUsuario;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;

public class UsuarioResponseMapper {
	private UsuarioResponseMapper() {
		super();
	}
	
	public static final SolicitarUsuario convertToResponse(UsuarioDTO dto) {
		return new SolicitarUsuario(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getCorreoElectronico(),
				dto.isCorreoElectronicoConfirmado().isValor(), dto.getContrasena());
	}
	
	public static final List<SolicitarUsuario> convertListToResponse(List<UsuarioDTO> dto){
		List<SolicitarUsuario> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToResponse(dto.get(i)));
		}
		
		return resultados;
	}
}
