package co.edu.unbosque.model;

public class Candidate {
	
	private String name;
	private String lastName;
	private String id;
	private String age;
	private String workStation;
	
	public Candidate(String name, String lastName, String id, String number, String workStation) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.age = number;
		this.workStation = workStation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWorkStation() {
		return workStation;
	}

	public void setWorkStation(String workStation) {
		this.workStation = workStation;
	}
	
	@Override
	public String toString() {
		return "Candidatos [Nombre = " + name + ", Apellido = " + lastName + ", Cedula = " + id + ", edad = " + age + ", cargo = "
				+ workStation + "]";
	}
	
	
	

}
