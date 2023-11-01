package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;



public class ListaTareasEntityMapper implements EntityMapper<ListaTareasEntity, ListaTareasDomain> {
	private static final EntityMapper<ListaTareasEntity, ListaTareasDomain> instancia = new ListaTareasEntityMapper();
	
	private ListaTareasEntityMapper() {
		super();
	}
	
	@Override
	public final ListaTareasDomain toDomain(final ListaTareasEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000222);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return ListaTareasDomain.crear(entity.getIdListaTareas(), entity.getNombre(), entity.getDescripcion(),
				FechasEntityMapper.convertToDomain(entity.getFecha()) , PrioridadEntityMapper.convertToDomain(entity.getPrioridad()),
				ProyectoEntityMapper.convertToDomain(entity.getProyecto()));
	}

	@Override
	public ListaTareasEntity toEntity(final ListaTareasDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000223);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ListaTareasEntity.crear(domain.getIdListaTareas(), domain.getNombre(), domain.getDescripcion(),
				FechasEntityMapper.convertToEntity(domain.getFecha()) , PrioridadEntityMapper.convertToEntity(domain.getPrioridad()),
				ProyectoEntityMapper.convertToEntity(domain.getProyecto()));
	}
	
	public static final ListaTareasDomain convertToDomain(final ListaTareasEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final ListaTareasEntity convertToEntity(final ListaTareasDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<ListaTareasDomain>  convertToListDomain(final List<ListaTareasEntity> entity){
		List<ListaTareasDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}
}
