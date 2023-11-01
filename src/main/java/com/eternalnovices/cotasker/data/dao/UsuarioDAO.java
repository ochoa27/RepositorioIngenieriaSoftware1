package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.UsuarioEntity;

public interface UsuarioDAO {
	void crear(UsuarioEntity entity);
	void modificar(UsuarioEntity entity);
	void eliminar(UUID id);
	
	
	Optional<UsuarioEntity>consultarPorId(UUID id);
	List<UsuarioEntity>consultar(UsuarioEntity entity);

}
