package br.com.rodolfo.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Conta
 */
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String titular;
    private String numero;
    private String banco;
    private String agencia;

	public String getTitular()
	{
		return this.titular;
	}

	public void setTitular(String titular)
	{
		this.titular = titular;
	}

	public String getNumero()
	{
		return this.numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getBanco()
	{
		return this.banco;
	}

	public void setBanco(String banco)
	{
		this.banco = banco;
	}

	public String getAgencia()
	{
		return this.agencia;
	}

	public void setAgencia(String agencia)
	{
		this.agencia = agencia;
	}




}