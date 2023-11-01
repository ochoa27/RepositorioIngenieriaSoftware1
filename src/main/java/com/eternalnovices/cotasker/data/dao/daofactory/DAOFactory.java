package com.eternalnovices.cotasker.data.dao.daofactory;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.DataCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.concrete.SQLServerDAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;

public abstract class DAOFactory {
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factoria) {
		switch (factoria) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		case POSTGRESSQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000026);
			throw DataCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		case MYSQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000026);
			throw DataCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		case ORACLE: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000026);
			throw DataCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		default:
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000026);
			throw DataCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
	}
	
	protected abstract void abrirConexion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransaccion();
	
	public abstract EstadoDAO obtenerEstadoDAO();
	public abstract ListaTareaDAO obtenerListaTareaDAO();
	public abstract PrioridadDAO obtenerPrioridadDAO();
	public abstract ProyectoDAO obtenerProyectoDAO();
	public abstract TareaDAO obtenerTareaDAO();
	public abstract UsuarioDAO obtenerUsuarioDAO();
	public abstract UsuarioProyectoDAO obtenerUsuarioProyectoDAO();
}
