/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import Model.cliente.Cliente;

/**
 *
 * @author Martin, Janaina, Nicolle, Rafael
 */
public interface ContaI {
    public boolean deposita(Moeda valor);
    public boolean saca(Moeda valor);
    public Cliente getDono();
    public int getNumero();
    public Moeda getSaldo();
    public void remunera();
}
