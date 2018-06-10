package br.com.rodolfo.financas.modelo;

public class DataTransferObject {

    private String numero;
    private String agencia;

    public DataTransferObject(String numero, String agencia) {

        this.numero = numero;
        this.agencia = agencia;
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

}