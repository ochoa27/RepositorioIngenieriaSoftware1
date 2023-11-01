package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class PrioridadEntityMapper implements EntityMapper<PrioridadEntity, PrioridadDomain> {
	private static final EntityMapper<PrioridadEntity, PrioridadDomain> instancia = new PrioridadEntityMapper();
	
	private PrioridadEntityMapper() {
		super();
	}
	
	@Override
	public final PrioridadDomain toDomain(final PrioridadEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000151);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return PrioridadDomain.crear(entity.getIdPrioridad(), entity.getDescripcion());
	}

	@Override
	public PrioridadEntity toEntity(final PrioridadDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000152);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return PrioridadEntity.crear(domain.getIdPrioridad(), domain.getDescripcion());
	}
	
	public static final PrioridadDomain convertToDomain(final PrioridadEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final PrioridadEntity convertToEntity(final PrioridadDomain domain) {
		return instancia.toEntity(domain);
	}
}
