/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvp.Presenter;

import com.mycompany.funcionariomvp.Model.Funcionario;
import com.mycompany.funcionariomvp.View.VisualizarFuncionarioView;
import java.awt.event.ActionEvent;

/**
 *
 * @author hiago
 */
public class VisualizarFuncionarioPresenter {

    private VisualizarFuncionarioView view;
    private Funcionario funcionario;

    public VisualizarFuncionarioPresenter(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.view = new VisualizarFuncionarioView();

        this.view.setVisible(false);

        configurarComponentes();

        this.view.setVisible(true);

    }

    private void configurarComponentes() {
        view.getNomeLabel().setText(this.funcionario.getNome());
        view.getCargoLabel().setText(this.funcionario.getCargo());
        view.getSalarioLabel().setText(String.valueOf(this.funcionario.getSalario()));

        view.getVoltarBtn().addActionListener((ActionEvent e) -> {
            view.setVisible(false);
        });
    }
}
