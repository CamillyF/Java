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
public class Veiculo {
    private int id_veiculo, id_marca, id_modelo, id_cliente;
    private String placa, cadastro, cor, ano, cadastro_loc;
    
       
  public void setId(int i) throws Exception {
      if (i > 0){
            this.id_veiculo = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId() {
      return this.id_veiculo;
  }
  
  
   public void setid_marca(int i) throws Exception {
      if (i > 0){
            this.id_marca = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  public int getid_marca() {
      return this.id_marca;
  }
  
  
   public void setid_modelo(int i) throws Exception {
      if (i > 0){
            this.id_modelo = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  public int getid_modelo() {
      return this.id_modelo;
  }
  
  
  public void setid_cliente(int i) throws Exception {
      if (i > 0){
            this.id_cliente = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  public int getid_cliente() {
      return this.id_cliente;
  }
  
   public String getPlaca() {
        return this.placa;
    }

  public void setPlaca(String placa) {
        this.placa = placa;
    }
  
   public String getCadastro() {
        return this.cadastro;
    }

  public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }
  
   public String getCor() {
        return this.cor;
    }

  public void setCor(String cor) {
        this.cor = cor;
    }
  
   public String getAno() {
        return this.ano;
    }

  public void setAno(String ano) {
        this.ano = ano;
    }
  
   public String getCadastroLoc() {
        return this.cadastro_loc;
    }

  public void setCadastroLoc(String cadastro_loc) {
        this.cadastro_loc = cadastro_loc;
    }
}

    

