package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.DataCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
import com.eternalnovices.cotasker.data.entity.support.BooleanEntity;

public class UsuarioSQLServerDAO extends SQLDAO implements UsuarioDAO {

	public UsuarioSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final UsuarioEntity usuario) {
		final var sentencia=new StringBuilder();
		
		sentencia.append("INSERT INTO Usuario ( idUsuario,nombre,apellido,correoElectronico,correoElectronicoConfirmado,"
				+ "contrasena) ");
		sentencia.append("VALUES (?,?,?,?,?,?) ");
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, usuario.getIdUsuario());
			sentenciaPreparada.setString(2,usuario.getNombre());
			sentenciaPreparada.setString(3, usuario.getApellido());
			sentenciaPreparada.setString(4, usuario.getCorreoElectronico());
			sentenciaPreparada.setBoolean(5, usuario.isCorreoElectronicoConfirmado().isValor());
			sentenciaPreparada.setString(6, usuario.getContrasena());
			
			sentenciaPreparada.executeUpdate();
			
			
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000071);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000072);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000071);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000073);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}		
	}

	@Override
	public final void modificar(final UsuarioEntity usuario) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Usuario ");
		sentencia.append("SET nombre = ?, ");
		sentencia.append(" apellido = ?, ");
		sentencia.append(" correoElectronico = ?, ");
		sentencia.append(" correoElectronicoConfirmado = ?, ");
		sentencia.append(" contrasena = ?, ");
		sentencia.append(" WHERE idUsuario = ? ");
		
		try(final var sentenciaPreparada= getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setString(1,usuario.getNombre());
			sentenciaPreparada.setString(2, usuario.getApellido());
			sentenciaPreparada.setString(3, usuario.getCorreoElectronico());
			sentenciaPreparada.setBoolean(4, usuario.isCorreoElectronicoConfirmado().isValor());
			sentenciaPreparada.setString(5, usuario.getContrasena());
			sentenciaPreparada.setObject(6, usuario.getIdUsuario());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000074);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000076);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000074);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000075);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		
		
		
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM Usuaio ");
		sentencia.append("WHERE idUsuario= ? " );
		
		try (final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000077);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000078);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000077);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000079);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final Optional<UsuarioEntity> consultarPorId(final UUID id) {
		final var sentencia= new StringBuilder();
		sentencia.append("SELECT * ");
		sentencia.append("FROM Usuario ");
		sentencia.append("WHERE idUsuario= ? ");
		
		Optional<UsuarioEntity> resultado=Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		}catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000080);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000081);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000080);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000082);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	private Optional<UsuarioEntity> ejecutarConsultaPorId(PreparedStatement sentenciaPreparada) {
		Optional<UsuarioEntity>resultado=Optional.empty();
		try(final var resultados=sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var usuarioEntity=UsuarioEntity.crear(
						UUID.fromString(resultados.getObject("idUsuario").toString()),
						resultados.getString("nombre"),
						resultados.getString("apellido"),
						resultados.getString("correoElectronico"),
						BooleanEntity.crear(resultados.getBoolean("correoElectronicoConfirmado"), false),
						resultados.getString("contrasena"));
				resultado = Optional.of(usuarioEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000080);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000083);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000080);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000084);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	

	@Override
	public final List<UsuarioEntity> consultar(final UsuarioEntity usuario) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(usuario, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		}catch (DataCoTaskerException exception) {
			throw exception;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000086);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000087);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	
	
	
	private List<UsuarioEntity> ejecutarConsulta(PreparedStatement sentenciaPreparada) {
		final var listaResultados = new ArrayList<UsuarioEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var usuarioEntity=UsuarioEntity.crear(
						UUID.fromString(resultados.getObject("idUsuario").toString()),
						resultados.getString("nombre"),
						resultados.getString("apellido"),
						resultados.getString("correoElectronico"),
						BooleanEntity.crear(resultados.getBoolean("correoElectronicoConfirmado"), false),
						resultados.getString("contrasena"));
						
				listaResultados.add(usuarioEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000088);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000089);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return listaResultados;
	}
	

	private void colocarParametrosConsulta(PreparedStatement sentenciaPreparada, ArrayList<Object> parametros) {
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000090);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000091);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private String formarSentenciaConsulta(UsuarioEntity usuario, ArrayList<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT * ");
		sentencia.append("FROM Usuario ");
		
		if(!UtilObjeto.esNulo(usuario)) {
			if(!UtilUUID.esNulo(usuario.getIdUsuario())) {
				sentencia.append(operadorCondicional).append(" idUsuario = ? ");
				operadorCondicional="AND";
				parametros.add(usuario.getIdUsuario());
			}
			if(!UtilTexto.estaVacio(usuario.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional="AND";
				parametros.add(usuario.getNombre());
			}
			if(!UtilTexto.estaVacio(usuario.getApellido())) {
				sentencia.append(operadorCondicional).append(" apellido = ? ");
				operadorCondicional="AND";
				parametros.add(usuario.getApellido());
			}
			if(!UtilTexto.estaVacio(usuario.getCorreoElectronico())) {
				sentencia.append(operadorCondicional).append(" correoElectronico = ? ");
				operadorCondicional="AND";
				parametros.add(usuario.getCorreoElectronico());
			}
			if(!usuario.isCorreoElectronicoConfirmado().isValorDefecto()) {
				sentencia.append(operadorCondicional).append(" correoElectronicoConfirmado = ? ");
				operadorCondicional="AND";
				parametros.add(usuario.isCorreoElectronicoConfirmado().isValor());
			}
			if(!UtilTexto.estaVacio(usuario.getContrasena())) {
				sentencia.append(operadorCondicional).append(" contrasena = ? ");
				parametros.add(usuario.getContrasena());
			}

		}
		
		return sentencia.toString();
	}
}
