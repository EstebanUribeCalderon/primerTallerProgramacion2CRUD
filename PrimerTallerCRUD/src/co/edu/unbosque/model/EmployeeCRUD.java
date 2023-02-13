package co.edu.unbosque.model;

import java.util.ArrayList;

public class EmployeeCRUD {
	
	private ArrayList<Candidate> list;
	private Candidate candidate;
	
	public EmployeeCRUD() {
		
		list = new ArrayList<>();
	}
	
	public void create(String name, String lastName, String id, String age, String workStation) {
		
		candidate = new Candidate(name, lastName, id, age, workStation);
		list.add(candidate);
	}
	
	public void delete(String id) {
		
		for(int i=0; i<list.size(); i++ ) {
			if(id.equals(list.get(i).getId())) {
				list.remove(i);
			}
		}
	}
	
	public String read(String id) {
		
		String result = null;
		
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i).getId())) {
				result = "El candidato buscado es: [Nombre = " + list.get(i).getName() + ", Apellido = " + list.get(i).getLastName() + ", Cedula = " + list.get(i).getId() + ", edad = " + list.get(i).getAge() + ", cargo = "
						+ list.get(i).getWorkStation()+ "]";;
			}
		}
		return result;
	}
	
	public void update(String id, String newName, String newLastName, String newId, String newAge, String newWorkStation) {
		
		for(int i=0; i<list.size(); i++ ) {
			if(id.equals(list.get(i).getId())) {
				list.get(i).setName(newName);
				list.get(i).setLastName(newLastName);
				list.get(i).setId(newId);
				list.get(i).setAge(newAge);
				list.get(i).setWorkStation(newWorkStation);
				}
		}
	}
	
	public void showList() {
		System.out.println("\nLos candidatos de la lista son:\n");
		int i = 0;
		for(i=0; i<list.size(); i++){
			
				System.out.println("\n"+"Candidato "+ (i+1) +"\n"+"Nombre: " 
						+list.get(i).getName()+"\nApellido: "
						+list.get(i).getLastName()+"\nCedula: "
						+list.get(i).getId()+"\nEdad: "
						+list.get(i).getAge()+"\nCargo: "
						+list.get(i).getWorkStation());
		}		
	}

}
