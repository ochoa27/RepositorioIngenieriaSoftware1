package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
import com.eternalnovices.cotasker.data.entity.support.BooleanEntity;
import com.eternalnovices.cotasker.service.domain.support.BooleanDomain;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class UsuarioEntityMapper implements EntityMapper<UsuarioEntity, UsuarioDomain>{
	private static final EntityMapper<UsuarioEntity, UsuarioDomain> instancia = new UsuarioEntityMapper();
	
	private UsuarioEntityMapper() {
		super();
	}
	
	@Override
	public final UsuarioDomain toDomain(final UsuarioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000218);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}	 
		return UsuarioDomain.crear(entity.getIdUsuario(), entity.getNombre(), entity.getApellido(),
				entity.getCorreoElectronico(), BooleanDomain.crear(entity.isCorreoElectronicoConfirmado().isValor(),
						entity.isCorreoElectronicoConfirmado().isValorDefecto()),
				entity.getContrasena());
	}
	

	@Override
	public UsuarioEntity toEntity(UsuarioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000219);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return UsuarioEntity.crear(domain.getIdUsuario(), domain.getNombre(), domain.getApellido(),domain.getCorreoElectronico(),
				BooleanEntity.crear(domain.isCorreoElectronicoConfirmado().isValor(), domain.isCorreoElectronicoConfirmado().isValorDefecto()),domain.getContrasena());
	}
	
	public static final UsuarioDomain convertToDomain(final UsuarioEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final UsuarioEntity convertToEntity(final UsuarioDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<UsuarioDomain>  convertToListDomain(final List<UsuarioEntity> entity){
		List<UsuarioDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}

}
