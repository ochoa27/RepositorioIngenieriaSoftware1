package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;


public interface ListaTareaDAO {
	void crear(ListaTareasEntity entity);
	void modificar(ListaTareasEntity entity);
	void eliminar(UUID id);
	
	Optional<ListaTareasEntity>consultarPorId(UUID id );
	List <ListaTareasEntity>consultar(ListaTareasEntity entity);
}
