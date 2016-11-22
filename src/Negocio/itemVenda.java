/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class itemVenda {

    private int idItemVenda;
    private double valorTotal;
    private int qtdItem;
    private ArrayList<Venda> venda;
    private ArrayList<Item> item;

    public itemVenda() {
        this.venda = new ArrayList();
        this.item = new ArrayList();
    }

    /**
     * @return the idItemVenda
     */
    public int getIdItemVenda() {
        return idItemVenda;
    }

    /**
     * @param idItemVenda the idItemVenda to set
     */
    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the qtdItem
     */
    public int getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

}
