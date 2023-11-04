package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.support.BooleanEntity;
import com.eternalnovices.cotasker.service.domain.support.BooleanDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;


public class BooleanEntityMapper implements EntityMapper<BooleanEntity, BooleanDomain> {

	private static final EntityMapper<BooleanEntity, BooleanDomain> instancia = new BooleanEntityMapper();
	
	private BooleanEntityMapper() {
		super();
	}
	
	@Override
	public final BooleanDomain toDomain(final BooleanEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000298);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return BooleanDomain.crear(entity.isValor(), entity.isValorDefecto());
	}

	@Override
	public final BooleanEntity toEntity(final BooleanDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000299);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanEntity.crear(domain.isValor(), domain.isValorDefecto());
	}

	public static final BooleanDomain convertToDomain(final BooleanEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final BooleanEntity convertToEntity(final BooleanDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<BooleanDomain>  convertToListDomain(final List<BooleanEntity> entity){
		List<BooleanDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		return resultados;
	}
}
