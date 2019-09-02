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
    private int id_cliente, telefone, cnh;
    private String rg, nome, endereco;
   
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

  public void setCnh() {
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

  public void setTelefone() {
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
