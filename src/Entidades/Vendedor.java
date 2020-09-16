package Entidades;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String email;
	private Date dataDeAniversário;
	private double salario;
	
	private Departamento departamento;
	
	public Vendedor() {}
	


	public Vendedor(Integer id, String nome, String email, Date dataDeAniversário, double salario,
			Departamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataDeAniversário = dataDeAniversário;
		this.salario = salario;
		this.departamento = departamento;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDataDeAniversário() {
		return dataDeAniversário;
	}



	public void setDataDeAniversário(Date dataDeAniversário) {
		this.dataDeAniversário = dataDeAniversário;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", dataDeAniversário=" + dataDeAniversário
				+ ", salario=" + salario + ", departamento=" + departamento + "]";
	}
	
	
	

}
