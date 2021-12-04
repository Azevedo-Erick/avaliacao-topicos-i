package br.unitins.topicos.a2.util;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import br.unitins.topicos.a2.models.Usuario;


public class Utils {
	public static void redirect(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			System.out.println("Não foi possível realizar o redirecionamento.");
			e.printStackTrace();
		}
	}
	
	private static String hash(String valor) {
		return DigestUtils.sha256Hex(valor);
	}
	
	public static String hash(Usuario usuario) {
		return hash(usuario.getCpf()+usuario.getSenha());
	}
}
