package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.TareaEntity;

public interface  TareaDAO {
	void crear(TareaEntity entity);
	void modificar(TareaEntity entity);
	void eliminar(UUID id);
	
	Optional<TareaEntity>consultarPorId(UUID id );
	List <TareaEntity>consultar(TareaEntity entity);
	
	
}
	
