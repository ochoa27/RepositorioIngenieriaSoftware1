package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;
import com.eternalnovices.cotasker.service.domain.fechas.FechasDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class FechasEntityMapper implements EntityMapper<FechasEntity, FechasDomain> {
	private static final EntityMapper<FechasEntity, FechasDomain> instancia = new FechasEntityMapper();
	
	private FechasEntityMapper() {
		super();
	}
	
	@Override
	public final FechasDomain toDomain(final FechasEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000141);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return FechasDomain.crear(entity.getFechaCreacion(), entity.getFechaEstimadaInicio(), entity.getFechaEstimadaFin());
	}

	@Override
	public FechasEntity toEntity(final FechasDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000150);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return FechasEntity.crear(domain.getFechaCreacion(), domain.getFechaEstimadaInicio(), domain.getFechaEstimadaFin());
	}
	
	public static final FechasDomain convertToDomain(final FechasEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final FechasEntity convertToEntity(final FechasDomain domain) {
		return instancia.toEntity(domain);
	}
}
