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
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;

public class PrioridadSQLServerDAO extends SQLDAO implements PrioridadDAO {

	public PrioridadSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void modificar(final PrioridadEntity prioridad) {
		final var sentencia = new StringBuilder();
		sentencia.append("UPDATE Prioridad");
		sentencia.append("SET descripcion=?, ");
		sentencia.append("WHERE idPrioridad=? ");
		try (final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setString(1, prioridad.getDescripcion());
			sentenciaPreparada.setObject(2, prioridad.getIdPrioridad());
			
			sentenciaPreparada.executeUpdate();
		} catch (final SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000040);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000041);
			throw DataCoTaskerException.crear(e,mensajeUsuario,mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000040);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000042);
			throw DataCoTaskerException.crear(e,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final Optional<PrioridadEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT prio.idPrioridad,prio.descripcion ");
		sentencia.append("FROM Prioridad prio");
		sentencia.append("WHERE idPrioridad=?");
		
		Optional<PrioridadEntity> resultado= Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			resultado=ejecutarConsultaPorId(sentenciaPreparada);
			
		}catch(DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000033);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000035);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000033);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000036);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	

	private final  Optional<PrioridadEntity> ejecutarConsultaPorId(PreparedStatement sentenciaPreparada) {
		Optional<PrioridadEntity>resultado=Optional.empty();
		try(final var resultados=sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var prioridadEntity=PrioridadEntity.crear(
						UUID.fromString(resultados.getObject("prio.idPrioridad").toString()),
						resultados.getString("prio.descripcion"));
				resultado=Optional.of(prioridadEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000044);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000045);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public final List<PrioridadEntity> consultar(final PrioridadEntity prioridad) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(prioridad, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000047);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000048);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private String formarSentenciaConsulta(PrioridadEntity prioridad, ArrayList<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT prio.idPrioridad,prio.descripcion ");
		sentencia.append("FROM Prioridad prio ");
		
		if(!UtilObjeto.esNulo(prioridad)) {
			if(!UtilObjeto.esNulo(prioridad.getIdPrioridad())) {
				sentencia.append(operadorCondicional).append(" prio.idPrioridad = ? ");
				operadorCondicional="AND";
				parametros.add(prioridad.getIdPrioridad());
			}
			
			if(!UtilTexto.estaVacio(prioridad.getDescripcion())) {
				sentencia.append(operadorCondicional).append(" prio.descripcion=? ");
				parametros.add(prioridad.getDescripcion());
			}
		}
				
		return sentencia.toString();
	}

	private List<PrioridadEntity> ejecutarConsulta(PreparedStatement sentenciaPreparada) {
		final var listaResultados = new ArrayList<PrioridadEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var  prioridadEntity=PrioridadEntity.crear(
						UUID.fromString(resultados.getObject("prio.idPrioridad").toString()),
						resultados.getString("prio.descripcion"));
						
				listaResultados.add(prioridadEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000053);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000054);
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000050);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000051);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
		
}
	


