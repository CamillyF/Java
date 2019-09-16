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
public class Aluguel {
  private int id_aluguel, id_cliente, id_proprietario, dias_locados, valor_diaria, valor_total, data_locacao;
  private String pagamento;
    
  public void setId(int i) throws Exception {
      if (i > 0){
            this.id_aluguel = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId() {
      return this.id_aluguel;
  }
  
  
  
  public void setId_cliente(int i) throws Exception {
      if (i > 0){
            this.id_cliente = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  public int getId_cliente() {
      return this.id_cliente;
  }
  
  
  
   public void setId_proprietario(int i) throws Exception {
      if (i > 0){
            this.id_proprietario = i;
         
      } else {
          throw new Exception("id nao pode ser menor ou igual a zero");
      }
  }
  
  public int getId_proprietario() {
      return this.id_proprietario;
  }
  
    public int getDiasLocados() {
        return this.dias_locados;
    }

    public void setDiasLocados() {
        this.dias_locados = dias_locados;
    }
    
     public int getValorDiaria() {
        return this.valor_diaria;
    }

    public void setValorDiaria() {
        this.valor_diaria= valor_diaria;
    }
    
    public int getValorTotal() {
        return this.valor_total;
    }

    public void setvalorTotal() {
        this.valor_total= valor_total;
    }
    
        public int getDataLocacao() {
        return this.data_locacao;
    }

    public void setDataLocacao() {
        this.data_locacao= data_locacao;
    }
    
    public String getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento= pagamento;
    }

    public void setDiasLocados(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setValorDiaria(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDataLocacao(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setValorTotal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
