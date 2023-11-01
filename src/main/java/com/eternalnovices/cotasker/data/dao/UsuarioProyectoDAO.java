package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.UsuarioProyectoEntity;

public interface UsuarioProyectoDAO {
	void crear(UsuarioProyectoEntity entity);
	void eliminar(UUID idProyecto, UUID idUsuario);
	
	Optional<UsuarioProyectoEntity>consultarPorId(UUID idProyecto, UUID idUsuario);
	List<UsuarioProyectoEntity>consultar(UsuarioProyectoEntity entity);
	
	
}
