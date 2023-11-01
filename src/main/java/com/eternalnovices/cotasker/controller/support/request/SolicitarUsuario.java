package com.eternalnovices.cotasker.controller.support.request;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class SolicitarUsuario {
	private UUID idUsuario;
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private Boolean correoElectronicoConfirmado;
	private String contrasena;
	
	public SolicitarUsuario() {
		setIdUsuario(UtilUUID.UUIDDEFECTO);
		setNombre(UtilTexto.VACIO);
		setApellido(UtilTexto.VACIO);
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
		setContrasena(UtilTexto.VACIO);
	}
	
	public SolicitarUsuario(final UUID idUsuario, final String nombre, final String apellido, final String correoElectronico,
			final Boolean correoElectronicoConfirmado, final String contrasena) {
		setIdUsuario(idUsuario);
		setNombre(nombre);
		setApellido(apellido);
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setContrasena(contrasena);
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
	
	public final Boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	
	public final String getContrasena() {
		return contrasena;
	}

	public final void setIdUsuario(final UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public final void setCorreoElectronicoConfirmado(final Boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

	public final void setContrasena(final String contrasena) {
		this.contrasena = contrasena;
	}
}
