package prueba;


import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner scTXT = new Scanner(System.in);
		int opcion = 0;

		final String MENU = "Introduzca la opción deseada:\n1. Crear puesto\n2. Eliminar puesto\n3. Reservar puesto\n4. Listar ordenadores reservados\n5. Listar ordenadores disponibles\n6. Salir";

		do {
			System.out.println(MENU);

			try {

				opcion = sc.nextInt();

				switch (opcion) {

				case 1:

					System.out.println("Introduzca el puesto que se va a dar de alta:");
					String codigo = scTXT.nextLine();

					Puesto p = new Puesto(codigo);
					Puesto.getListaOrdenadores().add(p);

					break;
				case 2:
					Puesto puestoBorrar = null;
					System.out.println("Introduce el ID del puesto que quieres eliminar:");
					String codPC = scTXT.nextLine();
					for (Puesto pc : Puesto.getListaOrdenadores()) {
						if (codPC.equalsIgnoreCase(pc.getCodigo())) {
							// Puesto.getListaOrdenadores().remove(pc);
							puestoBorrar = pc;
							break;
						}
					}

					if (puestoBorrar == null) {
						System.err.println("NO EXISTE EL PUESTO CON CÓDIGO " + codPC);
					}

					Puesto.getListaOrdenadores().remove(puestoBorrar);
					break;
				case 3:
					if (Puesto.getListaOrdenadores().size() > 0 && Puesto.numeroPuestos(false) > 0) {
						System.out.println("Introduzca su nombre:");
						String nombre = scTXT.nextLine();
						System.out.println("Introduzca su DNI:");
						String dni = scTXT.nextLine();

						Persona per = new Persona(dni, nombre);

						for (Puesto puesto : Puesto.getListaOrdenadores()) {
							if (!puesto.isReservado()) {
								puesto.setReservado(true);
								puesto.setPersona(per);
								break;
							}
						}
					} else {
						System.out.println("No existen puestos");
					}
					break;
				case 4:

					Puesto.mostrar(true, "PUESTO RESERVADO - ");
					/*
					 * for (Puesto puesto : Puesto.getListaOrdenadores()) { if
					 * (puesto.isReservado()) { System.out.println(puesto.getCodigo() +
					 * "RESERVADO"); } }
					 */
					break;
				case 5:

					Puesto.mostrar(false, "PUESTO DISPONIBLE - ");
					/*
					 * for (Puesto puesto : Puesto.getListaOrdenadores()) { if
					 * (!puesto.isReservado()) { System.out.println(puesto.getCodigo() +
					 * "NO RESERVADO"); } }
					 */
					break;
				case 6:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida");
					break;
				}

			} catch (InputMismatchException e) {
				e.printStackTrace();

				System.err.println("Error al introducir la opción.");
				sc.next();
			} catch (ConcurrentModificationException e) {
				System.out.println("Error al al recorrer el array.");
			}
		} while (opcion != 6);

	}

	
}
