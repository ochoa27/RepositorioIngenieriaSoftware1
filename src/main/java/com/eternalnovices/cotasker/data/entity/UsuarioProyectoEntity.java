package com.eternalnovices.cotasker.data.entity;

public class UsuarioProyectoEntity {
	private ProyectoEntity proyecto;
	private UsuarioEntity usuario;
	
	private UsuarioProyectoEntity(final ProyectoEntity proyecto, final UsuarioEntity usuario) {
		setProyecto(proyecto);
		setUsuario(usuario);
	}

	public static final UsuarioProyectoEntity crear(final ProyectoEntity proyecto, final UsuarioEntity usuario) {
		return new UsuarioProyectoEntity(proyecto, usuario);
	}
	
	public final ProyectoEntity getProyecto() {
		return proyecto;
	}

	public final UsuarioEntity getUsuario() {
		return usuario;
	}

	private final void setProyecto(final ProyectoEntity proyecto) {
		this.proyecto = proyecto;
	}

	private final void setUsuario(final UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}
