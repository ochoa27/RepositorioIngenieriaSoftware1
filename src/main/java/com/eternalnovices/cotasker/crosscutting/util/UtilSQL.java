package com.eternalnovices.cotasker.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.CrosscuttingCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;

public class UtilSQL {
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000005);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			return !UtilObjeto.esNulo(conexion) && !conexion.isClosed();
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000006);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000007);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void cerrarConexion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000008);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000009);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			conexion.close();
		} catch (final CrosscuttingCoTaskerException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000006);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000010);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000011);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000012);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000013);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);				
			}
			
			conexion.setAutoCommit(false);
		} catch (final CrosscuttingCoTaskerException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000014);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000015);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void confirmarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000016);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000017);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000018);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);				
			}
			
			conexion.commit();
		} catch (final CrosscuttingCoTaskerException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000019);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000020);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void cancelarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000021);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000022);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000023);
				throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);				
			}
			
			conexion.rollback();
		} catch (final CrosscuttingCoTaskerException e) {
			throw e;
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000024);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000025);
			throw CrosscuttingCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
}
