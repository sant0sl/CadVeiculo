package com.cadveiculo.sant0sl.cadveiculo.Classes;

/**
 * Created by sant0 on 09/03/2018.
 */

public class Veiculo {

    private Integer id;
    private String placa;
    private Integer ano;

    public String toString(){
        return "id= " + id + ", placa= " + placa + ", ano= " + ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Veiculo(){

    }

    public Veiculo(String placa, Integer ano){
        this.placa=placa;
        this.ano=ano;
    }

    public Veiculo(Integer id, String placa, Integer ano){
        this.id=id;
        this.placa=placa;
        this.ano=ano;
    }
}
