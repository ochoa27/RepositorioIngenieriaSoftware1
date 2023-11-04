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
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
import com.eternalnovices.cotasker.data.entity.UsuarioProyectoEntity;
import com.eternalnovices.cotasker.data.entity.support.BooleanEntity;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class UsuarioProyectoSQLServerDAO extends SQLDAO implements UsuarioProyectoDAO{

	private static final String PRIMARYKEY = "WHERE up.idProyecto = ? AND up.idUsuario = ? ";
	
	public UsuarioProyectoSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final UsuarioProyectoEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO UsuarioProyecto (idProyecto, idUsuario) ");
		sentencia.append("VALUES (?, ?) ");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, entity.getProyecto().getIdProyecto());
			sentenciaPreparada.setObject(2, entity.getUsuario().getIdUsuario());
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000101);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000102);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000101);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000103);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public void eliminar(UUID idProyecto,UUID idUsuario) {
		final var sentencia = new StringBuilder();
		sentencia.append("DELETE FROM UsuarioProyecto up ");
		sentencia.append(PRIMARYKEY);
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, idProyecto);
			sentenciaPreparada.setObject(2, idUsuario);
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000109);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000107);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000109);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000108);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public Optional<UsuarioProyectoEntity> consultarPorId(UUID idProyecto,UUID idUsuario) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT up.idProyecto AS proyectoId, pr.nombre AS proyectoNombre, pr.descripcion AS proyectoDescripcion, "
				+ "pr.fechaCreacion AS proyectoFechaCreacion, pr.fechaEstimadaInicio AS proyectoFechaEstimadaInicio, "
				+ "pr.fechaEstimadaFin AS proyectoFechaEstimadaFin, up.IdUsuario AS usuarioId, "
				+ "us.nombre AS usuarioNombre, us.apellido AS usuarioApellido,  us.correoElectronico AS usuarioCorreoElectronico, "
				+ "us.correoElectronicoConfirmado AS usuarioCorreoElectronicoConfirmado, us.contrasena AS usuarioContrasena ");
		sentencia.append("FROM  UsuarioProyecto up ");
		sentencia.append("JOIN  Proyecto pr ");
		sentencia.append("	ON   pr.idProyecto = up.IdProyecto ");
		sentencia.append("JOIN  Usuario us ");
		sentencia.append("	ON  us.IdUsuario = up.idUsuario ");
		sentencia.append(PRIMARYKEY);
		
		Optional<UsuarioProyectoEntity> resultado = Optional.empty();
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, idProyecto);
			sentenciaPreparada.setObject(2, idUsuario);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000113);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000114);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}

		return resultado;
	}

	@Override
	public List<UsuarioProyectoEntity> consultar(UsuarioProyectoEntity entity) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000120);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000121);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final Optional<UsuarioProyectoEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){	
		Optional<UsuarioProyectoEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var usuarioProyectoEntity = UsuarioProyectoEntity.crear(
						ProyectoEntity.crear(UUID.fromString(resultados.getObject("proyectoId").toString()),
								resultados.getString("proyectoNombre"), resultados.getString("proyectoDescripcion"),
								FechasEntity.crear(resultados.getDate("proyectoFechaCreacion"),
										resultados.getDate("proyectoFechaEstimadaInicio"),
										resultados.getDate("proyectoFechaEstimadaFin"))),
						UsuarioEntity.crear(UUID.fromString(resultados.getObject("usuarioId").toString()),
								resultados.getString("usuarioNombre"), resultados.getString("usuarioApellido"),
								resultados.getString("usuarioCorreoElectronico"),
								BooleanEntity.crear(resultados.getBoolean("usuarioCorreoElectronicoConfirmado"), false),
								resultados.getString("usuarioContrasena")));
				resultado = Optional.of(usuarioProyectoEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000111);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000112);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return resultado;
	}
	
	private String formarSentenciaConsulta(final UsuarioProyectoEntity entity, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT up.idProyecto AS proyectoId, pr.nombre AS proyectoNombre, pr.descripcion AS proyectoDescripcion, "
				+ "pr.fechaCreacion AS proyectoFechaCreacion, pr.fechaEstimadaInicio AS proyectoFechaEstimadaInicio, "
				+ "pr.fechaEstimadaFin AS proyectoFechaEstimadaFin, up.IdUsuario AS usuarioId, "
				+ "us.nombre AS usuarioNombre, us.apellido AS usuarioApellido,  us.correoElectronico AS usuarioCorreoElectronico, "
				+ "us.correoElectronicoConfirmado AS usuarioCorreoElectronicoConfirmado, us.contrasena AS usuarioContrasena ");
		sentencia.append("FROM  UsuarioProyecto up ");
		sentencia.append("JOIN  Proyecto pr ");
		sentencia.append("	ON   pr.idProyecto = up.IdProyecto ");
		sentencia.append("JOIN  Usuario us ");
		sentencia.append("	ON  us.IdUsuario = up.idUsuario ");
		
		if(!UtilObjeto.esNulo(entity)) {
			if(!UtilObjeto.esNulo(entity.getProyecto())) {
				sentencia.append(operadorCondicional).append(" up.idProyecto = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getProyecto().getIdProyecto());
			}
			
			if(!UtilObjeto.esNulo(entity.getUsuario())) {
				sentencia.append(operadorCondicional).append(" up.idUsuario = ? ");
				parametros.add(entity.getUsuario().getIdUsuario());
			}

		}

		sentencia.append("ORDER BY up.idProyecto ");			
		return sentencia.toString();
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000116);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000117);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final List<UsuarioProyectoEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<UsuarioProyectoEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var usuarioProyectoEntity = UsuarioProyectoEntity.crear(
						ProyectoEntity.crear(UUID.fromString(resultados.getObject("proyectoId").toString()),
								resultados.getString("proyectoNombre"), resultados.getString("proyectoDescripcion"),
								FechasEntity.crear(resultados.getDate("proyectoFechaCreacion"),
										resultados.getDate("proyectoFechaEstimadaInicio"),
										resultados.getDate("proyectoFechaEstimadaFin"))),
						UsuarioEntity.crear(UUID.fromString(resultados.getObject("usuarioId").toString()),
								resultados.getString("usuarioNombre"), resultados.getString("usuarioApellido"),
								resultados.getString("usuarioCorreoElectronico"),
								BooleanEntity.crear(resultados.getBoolean("usuarioCorreoElectronicoConfirmado"), false),
								resultados.getString("usuarioContrasena")));
				listaResultados.add(usuarioProyectoEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000118);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000110);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000119);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return listaResultados;
	}
}
