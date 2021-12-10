package br.unitins.topicos.a2.util;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;
import br.unitins.topicos.a2.models.Usuario;

public class Utils {
	public static void redirect(String page) {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + page);
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
	
	private static void addMessage(String msg, Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, null));
	}
	
	public static void addErrorMessage(String msg) {
		addMessage(msg,FacesMessage.SEVERITY_ERROR);
	}
	
	public static void addWarnMessage(String msg) {
		addMessage(msg,FacesMessage.SEVERITY_WARN);
	}
	
	public static void addInfoMessage(String msg) {
		addMessage(msg,FacesMessage.SEVERITY_INFO);
	}
	
	public static String formatPrice(Double price) {
		 DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
		 return formatter.format(price);
	}
}
