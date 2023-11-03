/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvp.Presenter;

import com.mycompany.funcionariomvp.Model.Funcionario;
import com.mycompany.funcionariomvp.View.ConsultarFuncionarioView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiago
 */
public class ConsultarFuncionarioPresenter {

    private ArrayList<Funcionario> funcionarioCollection;
    private ConsultarFuncionarioView view;

    public ConsultarFuncionarioPresenter(ArrayList<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;

        this.view = new ConsultarFuncionarioView();

        this.view.setVisible(false);
        this.configurarComponentes();
        this.view.setVisible(true);
    }

    private void configurarComponentes() {
        view.getNovoBtn().addActionListener((ActionEvent e) -> {
            adicionarFuncionario();
            view.setVisible(false);

        });

        view.getVerBtn().addActionListener((ActionEvent e) -> {
            visualizarFuncionario();
        });

        view.getVoltarBtn().addActionListener((ActionEvent e) -> {
            view.setVisible(false);
        });

        view.getDeletarBtn().addActionListener((ActionEvent e) -> {
            deletarFuncionario();
        });

        view.getTable().setModel(prepareTable());
    }

    private void visualizarFuncionario() {
        int index = (view.getTable().getSelectedRow());
        Funcionario funcionario = funcionarioCollection.get(index);
        new VisualizarFuncionarioPresenter(funcionario);
    }

    private void deletarFuncionario() {
        int index = (view.getTable().getSelectedRow());
        funcionarioCollection.remove(index);
        view.getTable().setModel(prepareTable());
    }

    private DefaultTableModel prepareTable() {
        DefaultTableModel modeloTabela = new DefaultTableModel();

        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Cargo");
        modeloTabela.addColumn("Salario");

        funcionarioCollection.forEach(funcionario -> {
            modeloTabela.addRow(new Object[]{
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario()
            });
        });

        return modeloTabela;
    }

    public void adicionarFuncionario() {
        new AdicionarFuncionarioPresenter(funcionarioCollection);
    }
}
