package com.eternalnovices.cotasker.data.dao.base;

import java.sql.Connection;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.DataCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilSQL;

public class SQLDAO {
private Connection conexion;
	
	
	protected SQLDAO (final Connection conexion) {
		setConexion(conexion);
	}

	protected final Connection getConexion() {
		return conexion;
	}

	private final void setConexion(final Connection conexion) {
		if(!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000027);
			throw DataCoTaskerException.crear(mensajeUsuario,mensajeTecnico);
		}
		this.conexion = conexion;
	}
}
