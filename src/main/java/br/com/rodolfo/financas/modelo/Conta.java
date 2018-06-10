package br.com.rodolfo.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Conta
 */
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String titular;
    private String numero;
    private String banco;
	private String agencia;
    
    //Relacionamento bidirecional com a classe Movimentacao. Para que a JPA reconheça que ambas as partes estejam no mesmo relacionamento. Precisamos escolher a 'parte forte' que cria o relacionamento (a coluna de chave estrangeira conta_id). Indicamos na anotação OneToMany a coluna/objeto 'conta' (no relacional seria a coluna conta_id) que está na classe Movimentacao. Por padrão o fetch vem LAZY, ao modificar para EAGER a query sempre fará o LEFT OUTER JOIN com movimentação e buscar os dados da realação.
    @OneToMany(mappedBy="conta", fetch=FetchType.EAGER)
	private List<Movimentacao> movimentacoes;

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return String return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return String return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return String return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return List<Movimentacao> return the movimentacaoes
     */
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    /**
     * @param movimentacaoes the movimentacaoes to set
     */
    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

}