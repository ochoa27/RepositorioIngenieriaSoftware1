package com.eternalnovices.cotasker.crosscutting.messages;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.CrosscuttingCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CategoriaMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.TipoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;

public class Mensaje {
	private CodigoMensaje codigo;
	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String contenido;
	
	private Mensaje(final CodigoMensaje codigo, final TipoMensaje tipo, final CategoriaMensaje categoria, final String contenido) {
		setCodigo(codigo);
		setTipo(tipo);
		setCategoria(categoria);
		setContenido(contenido);
	}
	
	public static final Mensaje crear(final CodigoMensaje codigo, final TipoMensaje tipo, final CategoriaMensaje categoria, final String contenido) {
		return new Mensaje(codigo, tipo, categoria, contenido);
	}

	private final void setCodigo(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var  mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var  mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000001);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.codigo = codigo;
	}

	private final void setTipo(final TipoMensaje tipo) {
		this.tipo = UtilObjeto.obtenerValorDefecto(tipo, TipoMensaje.USUARIO);
	}

	private final void setCategoria(final CategoriaMensaje categoria) {
		this.categoria = UtilObjeto.obtenerValorDefecto(categoria, CategoriaMensaje.FATAL);
	}

	private final void setContenido(final String contenido) {
		this.contenido = UtilTexto.aplicarTrim(contenido);
	}

	public final CodigoMensaje getCodigo() {
		return codigo;
	}

	public final TipoMensaje getTipo() {
		return tipo;
	}

	public final CategoriaMensaje getCategoria() {
		return categoria;
	}

	public final String getContenido() {
		return contenido;
	}
}
