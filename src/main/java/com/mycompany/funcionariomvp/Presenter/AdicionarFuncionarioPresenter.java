/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvp.Presenter;

import com.mycompany.funcionariomvp.Model.Funcionario;
import com.mycompany.funcionariomvp.View.AdicionarFuncionarioView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author hiago
 */
public class AdicionarFuncionarioPresenter {

    private AdicionarFuncionarioView view;
    private ArrayList<Funcionario> funcionarioCollection;

    public AdicionarFuncionarioPresenter(ArrayList<Funcionario> collection) {
        this.funcionarioCollection = collection;

        this.view = new AdicionarFuncionarioView();
        this.view.setVisible(false);

        configurarComponentes();

        this.view.setVisible(true);
    }

    private void configurarComponentes() {
        view.getNomeTextField().setText("");
        view.getCargoTextField().setText("");
        view.getSalarioTextField().setText("");

        view.getSalvarBtn().addActionListener((ActionEvent e) -> {
            salvar();
        });

        view.getVoltarBtn().addActionListener((ActionEvent e) -> {
            view.setVisible(false);
        });
    }

    private void salvar() {
        String nome = view.getNomeTextField().getText();
        String cargo = view.getCargoTextField().getText();
        String salario = view.getSalarioTextField().getText();

        Funcionario funcionario = new Funcionario(nome, cargo, Integer.parseInt(salario));

        funcionarioCollection.add(funcionario);

        view.setVisible(false);
        
        new ConsultarFuncionarioPresenter(funcionarioCollection);
    }
}
