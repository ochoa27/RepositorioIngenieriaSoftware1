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
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.EstadoEntity;
import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.data.entity.TareaEntity;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class TareaSQLServerDAO extends SQLDAO implements TareaDAO{

	public TareaSQLServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(TareaEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Tarea (idTarea, nombre, descripcion, fechaCreacion, fechaEstimadaInicio, fechaEstimadaFin, idPrioridad, idEstado, idLista) ");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, entity.getIdTarea());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setString(3, entity.getDescripcion());
			sentenciaPreparada.setDate(4, entity.getFecha().getFechaCreacion());
			sentenciaPreparada.setDate(5, entity.getFecha().getFechaEstimadaInicio());
			sentenciaPreparada.setDate(6, entity.getFecha().getFechaEstimadaFin());
			sentenciaPreparada.setObject(7, entity.getPrioridad().getIdPrioridad());
			sentenciaPreparada.setObject(8, entity.getEstado().getIdEstado());
			sentenciaPreparada.setObject(8, entity.getListaTareas().getIdListaTareas());
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000122);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000123);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000122);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000124);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public void modificar(TareaEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Tarea ");
		sentencia.append("SET nombre = ?, descripcion = ?, fechaCreacion = ?, fechaEstimadaInicio = ?, fechaEstimadaFin = ?, idPrioridad = ?, idEstado = ?, idLista = ? ");
		sentencia.append("WHERE idTarea = ? ");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setString(2, entity.getDescripcion());
			sentenciaPreparada.setDate(3, entity.getFecha().getFechaCreacion());
			sentenciaPreparada.setDate(4, entity.getFecha().getFechaEstimadaInicio());
			sentenciaPreparada.setDate(5, entity.getFecha().getFechaEstimadaFin());
			sentenciaPreparada.setObject(6, entity.getPrioridad().getIdPrioridad());
			sentenciaPreparada.setObject(7, entity.getEstado().getIdEstado());
			sentenciaPreparada.setObject(8, entity.getListaTareas().getIdListaTareas());
			sentenciaPreparada.setObject(9, entity.getIdTarea());
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000125);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000126);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000125);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000127);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public void eliminar(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("DELETE FROM UsuarioProyecto ");
		sentencia.append("WHERE idTarea = ? ");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000128);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000129);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000128);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000130);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public Optional<TareaEntity> consultarPorId(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT ta.idTarea, ta.nombre, ta.descripcion, ta.fechaCreacion, ta.fechaEstimadaInicio, ta.fechaEstimadaFin, ta.idPrioridad, pri.descripcion, "
				+ "ta.idEstado, es.descripcio, ta.idLista, li.nombre, li.descripcion, li.fechaCreacion, li.fechaEstimadaInicio, li.fechaEstimadaFin, li.IdProyecto, "
				+ "pr.nombre, pr.descripcion, pr.fechaCreacion, pr.fechaEstimadaInicio, pr.fechaEstimadaFin, li.idPrioridad, prili.descripcion");
		sentencia.append("FROM  Tareas ta ");
		sentencia.append("JOIN  Prioridad pri ");
		sentencia.append("	ON   ta.idTarea = pri.IdPrioridad ");
		sentencia.append("JOIN  Estado es ");
		sentencia.append("	ON  ta.idTarea = es.idEstado ");
		sentencia.append("JOIN  ListaTareas li ");
		sentencia.append("	ON  ta.idTarea = li.idLista ");
		sentencia.append("JOIN  Prioridad prili ");
		sentencia.append("	ON   li.idLista = prili.IdPrioridad ");
		sentencia.append("JOIN  Proyecto pr ");
		sentencia.append("	ON  li.idTarea = pr.idProyecto ");
		sentencia.append("WHERE ta.idTarea = ? ");

		Optional<TareaEntity> resultado = Optional.empty();
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000132);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000133);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}

		return resultado;
	}

	@Override
	public List<TareaEntity> consultar(TareaEntity entity) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000136);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000137);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private final Optional<TareaEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){	
		Optional<TareaEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var tareaEntity = TareaEntity.crear(
						UUID.fromString(resultados.getObject("ta.idTarea").toString()),
						resultados.getString("ta.nombre"),
						resultados.getString("ta.descripcion"),
						FechasEntity.crear(resultados.getDate("ta.fechaCreacion"), resultados.getDate("ta.fechaEstimadaInicio"), resultados.getDate("ta.fechaEstimadaFin")),
						PrioridadEntity.crear(UUID.fromString(resultados.getObject("ta.idPrioridad").toString()), resultados.getString("pri.descripcion")),
						EstadoEntity.crear(UUID.fromString(resultados.getObject("ta.idEstado").toString()), resultados.getString("es.descripcion")),
						ListaTareasEntity.crear(
								UUID.fromString(resultados.getObject("ta.idLista").toString()),
								resultados.getString("li.nombre"), 
								resultados.getString("li.descripcion"), 
								FechasEntity.crear(resultados.getDate("li.fechaCreacion"), resultados.getDate("li.fechaEstimadaInicio"), resultados.getDate("li.fechaEstimadaFin")),
								PrioridadEntity.crear(UUID.fromString(resultados.getObject("li.idPrioridad").toString()), resultados.getString("prili.descripcion")),
								ProyectoEntity.crear(
										UUID.fromString(resultados.getObject("li.idProyecto").toString()), 
										resultados.getString("pr.nombre"), 
										resultados.getString("pr.descripcion"), 
										FechasEntity.crear(resultados.getDate("pr.fechaCreacion"), resultados.getDate("pr.fechaEstimadaInicio"), resultados.getDate("pr.fechaEstimadaFin"))
										)
								)
						);
				resultado = Optional.of(tareaEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000134);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000135);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return resultado;
	}

	private String formarSentenciaConsulta(final TareaEntity entity, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT ta.idTarea, ta.nombre, ta.descripcion, ta.fechaCreacion, ta.fechaEstimadaInicio, ta.fechaEstimadaFin, ta.idPrioridad, pri.descripcion, "
				+ "ta.idEstado, es.descripcio, ta.idLista, li.nombre, li.descripcion, li.fechaCreacion, li.fechaEstimadaInicio, li.fechaEstimadaFin, li.IdProyecto, "
				+ "pr.nombre, pr.descripcion, pr.fechaCreacion, pr.fechaEstimadaInicio, pr.fechaEstimadaFin, li.idPrioridad, prili.descripcion");
		sentencia.append("FROM  Tareas ta ");
		sentencia.append("JOIN  Prioridad pri ");
		sentencia.append("	ON   ta.idTarea = pri.IdPrioridad ");
		sentencia.append("JOIN  Estado es ");
		sentencia.append("	ON  ta.idTarea = es.idEstado ");
		sentencia.append("JOIN  ListaTareas li ");
		sentencia.append("	ON  ta.idTarea = li.idLista ");
		sentencia.append("JOIN  Prioridad prili ");
		sentencia.append("	ON   li.idLista = prili.IdPrioridad ");
		sentencia.append("JOIN  Proyecto pr ");
		sentencia.append("	ON  li.idTarea = pr.idProyecto ");
		
		if(!UtilObjeto.esNulo(entity)) {
			if(!UtilUUID.esNulo(entity.getIdTarea())) {
				sentencia.append(operadorCondicional).append(" ta.idTarea = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getIdTarea());
			}
			
			if(!UtilTexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" ta.nombre = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			
			if(!UtilTexto.estaVacio(entity.getDescripcion())) {
				sentencia.append(operadorCondicional).append(" ta.descripcion = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getDescripcion());
			}
			
			if(!UtilObjeto.esNulo(entity.getFecha())) {
				if(!UtilFecha.esNulo(entity.getFecha().getFechaCreacion())) {
					sentencia.append(operadorCondicional).append(" ta.fechaCreacion = ?");
					operadorCondicional = "AND";
					parametros.add(entity.getFecha().getFechaCreacion());
				}
				
				if(!UtilFecha.esNulo(entity.getFecha().getFechaEstimadaInicio())) {
					sentencia.append(operadorCondicional).append(" ta.fechaEstimadaInicio = ?");
					operadorCondicional = "AND";
					parametros.add(entity.getFecha().getFechaEstimadaInicio());
				}
				
				if(!UtilFecha.esNulo(entity.getFecha().getFechaEstimadaFin())) {
					sentencia.append(operadorCondicional).append(" ta.fechaEstimadaFin = ?");
					operadorCondicional = "AND";
					parametros.add(entity.getFecha().getFechaEstimadaFin());
				}
			}
			
			if(!UtilObjeto.esNulo(entity.getPrioridad())) {
				sentencia.append(operadorCondicional).append(" pri.idPrioridad = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getPrioridad().getIdPrioridad());
			}
			
			if(!UtilObjeto.esNulo(entity.getEstado())) {
				sentencia.append(operadorCondicional).append(" es.idEstado = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getEstado().getIdEstado());
			}
			
			if(!UtilObjeto.esNulo(entity.getListaTareas())) {
				sentencia.append(operadorCondicional).append(" li.idLista = ?");
				parametros.add(entity.getListaTareas().getIdListaTareas());
			}
		}
		
		sentencia.append("ORDER BY ta.fechaCreacion ");	
		return sentencia.toString();
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000138);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000139);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private final List<TareaEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<TareaEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var tareaEntity = TareaEntity.crear(
						UUID.fromString(resultados.getObject("ta.idTarea").toString()),
						resultados.getString("ta.nombre"),
						resultados.getString("ta.descripcion"),
						FechasEntity.crear(resultados.getDate("ta.fechaCreacion"), resultados.getDate("ta.fechaEstimadaInicio"), resultados.getDate("ta.fechaEstimadaFin")),
						PrioridadEntity.crear(UUID.fromString(resultados.getObject("ta.idPrioridad").toString()), resultados.getString("pri.descripcion")),
						EstadoEntity.crear(UUID.fromString(resultados.getObject("ta.idEstado").toString()), resultados.getString("es.descripcion")),
						ListaTareasEntity.crear(
								UUID.fromString(resultados.getObject("ta.idLista").toString()),
								resultados.getString("li.nombre"), 
								resultados.getString("li.descripcion"), 
								FechasEntity.crear(resultados.getDate("li.fechaCreacion"), resultados.getDate("li.fechaEstimadaInicio"), resultados.getDate("li.fechaEstimadaFin")),
								PrioridadEntity.crear(UUID.fromString(resultados.getObject("li.idPrioridad").toString()), resultados.getString("prili.descripcion")),
								ProyectoEntity.crear(
										UUID.fromString(resultados.getObject("li.idProyecto").toString()), 
										resultados.getString("pr.nombre"), 
										resultados.getString("pr.descripcion"), 
										FechasEntity.crear(resultados.getDate("pr.fechaCreacion"), resultados.getDate("pr.fechaEstimadaInicio"), resultados.getDate("pr.fechaEstimadaFin"))
										)
								)
						);
				listaResultados.add(tareaEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000140);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000131);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000115);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return listaResultados;
	}
}
