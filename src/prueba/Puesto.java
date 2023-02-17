package prueba;

import java.util.ArrayList;

public class Puesto {

	private String codigo;
	private boolean reservado;
	private Persona persona;

	private static ArrayList<Puesto> listaOrdenadores = new ArrayList<>();

	public Puesto() {

	}

	public Puesto(String codigo) {
		this.codigo = codigo;
		this.reservado = false;
	}

	public Puesto(String codigo, boolean reservado, Persona persona) {
		this.codigo = codigo;
		this.reservado = reservado;
		this.persona = persona;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public static ArrayList<Puesto> getListaOrdenadores() {
		return listaOrdenadores;
	}

	public static void setListaOrdenadores(ArrayList<Puesto> listaOrdenadores) {
		Puesto.listaOrdenadores = listaOrdenadores;
	}

	@Override
	public String toString() {
		return "Puesto [codigo=" + codigo + ", reservado=" + reservado + ", persona=" + persona + "]";
	}

	public static void mostrar(boolean reservado, String txt) {
		
		for (Puesto puesto : Puesto.getListaOrdenadores()) {
			if (puesto.isReservado() == reservado) {
				System.out.println(txt + " PUESTO " + puesto.toString());
				
			}
		}

	}
	
	public static int numeroPuestos(boolean reservado) {
		
		int contador = 0;
		for (Puesto puesto : listaOrdenadores) {
			if (puesto.isReservado() == reservado) {
			contador++;
			}
		}
		return contador;
	}
}
