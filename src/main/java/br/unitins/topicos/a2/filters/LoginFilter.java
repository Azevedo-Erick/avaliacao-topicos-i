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

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/login.xhtml"} )
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		// retorna uma sessao corrente (false - nao cria uma nova estrutura de sessao)
				HttpSession session =  servletRequest.getSession(false);
				Usuario usuarioLogado = null;
				if (session != null)
					usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
				
				// se estiver logado, redirecionar para o index
				if (usuarioLogado != null) {
					((HttpServletResponse)response).sendRedirect("/index.xhtml");
				} else {
						// permitindo a execucao comleta do protocolo
						chain.doFilter(request, response);
					} 
				}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("Filtro LoginFilter inicializado.");
	}
		
}

