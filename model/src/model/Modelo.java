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
public class Modelo {
    private int id_modelo;
    private String nome;
       
  public void setId(int i) throws Exception {
      if (i > 0){
            this.id_modelo = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId() {
      return this.id_modelo;
  }
  
  public String getNome() {
        return this.nome;
    }

  public void setNome(String nome) {
        this.nome = nome;
    }
}
