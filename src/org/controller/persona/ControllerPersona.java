package org.controller.persona;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.persona.DaoPersona;
import org.modelo.persona.Persona;

@ManagedBean
@ViewScoped
public class ControllerPersona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Persona> listaPersonas = null;
	private Persona persona = null;
	
	//CONSTRUCTOR SUPERCLASS
	public ControllerPersona() {
		super();
		persona = new Persona();
	}

	//GETTERS AND SETTERS OF LISTAPERSONAS
	public List<Persona> getListaPersonas() {
		DaoPersona daoPersona = new DaoPersona();
		listaPersonas = daoPersona.selectPersona();
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	//GETTERS AND SETTERS OF PERSONA
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	//METHODS CRUD
	public void limpiarPersona() {
		 persona = new Persona();
	}
	public String agregarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.addPersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	public String modificarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.updatePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	public String eliminarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.deletePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	
}