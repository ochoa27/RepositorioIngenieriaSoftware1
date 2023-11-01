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
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class ListaTareaSQLServerDAO extends SQLDAO implements ListaTareaDAO{

	public ListaTareaSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ListaTareasEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO ListaTareas (idLista, nombre, descripcion, fechaCreacion, fechaEstimadaInicio, fechaEstimadaFin, idPrioridad, idProyecto) ");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, entity.getIdListaTareas());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setString(3, entity.getDescripcion());
			sentenciaPreparada.setDate(4, entity.getFecha().getFechaCreacion());
			sentenciaPreparada.setDate(5, entity.getFecha().getFechaEstimadaInicio());
			sentenciaPreparada.setDate(6, entity.getFecha().getFechaEstimadaFin());
			sentenciaPreparada.setObject(7, entity.getPrioridad().getIdPrioridad());
			sentenciaPreparada.setObject(8, entity.getProyecto().getIdProyecto());
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000165);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000166);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000165);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000167);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public void modificar(ListaTareasEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE ListaTareas ");
		sentencia.append("SET nombre = ?, descripcion = ?, fechaCreacion = ?, fechaEstimadaInicio = ?, fechaEstimadaFin = ?, idPrioridad = ?, idProyecto = ? ");
		sentencia.append("WHERE idLista = ? ");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setString(2, entity.getDescripcion());
			sentenciaPreparada.setDate(3, entity.getFecha().getFechaCreacion());
			sentenciaPreparada.setDate(4, entity.getFecha().getFechaEstimadaInicio());
			sentenciaPreparada.setDate(5, entity.getFecha().getFechaEstimadaFin());
			sentenciaPreparada.setObject(6, entity.getPrioridad().getIdPrioridad());
			sentenciaPreparada.setObject(8, entity.getProyecto().getIdProyecto());
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000163);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000162);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000163);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000164);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
		

	@Override
	public void eliminar(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("DELETE FROM ListaTareas ");
		sentencia.append("WHERE idLista = ? ");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000168);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000169);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (final Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000168);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000170);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public Optional<ListaTareasEntity> consultarPorId(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT li.idLista, li.nombre, li.descripcion, li.fechaCreacion, li.fechaEstimadaInicio, li.fechaEstimadaFin, li.idPrioridad, pri.descripcion, "
				+ "li.idProyecto, po.nombre, po.descripcion, po.fechaCreacion, po.fechaEstimadaInicio, po.fechaEstimadaFin ");
		sentencia.append("FROM  ListaTareas li ");
		sentencia.append("JOIN  Prioridad pri ");
		sentencia.append("	ON   li.idPrioridad = pri.IdPrioridad ");
		sentencia.append("JOIN  Proyecto po ");
		sentencia.append("	ON  po.idProyecto = li.idProyecto ");
		sentencia.append("WHERE ta.idLista = ? ");

		Optional<ListaTareasEntity> resultado = Optional.empty();
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000172);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000173);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}

		return resultado;
	}

	@Override
	public List<ListaTareasEntity> consultar(ListaTareasEntity entity) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000176);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000177);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private final Optional<ListaTareasEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){	
		Optional<ListaTareasEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var listaTareaEntity = ListaTareasEntity.crear(
						UUID.fromString(resultados.getObject("li.idLista").toString()),
						resultados.getString("li.nombre"),
						resultados.getString("li.descripcion"),
						FechasEntity.crear(resultados.getDate("li.fechaCreacion"), resultados.getDate("li.fechaEstimadaInicio"), resultados.getDate("li.fechaEstimadaFin")),
						PrioridadEntity.crear(UUID.fromString(resultados.getObject("li.idPrioridad").toString()), resultados.getString("pri.descripcion")),
						ProyectoEntity.crear(
								UUID.fromString(resultados.getObject("li.idProyecto").toString()),
								resultados.getString("po.nombre"), 
								resultados.getString("po.descripcion"), 
								FechasEntity.crear(resultados.getDate("po.fechaCreacion"), resultados.getDate("po.fechaEstimadaInicio"), resultados.getDate("po.fechaEstimadaFin"))
								)
						);
				resultado = Optional.of(listaTareaEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000174);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000175);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return resultado;
	}

	private String formarSentenciaConsulta(final ListaTareasEntity entity, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT li.idLista, li.nombre, li.descripcion, li.fechaCreacion, li.fechaEstimadaInicio, li.fechaEstimadaFin, li.idPrioridad, pri.descripcion, "
				+ "li.idProyecto, po.nombre, po.descripcion, po.fechaCreacion, po.fechaEstimadaInicio, po.fechaEstimadaFin ");
		sentencia.append("FROM  ListaTareas li ");
		sentencia.append("JOIN  Prioridad pri ");
		sentencia.append("	ON   li.idPrioridad = pri.IdPrioridad ");
		sentencia.append("JOIN  Proyecto po ");
		sentencia.append("	ON  po.idProyecto = li.idProyecto ");
		
		if(!UtilObjeto.esNulo(entity)) {
			if(!UtilUUID.esNulo(entity.getIdListaTareas())) {
				sentencia.append(operadorCondicional).append(" li.idLista = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getIdListaTareas());
			}
			
			if(!UtilTexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" li.nombre = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			
			if(!UtilTexto.estaVacio(entity.getDescripcion())) {
				sentencia.append(operadorCondicional).append(" li.descripcion = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getDescripcion());
			}
			
			if(!UtilObjeto.esNulo(entity.getFecha())) {
				if(!UtilFecha.esNulo(entity.getFecha().getFechaCreacion())) {
					sentencia.append(operadorCondicional).append(" li.fechaCreacion = ?");
					operadorCondicional = "AND";
					parametros.add(entity.getFecha().getFechaCreacion());
				}
				
				if(!UtilFecha.esNulo(entity.getFecha().getFechaEstimadaInicio())) {
					sentencia.append(operadorCondicional).append(" li.fechaEstimadaInicio = ?");
					operadorCondicional = "AND";
					parametros.add(entity.getFecha().getFechaEstimadaInicio());
				}
				
				if(!UtilFecha.esNulo(entity.getFecha().getFechaEstimadaFin())) {
					sentencia.append(operadorCondicional).append(" li.fechaEstimadaFin = ?");
					operadorCondicional = "AND";
					parametros.add(entity.getFecha().getFechaEstimadaFin());
				}
			}
			
			if(!UtilObjeto.esNulo(entity.getPrioridad())) {
				sentencia.append(operadorCondicional).append(" li.idPrioridad = ?");
				operadorCondicional = "AND";
				parametros.add(entity.getPrioridad().getIdPrioridad());
			}
			
			
			if(!UtilObjeto.esNulo(entity.getProyecto())) {
				sentencia.append(operadorCondicional).append(" li.idProyecto = ?");
				parametros.add(entity.getProyecto().getIdProyecto());
			}
		}
		
		sentencia.append("ORDER BY li.fechaCreacion ");	
		return sentencia.toString();
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000178);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000179);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private final List<ListaTareasEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<ListaTareasEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var listaTareasEntity = ListaTareasEntity.crear(
						UUID.fromString(resultados.getObject("li.idLista").toString()),
						resultados.getString("li.nombre"),
						resultados.getString("li.descripcion"),
						FechasEntity.crear(resultados.getDate("li.fechaCreacion"), resultados.getDate("li.fechaEstimadaInicio"), resultados.getDate("li.fechaEstimadaFin")),
						PrioridadEntity.crear(UUID.fromString(resultados.getObject("li.idPrioridad").toString()), resultados.getString("pri.descripcion")),
						ProyectoEntity.crear(
								UUID.fromString(resultados.getObject("li.idProyecto").toString()), 
								resultados.getString("pr.nombre"), 
								resultados.getString("pr.descripcion"), 
								FechasEntity.crear(resultados.getDate("pr.fechaCreacion"), resultados.getDate("pr.fechaEstimadaInicio"), resultados.getDate("pr.fechaEstimadaFin"))));
				listaResultados.add(listaTareasEntity);		
				}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000180);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000171);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000181);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return listaResultados;
	}

}
