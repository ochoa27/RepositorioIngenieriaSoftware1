package com.eternalnovices.cotasker.service.mapper.entity.concrete;


import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.UsuarioProyectoEntity;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class UsuarioProyectoEntityMapper implements EntityMapper<UsuarioProyectoEntity, UsuarioProyectoDomain> {
private static final EntityMapper<UsuarioProyectoEntity,UsuarioProyectoDomain> instancia = new UsuarioProyectoEntityMapper();
	
	private UsuarioProyectoEntityMapper() {
		super();
	}
	
	@Override
	public UsuarioProyectoDomain toDomain(final UsuarioProyectoEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000220);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}	 
		return UsuarioProyectoDomain.crear(ProyectoEntityMapper.convertToDomain(entity.getProyecto()),UsuarioEntityMapper.convertToDomain(entity.getUsuario()));
	}
	

	@Override
	public UsuarioProyectoEntity toEntity(final UsuarioProyectoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000221);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}	 
		return UsuarioProyectoEntity.crear(ProyectoEntityMapper.convertToEntity(domain.getProyecto()),UsuarioEntityMapper.convertToEntity(domain.getUsuario()));
	}
	
	public static final UsuarioProyectoDomain convertToDomain(final UsuarioProyectoEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final UsuarioProyectoEntity convertToEntity(final UsuarioProyectoDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<UsuarioProyectoDomain>  convertToListDomain(final List<UsuarioProyectoEntity> entity){
		List<UsuarioProyectoDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}

}
