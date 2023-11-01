package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.TareaEntity;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class TareaEntityMapper implements EntityMapper<TareaEntity, TareaDomain> {
	private static final EntityMapper<TareaEntity, TareaDomain> instancia = new TareaEntityMapper();
	
	private TareaEntityMapper() {
		super();
	}
	
	@Override
	public final TareaDomain toDomain(final TareaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000224);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return TareaDomain.crear(entity.getIdTarea(), entity.getNombre(), entity.getDescripcion(),
				FechasEntityMapper.convertToDomain(entity.getFecha()) , PrioridadEntityMapper.convertToDomain(entity.getPrioridad()),
				EstadoEntityMapper.convertToDomain(entity.getEstado()),ListaTareasEntityMapper.convertToDomain(entity.getListaTareas()));
		}

	@Override
	public TareaEntity toEntity(final TareaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000225);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return TareaEntity.crear(domain.getIdTarea(), domain.getNombre(), domain.getDescripcion(), 
				FechasEntityMapper.convertToEntity(domain.getFecha()) , PrioridadEntityMapper.convertToEntity(domain.getPrioridad()),
				EstadoEntityMapper.convertToEntity(domain.getEstado()),ListaTareasEntityMapper.convertToEntity(domain.getListaTareas()));
	}
	
	public static final TareaDomain convertToDomain(final TareaEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final TareaEntity convertToEntity(final TareaDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<TareaDomain>  convertToListDomain(final List<TareaEntity> entity){
		List<TareaDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}
}

