package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.ProyectoEntity;


public interface ProyectoDAO {
	void crear(ProyectoEntity entity);
	void modificar(ProyectoEntity entity);
	void eliminar(UUID id);
	
	Optional<ProyectoEntity>consultarPorId(UUID id );
	List <ProyectoEntity>consultar(ProyectoEntity entity);
}
