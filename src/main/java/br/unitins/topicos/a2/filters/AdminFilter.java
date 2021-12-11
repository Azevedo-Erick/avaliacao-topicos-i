package br.unitins.topicos.a2.filters;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Session;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/pages/admin/*"} )
public class AdminFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		// retorna uma sessao corrente (false - nao cria uma nova estrutura de sessao)
				HttpSession session =  servletRequest.getSession(false);
				Usuario usuarioLogado = null;
				if (session != null) {
					usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
				}
				
				// se nao for admin ou nao estiver logado, redirecionar para o index
				if(usuarioLogado != null) {
				if (usuarioLogado.getPerfil().getId() == 2) {
					((HttpServletResponse)response).sendRedirect("/A2/pages/index.xhtml");
				}
				} else if(usuarioLogado == null) {
					((HttpServletResponse)response).sendRedirect("/A2/pages/index.xhtml");
				}
						// permitindo a execucao completa do protocolo
						chain.doFilter(request, response);
					 
				}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("Filtro AdminFilter inicializado.");
	}
		
}

