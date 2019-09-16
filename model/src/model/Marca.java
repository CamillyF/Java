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
public class Marca {
    private int id_marca;
    private String nome;
       
  public void setId(int i) throws Exception {
      if (i > 0){
            this.id_marca = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId() {
      return this.id_marca;
  }
  
  public String getNome() {
        return this.nome;
    }

  public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
