
	package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario;

	import java.util.Optional;
	import java.util.UUID;

	import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
	import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
	import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
	import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
	import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
	import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
	import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
	import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
	import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.support.BooleanDomain;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
	import com.eternalnovices.cotasker.service.mapper.entity.concrete.UsuarioEntityMapper;

	public class RegistrarUsuarioUseCase implements UseCase<UsuarioDomain>{
		private DAOFactory factoria;
		
		
		
		public RegistrarUsuarioUseCase(DAOFactory factoria) {
			setFactoria(factoria);
		}

		@Override
		public void execute(UsuarioDomain domain) {
			validarNoExistenciaMismoCorreo(domain.getCorreoElectronico());
			domain = obtenerIdentificadorUsuario(domain);
			getUsuarioDAO().crear(UsuarioEntityMapper.convertToEntity(domain));
		}
		
		private final void validarNoExistenciaMismoCorreo(final String correo) {
			final var domain = UsuarioDomain.crear(null, null, null, correo, BooleanDomain.crear(false, true), null);
			final var entity = UsuarioEntityMapper.convertToEntity(domain);
			final var resultados = getUsuarioDAO().consultar(entity);
			
			if(!resultados.isEmpty()) {
				final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000253);
				throw ServiceCoTaskerException.crear(mensajeUsuario);
			}
		}
		
		private final UsuarioDomain obtenerIdentificadorUsuario(UsuarioDomain domain) {
			Optional<UsuarioEntity> optional;
			UUID uuid;
			
			do {
				uuid = UtilUUID.generarRandomUUID();
				optional = getUsuarioDAO().consultarPorId(uuid);
			} while (optional.isPresent());
			
			return UsuarioDomain.crear(uuid, domain.getNombre(), domain.getApellido(), domain.getCorreoElectronico(),
					domain.isCorreoElectronicoConfirmado(), domain.getContrasena());
		}

		private final DAOFactory getFactoria() {
			return factoria;
		}

		private final void setFactoria(final DAOFactory factoria) {
			if (UtilObjeto.esNulo(factoria)) {
				final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000254);
				final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000255);
				throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			this.factoria = factoria;
		}
		
		private final UsuarioDAO getUsuarioDAO() {
			return getFactoria().obtenerUsuarioDAO();
		}

	}

