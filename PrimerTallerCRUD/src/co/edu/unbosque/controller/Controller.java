package co.edu.unbosque.controller;

import co.edu.unbosque.model.EmployeeCRUD;
import co.edu.unbosque.view.View;

public class Controller {
	
	private EmployeeCRUD emp;
	private View view;
	
	
	public Controller() {
		emp = new EmployeeCRUD();
		view = new View();
		run();
	}
	
	public void run() {
		menu();
		
	}
	
	private void menu() {
		String option = view.readInfo("\n \nIngresa la opción: "
									 + "\n1. Agregar Candidato "
									 + "\n2. Eliminar Candidato "
									 + "\n3. Ver arreglo "
									 + "\n4. Modificar Candidato "
									 + "\n5. Buscar Candidato "
									 + "\n0. Salir");
		
		switch (option) {
		case "1":
			//String nombre, String apellido, String cedula, int edad, String cargo
			String newName = view.readInfo("\nIngrese nombre del candidato: ");
			String newLastName = view.readInfo("\nIngrese apellido del cantidato: ");
			String newId = view.readInfo("\nIngrese cedula del candidato: ");
			String newAge = view.readInfo("\nIngrese edad del candidato: ");
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
				String newCandidateName = view.readInfo("Ingrese nuevo nombre: ");
				String newCandidateLastName = view.readInfo("Ingrese nuevo apellido: ");
				String newCandidateAge = view.readInfo("Ingrese nueva edad: ");
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
		
		
		
	}

}
