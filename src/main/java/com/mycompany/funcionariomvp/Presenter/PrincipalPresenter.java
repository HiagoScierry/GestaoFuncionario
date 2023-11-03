/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionariomvp.Presenter;

import com.mycompany.funcionariomvp.Model.Funcionario;
import com.mycompany.funcionariomvp.View.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author hiago
 */
public class PrincipalPresenter {

    private ArrayList<Funcionario> funcionarioCollection;
    private PrincipalView view;

    public PrincipalPresenter() {
        this.funcionarioCollection = new ArrayList();

        Funcionario funcionario = new Funcionario("Hiago", "Desenvolvedor", 1000);
        this.funcionarioCollection.add(funcionario);

        funcionario = new Funcionario("Aline", "Analista", 1500);

        this.funcionarioCollection.add(funcionario);
        funcionario = new Funcionario("Isabella", "Designer", 1200);

        this.funcionarioCollection.add(funcionario);

        funcionario = new Funcionario("André", "Desenvolvedor", 1000);
        this.funcionarioCollection.add(funcionario);

        this.view = new PrincipalView();
        this.view.setVisible(false);

        configurarComponentes();
        this.view.setVisible(true);

    }

    private void configurarComponentes() {
        view.getAdicionarFuncionario().addActionListener((ActionEvent e) -> {
            adicionarFuncionario();
        });

        view.getConsultaFuncionario().addActionListener((ActionEvent e) -> {
            consultarFuncionario();
        });

    }

    private void consultarFuncionario() {
        new ConsultarFuncionarioPresenter(funcionarioCollection);
    }

    private void adicionarFuncionario() {
        new AdicionarFuncionarioPresenter(funcionarioCollection);
    }
}
