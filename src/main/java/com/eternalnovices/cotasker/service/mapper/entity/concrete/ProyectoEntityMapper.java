package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class ProyectoEntityMapper implements EntityMapper<ProyectoEntity, ProyectoDomain> {
	private static final EntityMapper<ProyectoEntity, ProyectoDomain> instancia = new ProyectoEntityMapper();
	
	private ProyectoEntityMapper() {
		super();
	}
	
	@Override
	public final  ProyectoDomain toDomain(final ProyectoEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000216);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}	 
		return ProyectoDomain.crear(entity.getIdProyecto(), entity.getNombre(), entity.getDescripcion(),FechasEntityMapper.convertToDomain(entity.getFechas()));
	}

	@Override
	public final  ProyectoEntity toEntity(final ProyectoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000217);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ProyectoEntity.crear(domain.getIdProyecto(), domain.getNombre(), domain.getDescripcion(),FechasEntityMapper.convertToEntity(domain.getFecha()));
	}
	
	public static final ProyectoDomain convertToDomain(final ProyectoEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final ProyectoEntity convertToEntity(final ProyectoDomain domain) {
		return instancia.toEntity(domain);
	}
	public static final List<ProyectoDomain>  convertToListDomain(final List<ProyectoEntity> entity){
		List<ProyectoDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}
}
