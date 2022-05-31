package Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Utilitarios.Utilitario;
import daos.Dao_Aluno;
import entidades.Aluno;

public class Tela_Diretor_Aluno_Excluir  {

	private Utilitario utilitario = new Utilitario();
	
	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null,mensagem);
	
	}
	public void sucess(String mensagem) {
		JOptionPane.showInternalMessageDialog(null, mensagem);
	}
	
	public JPanel getPanel() {
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 78, 728, 472);
		panel_1.setLayout(null);
		
		
		final JTextField campoBusca = new  JTextField();
		campoBusca.setBounds(285, 121, 158, 30);
		campoBusca.setColumns(10);
		panel_1.add(campoBusca);
	
		
		JLabel lblNewLabel = new JLabel("MATRICULA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(184, 119, 91, 30);
		panel_1.add(lblNewLabel);
		
		
		
		JButton excluir = new JButton("EXCLUIR");
		 excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long matricula = null;

				try {
				
					if(utilitario.valideMatricula(campoBusca.getText())) {
						matricula = Long.parseLong(campoBusca.getText());
						Dao_Aluno dao_aluno = new Dao_Aluno();
						Aluno aluno = dao_aluno.getAlunoMatricula(matricula);
						if(aluno ==null) {
							alert("ALUNO NÃO ENCONTRADO!");
						}else {
		                Object[] options = { "Sim", "Não" }; 
		            int op =  JOptionPane.showOptionDialog(null, aluno.toString()+" \n DESEJA EXCLUIR ESSE ALUNO? \n \n", "EXCLUIR ALUNO", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		            	if(op==0) {
		            
		            		if(dao_aluno.deleteAluno(matricula)) {
		            			sucess("ALUNO EXCLUIDO COM SUCESSO!");
		            		}else {
		            			alert("ERRO! O ALUNO NÃO FOI EXCLUIDO");
		            		}
		            	}
		               
						}
					}else {
						alert("MATRICULA INVALIDA!");
					}
					
					
					
					
				}catch (Exception error) {
					alert("ERRO NO SISTEMA"+error.getMessage());
					
				}
				
			}
		});
		
		excluir.setBounds(232, 197, 157, 30);
		panel_1.add(excluir);
		
		
		 
	
		
		return panel_1;
	}
	
}
