package co.edu.unbosque.controller;

import co.edu.unbosque.model.EmployeeCRUD;
import co.edu.unbosque.view.View;

/**
 * Esta clase une la logica de los candidatos con la interaccion del usuario
 * @author: Esteban Uribe Calderon
 * @version: 12/02/2023
 */
public class Controller {
	//Variables de la clase
	private EmployeeCRUD emp;
	private View view;
	
	 /**
     * Constructor para la interaccion de los candidatos y de la vista
     */
	public Controller() {
		emp = new EmployeeCRUD();
		view = new View();
		run();
	}//cierre del constructor
	
	 /**
     * Metodo funcionar del programa
     */
	public void run() {
		menu();
		
	}//cierre del método
	
	 /**
     * Metodo que despliega el menu y su logica de interacción y manipulación de los candidatos
     */
	public void menu() {
		
		String option = view.readInfo("\n \nIngresa la opción: "
									 + "\n1. Agregar Candidato "
									 + "\n2. Eliminar Candidato "
									 + "\n3. Ver Candidatos "
									 + "\n4. Modificar Candidato "
									 + "\n5. Buscar Candidato "
									 + "\n0. Salir");
		
		switch (option) {
		
		case "1":
			//String nombre, String apellido, String cedula, int edad, String cargo
			String newName = view.readInfo("\nIngrese nombre del candidato: ");
			if(newName.matches(".*[0-9].*")) {
				view.showMessage("¡ERROR! Ingrese un nombre valido");
				menu();
			}
			String newLastName = view.readInfo("\nIngrese apellido del cantidato: ");
			if(newLastName.matches(".*[0-9].*")) {
				view.showMessage("¡ERROR! Ingrese un apellido valido");
				menu();
			}
			String newId = view.readInfo("\nIngrese cedula del candidato: ");
			for (int i = 0; i < newId.length(); i++) {
	            if (!Character.isDigit(newId.charAt(i))) {
	            	view.showMessage("¡ERROR! Ingrese una cedula valida");
					menu();
	            }
			}
			String newAge = view.readInfo("\nIngrese edad del candidato: ");
			for (int i = 0; i < newId.length(); i++) {
	            if (!Character.isDigit(newId.charAt(i))) {
	            	view.showMessage("¡ERROR! Ingrese una edad valida");
					menu();
	            }
			}
			String newWorkstation = view.readInfo("\nIngrese cargo del candidato: ");
			
			emp.create(newName, newLastName, newId, newAge, newWorkstation);
			menu();
		break;
		
		case "2":
			String idToDelete = view.readInfo("\nIngrese el numero de cedula del candidato que desea eliminar: ");
			emp.delete(idToDelete);
			menu();
		break;
		
		case "3":
			emp.showList();
			menu();
		break;
		
		case "4":
			String candidateId = view.readInfo("\nIngrese la cedula del candidato a buscar: ");
			if(emp.read(candidateId)!=null) {
				String newCandidateId = view.readInfo("Ingrese el nuevo numero de cedula: ");
				for (int i = 0; i < newCandidateId.length(); i++) {
		            if (!Character.isDigit(newCandidateId.charAt(i))) {
		            	view.showMessage("¡ERROR! Ingrese una cedula valida");
						menu();
		            }
				}
				
				String newCandidateName = view.readInfo("Ingrese nuevo nombre: ");
				if(newCandidateName.matches(".*[0-9].*")) {
					view.showMessage("¡ERROR! Ingrese un nombre valido");
					menu();
				}
				
				String newCandidateLastName = view.readInfo("Ingrese nuevo apellido: ");
				if(newCandidateLastName.matches(".*[0-9].*")) {
					view.showMessage("¡ERROR! Ingrese un apellido valido");
					menu();
				}
				String newCandidateAge = view.readInfo("Ingrese nueva edad: ");
				for (int i = 0; i < newCandidateId.length(); i++) {
		            if (!Character.isDigit(newCandidateId.charAt(i))) {
		            	view.showMessage("¡ERROR! Ingrese una edad valida");
						menu();
		            }
				}
				String newCandidateWorkstation = view.readInfo("Ingrese nuevo cargo: ");
				
				emp.update(candidateId, newCandidateName, newCandidateLastName, newCandidateId, newCandidateAge, newCandidateWorkstation);
				
			}else view.showMessage("Este candidato no existe");
		    
			menu();
			
		case "5":
			String cedulaABuscar = view.readInfo("\nIngrese la cedula del candidato a buscar: ");
			
			if(emp.read(cedulaABuscar)!=null) {
				view.showMessage(emp.read(cedulaABuscar));
			}else view.showMessage("El candidato con la cedula ingresada no existe");
			
			menu();
			
		break;
		case "0":
			view.readInfo("¡Adios!");
			break;
		default:
			view.readInfo("¡Número no reconocido!");
			menu();
			break;
	}
		
		
		
	}//Cierre del metodo

}//Cierre de la clase
