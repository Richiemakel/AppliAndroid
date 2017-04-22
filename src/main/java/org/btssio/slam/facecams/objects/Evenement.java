package org.btssio.slam.facecams.objects;


public class Evenement {

	private String nom = null;
	private String date = null;
	private String list = null;
	private String nombre = null;
	private String type = null;


	public Evenement() {
		super();
		this.nom = "";
		this.date = "";
		this.list = "";
		this.nombre = "";
		this.type = "";

	}

	public Evenement(String nom, String date, String  list, String nombre, String type) {
		super();
		this.nom = nom;
		this.date = date;
		this.list = list;
		this.nombre = nombre;
		this.type = type;
	}

	public void setNom(String value) {
		nom = value;
	}

	public void setDate(String value) {
		date = value;
	}

	public void setList(String value) {list = value;}
	public void setNombre(String value) {
		nombre = value;
	}
	public void setType(String value) {
		type = value;
	}


	public String getNom() {
		return nom;
	}

	public String getDate() {
		return date;
	}
	public String getList() {
		return list;
	}
	public String getNombre() {
		return nombre;
	}
	public String getType() {  return type;  }

	@Override
	public String toString() {
		return nom + " " + date + " "+list +" "+nombre +" "+type ;
	}
}
