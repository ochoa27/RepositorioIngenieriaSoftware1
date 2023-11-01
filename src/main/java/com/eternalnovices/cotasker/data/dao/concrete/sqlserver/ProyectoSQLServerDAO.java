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
import com.eternalnovices.cotasker.crosscutting.util.UtilFecha;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class ProyectoSQLServerDAO extends SQLDAO implements ProyectoDAO{
	private static final String CONDICIONWHERE = "WHERE idProyecto = ? ";
	
	
	public ProyectoSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ProyectoEntity entity) {
		final var sentencia=new StringBuilder();
		
		sentencia.append("INSERT INTO Proyecto (idProyecto, nombre, descripcion , fechaCreacion, fechaEstimadaInicio, fechaEstimadaFin) ");
		sentencia.append("VALUES (?,?,?,?,?,?) ");
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, entity.getIdProyecto());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setString(3, entity.getDescripcion());
			sentenciaPreparada.setDate(4, entity.getFechas().getFechaCreacion());
			sentenciaPreparada.setDate(5, entity.getFechas().getFechaEstimadaInicio());
			sentenciaPreparada.setDate(6, entity.getFechas().getFechaEstimadaFin());
			
			sentenciaPreparada.executeUpdate();
			
			
		} catch (final SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000182);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000183);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000182);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000184);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		
				
	}

	@Override
	public final void modificar(final ProyectoEntity entity) {
final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Proyecto ");
		sentencia.append("SET nombre = ?, descripcion = ?, fechaCreacion = ?, fechaEstimadaInicio = ?, fechaEstimadaFin = ? ");
		sentencia.append(CONDICIONWHERE);
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setString(2, entity.getDescripcion());
			sentenciaPreparada.setDate(3, entity.getFechas().getFechaCreacion());
			sentenciaPreparada.setDate(4, entity.getFechas().getFechaEstimadaInicio());
			sentenciaPreparada.setDate(5, entity.getFechas().getFechaEstimadaFin());
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000185);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000186);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000185);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000187);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("DELETE FROM Proyecto ");
		sentencia.append(CONDICIONWHERE);
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000188);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000189);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000188);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000190);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public Optional<ProyectoEntity> consultarPorId(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT idProyecto, nombre, descripcion , fechaCreacion, fechaEstimadaInicio, fechaEstimadaFin ");
		sentencia.append("FROM Proyecto ");
		sentencia.append(CONDICIONWHERE);

		Optional<ProyectoEntity> resultado = Optional.empty();
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000192);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000193);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}

		return resultado;
	}

	@Override
	public List<ProyectoEntity> consultar(ProyectoEntity entity) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000196);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000197);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private final Optional<ProyectoEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){	
		Optional<ProyectoEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var proyectoEntity = ProyectoEntity.crear(
						UUID.fromString(resultados.getObject("idProyecto").toString()),
						resultados.getString("nombre"),
						resultados.getString("descripcion"),
						FechasEntity.crear(resultados.getDate("fechaCreacion"), resultados.getDate("fechaEstimadaInicio"), resultados.getDate("fechaEstimadaFin")));
						
				resultado = Optional.of(proyectoEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000194);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000195);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return resultado;
	}

	private String formarSentenciaConsulta(final ProyectoEntity entity, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT idProyecto, nombre, descripcion, fechaCreacion, fechaEstimadaInicio, fechaEstimadaFin ");
		sentencia.append("FROM Proyecto ");
		
		if(!UtilObjeto.esNulo(entity)) {
			if(!UtilUUID.esNulo(entity.getIdProyecto())) {
				sentencia.append(operadorCondicional).append(" idProyecto = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getIdProyecto());
			}
			
			if(!UtilTexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			
			if(!UtilTexto.estaVacio(entity.getDescripcion())) {
				sentencia.append(operadorCondicional).append(" descripcion = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getDescripcion());
			}
			
			if(!UtilObjeto.esNulo(entity.getFechas())) {
				if(!UtilFecha.esNulo(entity.getFechas().getFechaCreacion())) {
					sentencia.append(operadorCondicional).append(" fechaCreacion = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getFechas().getFechaCreacion());
				}
				
				if(!UtilFecha.esNulo(entity.getFechas().getFechaEstimadaInicio())) {
					sentencia.append(operadorCondicional).append(" fechaEstimadaInicio = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getFechas().getFechaEstimadaInicio());
				}
				
				if(!UtilFecha.esNulo(entity.getFechas().getFechaEstimadaFin())) {
					sentencia.append(operadorCondicional).append(" fechaEstimadaFin = ? ");
					parametros.add(entity.getFechas().getFechaEstimadaFin());
				}
			}
			
			
		}
		
		sentencia.append("ORDER BY fechaCreacion ");	
		return sentencia.toString();
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000198);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000199);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private final List<ProyectoEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<ProyectoEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var proyectoEntity = ProyectoEntity.crear(
						UUID.fromString(resultados.getObject("idProyecto").toString()),
						resultados.getString("nombre"),
						resultados.getString("descripcion"),
						FechasEntity.crear(resultados.getDate("fechaCreacion"),
								resultados.getDate("fechaEstimadaInicio"), resultados.getDate("fechaEstimadaFin")));
				listaResultados.add(proyectoEntity);		
				}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000200);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000201);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return listaResultados;
	}
}
