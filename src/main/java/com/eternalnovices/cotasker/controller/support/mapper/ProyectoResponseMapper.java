package com.eternalnovices.cotasker.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.eternalnovices.cotasker.controller.support.request.SolicitarProyecto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;

public class ProyectoResponseMapper {
	private ProyectoResponseMapper() {
		super();
	}
	
	public static final SolicitarProyecto convertToResponse(final ProyectoDTO dto, final UUID idUsuario) {
		return new SolicitarProyecto(dto.getIdProyecto(), idUsuario, dto.getNombre(), dto.getDescripcion(), dto.getFecha());
	}
	
	public static final SolicitarProyecto convertToResponse(final ProyectoDTO dto) {
		return new SolicitarProyecto(dto.getIdProyecto(), UtilUUID.UUIDDEFECTO, dto.getNombre(), dto.getDescripcion(), dto.getFecha());
	}
	
	public static final List<SolicitarProyecto> convertListToResponse(final List<ProyectoDTO> dto){
		List<SolicitarProyecto> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToResponse(dto.get(i)));
		}
		
		return resultados;
	}
	
	public static final List<SolicitarProyecto> convertListToResponse(final List<ProyectoDTO> dto, final UUID idUsuario){
		List<SolicitarProyecto> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToResponse(dto.get(i), idUsuario));
		}
		
		return resultados;
	}
}
