package com.example.aula.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "tb_local")
	public class Local {
		@Id
		@GeneratedValue( strategy = GenerationType.AUTO)
		private Long id;
		
		@Column( length = 60)
		private String nome;
		@Column( length = 80)
		private String rua;
		@Column( length = 14)
		private int numero;
		@Column( length = 80)
		private String bairro;
		@Column( length = 100)
		private String cidade;
		@Column( length = 30)
		private String estado;
		@Column( length = 10)
		private String cep;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getRua() {
			return rua;
		}
		
		public void setRua(String rua) {
			this.rua = rua;
		}
		
		public int getNumero() {
			return numero;
		}
		
		public void setNumero(int numero) {
			this.numero = numero;
		}
		
		public String getBairro() {
			return bairro;
		}
		
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		
		public String getCidade() {
			return cidade;
		}
		
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		
		public String getEstado() {
			return estado;
		}
		
		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		public String getCep() {
			return cep;
		}
		
		public void setCep(String cep) {
			this.cep = cep;
		}
}