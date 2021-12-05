package br.unitins.topicos.a2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.topicos.a2.dao.EmpresaDao;
import br.unitins.topicos.a2.models.Empresa;

@FacesConverter(forClass=Empresa.class)
public class EmpresaConverter implements Converter<Empresa>{

	@Override
	public Empresa getAsObject(FacesContext context, UIComponent component, String value) {
		EmpresaDao dao = new EmpresaDao();
		return dao.buscaPorId(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Empresa value) {
		return value.getId().toString();
	}

}
