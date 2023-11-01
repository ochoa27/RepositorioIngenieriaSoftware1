package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.EstadoEntity;
import com.eternalnovices.cotasker.service.domain.estado.EstadoDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class EstadoEntityMapper implements EntityMapper<EstadoEntity, EstadoDomain> {
	private static final EntityMapper<EstadoEntity, EstadoDomain> instancia = new EstadoEntityMapper();
	
	private EstadoEntityMapper() {
		super();
	}
	
	@Override
	public final EstadoDomain toDomain(final EstadoEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000153);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return EstadoDomain.crear(entity.getIdEstado(), entity.getDescripcion());
	}

	@Override
	public EstadoEntity toEntity(final EstadoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000154);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return EstadoEntity.crear(domain.getIdEstado(), domain.getDescripcion());
	}
	
	public static final EstadoDomain convertToDomain(final EstadoEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final EstadoEntity convertToEntity(final EstadoDomain domain) {
		return instancia.toEntity(domain);
	}
}
