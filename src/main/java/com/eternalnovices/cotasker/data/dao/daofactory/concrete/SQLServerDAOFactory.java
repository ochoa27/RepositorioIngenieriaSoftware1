package com.eternalnovices.cotasker.data.dao.daofactory.concrete;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.DataCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilSQL;
import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.EstadoSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.ListaTareaSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.PrioridadSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.ProyectoSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.TareaSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.UsuarioProyectoSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.concrete.sqlserver.UsuarioSQLServerDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;


public class SQLServerDAOFactory extends DAOFactory {
	
	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
    protected final void abrirConexion() {
        try {
			Properties prop = new Properties();
			InputStream input = getClass().getResourceAsStream("/application.properties");
			prop.load(input);
			String url = prop.getProperty("db.url");
			String user = prop.getProperty("db.user");
			String password = prop.getProperty("db.password");
            
            if (url == null || url.isEmpty() || user == null || user.isEmpty() || password == null || password.isEmpty()) {
            	var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
    			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000703);
    			throw DataCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
            }
            
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000704);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
        } catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000705);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);        	
        }
    }

    @Override
    public final void cerrarConexion() {
    	UtilSQL.cerrarConexion(conexion);
    }

    @Override
    public final void iniciarTransaccion() {
    	UtilSQL.iniciarTransaccion(conexion);
    }

    @Override
    public final void confirmarTransaccion() {
    	UtilSQL.confirmarTransaccion(conexion);
    }

    @Override
    public final void cancelarTransaccion() {
    	UtilSQL.cancelarTransaccion(conexion);
    }

	@Override
	public final EstadoDAO obtenerEstadoDAO() {
		verificarNoConexion();
		return new EstadoSQLServerDAO(conexion);
	}

	@Override
	public final ListaTareaDAO obtenerListaTareaDAO() {
		verificarNoConexion();
		return new ListaTareaSQLServerDAO(conexion);
	}

	@Override
	public final PrioridadDAO obtenerPrioridadDAO() {
		verificarNoConexion();
		return new PrioridadSQLServerDAO(conexion);
	}

	@Override
	public final ProyectoDAO obtenerProyectoDAO() {
		verificarNoConexion();
		return new ProyectoSQLServerDAO(conexion);
	}

	@Override
	public final TareaDAO obtenerTareaDAO() {
		verificarNoConexion();
		return new TareaSQLServerDAO(conexion);
	}

	@Override
	public final UsuarioDAO obtenerUsuarioDAO() {
		verificarNoConexion();
		return new UsuarioSQLServerDAO(conexion);
	}

	@Override
	public UsuarioProyectoDAO obtenerUsuarioProyectoDAO() {
		verificarNoConexion();
		return new UsuarioProyectoSQLServerDAO(conexion);
	}
	
	private void verificarNoConexion() {
        if(!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000706);
			throw DataCoTaskerException.crear(mensajeUsuario, mensajeTecnico);		
        }
	}
}
