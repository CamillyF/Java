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
public class Proprietario {
    private int id_proprietario, lucros, gastos;
    private String nome, acesso_locacao;
    
       
  public void setId(int i) throws Exception {
      if (i > 0){
            this.id_proprietario = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId() {
      return this.id_proprietario;
  }
  
   public int getLucros() {
        return this.lucros;
    }

  public void setLucros() {
        this.lucros = lucros;
    }
  
   public int getGastos() {
        return this.gastos;
    }

  public void setGastos() {
        this.gastos = gastos;
    }
  
   public String getNome() {
        return this.nome;
    }

  public void setNome(String nome) {
        this.nome = nome;
    }
  
   public String getAcessoLocacao() {
        return this.acesso_locacao;
    }

  public void setAcessoLocacao(String acessolocacao) {
        this.acesso_locacao = acesso_locacao;
    }

    public void setGastos(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLucros(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}


