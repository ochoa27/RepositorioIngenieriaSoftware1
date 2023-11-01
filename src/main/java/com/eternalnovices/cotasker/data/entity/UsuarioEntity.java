package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.support.BooleanEntity;

public class UsuarioEntity {
	private UUID idUsuario;
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private BooleanEntity correoElectronicoConfirmado;
	private String contrasena;
	
	private UsuarioEntity(final UUID id, final String nombre, final String apellido, final String correoElectronico,
			final BooleanEntity correoElectronicoConfirmado, final String contrasena) {
		setIdUsuario(id);
		setNombre(nombre);
		setApellido(apellido);
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setContrasena(contrasena);
	}
	
	public static final UsuarioEntity crear(final UUID id, final String nombre, final String apellido, final String correoElectronico,
			final BooleanEntity correoElectronicoConfirmado, final String contrasena) {
		return new UsuarioEntity(id, nombre, apellido, correoElectronico, correoElectronicoConfirmado, contrasena);
	}

	private final void setIdUsuario(final UUID id) {
		this.idUsuario = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final BooleanEntity correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

	private final void setContrasena(final String contrasena) {
		this.contrasena = contrasena;
	}

	public final UUID getIdUsuario() {
		return idUsuario;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getApellido() {
		return apellido;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final BooleanEntity isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	public final String getContrasena() {
		return contrasena;
	}
}
