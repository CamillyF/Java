/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Cliente {
    private int id_cliente, telefone, cnh, numero, telefonemer, renda ;
    private String rg, nome, endereco, complemento, cpf, cidade, estado, sexo, datanas;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatanas() {
        return datanas;
    }

    public void setDatanas(String dtanas) {
        this.datanas = dtanas;
    }

    public int getTelefonemer() {
        return telefonemer;
    }

    public void setTelefonemer(int telefonemer) {
        this.telefonemer = telefonemer;
    }

    public int getRenda() {
        return renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
   
  public void setId(int i) throws Exception {
      if (i > 0){
            this.id_cliente = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId() {
      return this.id_cliente;
  }
  
  public int getCnh() {
        return this.cnh;
    }

  public void setCnh(int cnh) {
        this.cnh = cnh;
    }
  
  public String getRG() {
        return this.rg;
    }

  public void setRG(String rg) {
        this.rg = rg;
    }
  
  public int getTelefone() {
        return this.telefone;
    }

  public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
  
  public String getNome() {
        return this.nome;
    }

  public void setNome(String nome) {
        this.nome = nome;
    }
  
  public String getEndereco() {
        return this.endereco;
    }

  public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

  

}
