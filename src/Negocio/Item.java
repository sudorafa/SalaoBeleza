/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Rafael
 */
public class Item {

    private int idItem;
    private int codBarras, qtdEstoque, qtdPromocao;
    private String descricao, tipoItem;
    private double valor, valorPromocional;
    private Admin admin;

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the codBarras
     */
    public int getCodBarras() {
        return codBarras;
    }

    /**
     * @param codBarras the codBarras to set
     */
    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }

    /**
     * @return the qtdEstoque
     */
    public int getQtdEstoque() {
        return qtdEstoque;
    }

    /**
     * @param qtdEstoque the qtdEstoque to set
     */
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    /**
     * @return the qtdPromocao
     */
    public int getQtdPromocao() {
        return qtdPromocao;
    }

    /**
     * @param qtdPromocao the qtdPromocao to set
     */
    public void setQtdPromocao(int qtdPromocao) {
        this.qtdPromocao = qtdPromocao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipoItem
     */
    public String getTipoItem() {
        return tipoItem;
    }

    /**
     * @param tipoItem the tipoItem to set
     */
    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the valorPromocional
     */
    public double getValorPromocional() {
        return valorPromocional;
    }

    /**
     * @param valorPromocional the valorPromocional to set
     */
    public void setValorPromocional(double valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
