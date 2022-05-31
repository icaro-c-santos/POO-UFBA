package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Utilitarios.Utilitario;
import daos.Dao_Disciplina;
import entidades.Disciplina;


@SuppressWarnings("serial")
public class Tela_Diretor_Disciplina_Alterar extends JFrame {

		
		public void alert(String mensagem) {
			JOptionPane.showMessageDialog(null,mensagem);
		
		}
		public void sucess(String mensagem) {
			JOptionPane.showInternalMessageDialog(null, mensagem);
		}
		private Utilitario utilitario = new Utilitario();

		public JPanel getPanel() {
			
			JPanel panel = new JPanel();
			JButton btnNewButton2;
			
			JLabel lblCodigo = new JLabel("CODIGO DA DISCIPLINA:");
			lblCodigo.setBounds(50, 40, 250, 25);
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblCodigo);
			panel.setLayout(null);
			
			JTextField consultaTexto = new JTextField();
			consultaTexto.setBounds(250, 40, 80, 25);
			panel.add(consultaTexto);
			consultaTexto.setColumns(10);
			
			
			JTextField textFieldNome = new JTextField();
			textFieldNome.setBounds(240, 150, 203, 24);
			panel.add(textFieldNome);
			
			JLabel lblNewLabel = new JLabel("NOME DA DISCIPLINA:");
			lblNewLabel.setBounds(50, 150, 220, 19);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNewLabel);
			panel.setLayout(null);
		
			
			JLabel lblDescricao = new JLabel("DESCRIÇÃO DA DSICIPLINA:");
			lblDescricao.setBounds(50, 220, 251, 17);
			lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDescricao);
			
			MaskFormatter mask = null;
			try {
				mask = new MaskFormatter("********************************************************************************");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			JTextField textArea = new JFormattedTextField(mask);
			textArea.setBounds(50, 250, 600, 50);
			textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel.add(textArea);
			
	
			
			JButton btnNewButton = new JButton("ALTERAR DISCIPLINA");
			btnNewButton.addActionListener(new ActionListener() {
				@SuppressWarnings("unused")
				public void actionPerformed(ActionEvent e) {  
				
			    List<String> msgErro = new ArrayList<String>();	
			    String descricao;
			     String nome;
			    try {
			    	descricao = textArea.getText();
			    	nome = textFieldNome.getText();
					if(nome.isEmpty() || nome.length()<2) {msgErro.add("ERRO: NOME INVALIDO!");}
				} catch (Exception e2) {
					msgErro.add("ERRO: DIGITE UMA DESCRIÇÃO COM ATÉ 40 CARACTERES");	
				}
				
				
				
				
				if(msgErro.isEmpty()) {
					
			    	try {
						Dao_Disciplina dao_disciplina = new Dao_Disciplina();
						Disciplina disciplina = dao_disciplina.getDisciplinaCodigo(Long.parseLong(consultaTexto.getText()));
						disciplina.setNome(textFieldNome.getText());
						disciplina.setDescricao(textArea.getText());
						Object[] options = { "Sim", "Não" }; 
				        int op =  JOptionPane.showOptionDialog(null, disciplina.toString()+" \n DESEJA ALTERAR ESSA DISCIPLINA? \n \n", "ALTERAR DISCIPLINA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				        if(op==0) {
				        	if(dao_disciplina.updateDisciplinar(disciplina)) {
				            	sucess("DISCIPLINA ALTERADA COM SUCESSO!");
				            	textArea.setEditable(true);
				      			textFieldNome.setEditable(true);
				      			consultaTexto.setEditable(true);
				      			textArea.setText("");
				      			consultaTexto.setText("");
				      			textFieldNome.setText("");
				            			
				            }else {
				            	alert("ERRO! O DISCIPLINA NÃO FOI ALTERADA");
				            }
				        			 
				        }	
				        textArea.setEditable(true);
		      			textFieldNome.setEditable(true);
		      			consultaTexto.setEditable(true);
		      			textArea.setText("");
		      			consultaTexto.setText("");
		      			textFieldNome.setText("");
		      			textArea.setEditable(false);
		      			textFieldNome.setEditable(false);						
						
						
					} catch (Exception e2) {
						alert("ERRO NO SISTEMA: "+e2.getMessage());
					}
			    		
			    	}else {
			    	   String erro ="";	
			    		for (int i=0; i< msgErro.size(); i++) {
			    			erro = erro+"\n"+msgErro.get(i);
			    		}
			    		alert(erro);
			    		msgErro.clear();
			    	}

				}	
				});
			
			
	
			
			btnNewButton2 = new JButton("BUSCAR DISCIPLINA");
			btnNewButton2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						String valorConsulta = consultaTexto.getText();
						if(utilitario.valideCodigo(valorConsulta)) {
							Dao_Disciplina dao_disciplina = new Dao_Disciplina();
							Disciplina disciplina = dao_disciplina.getDisciplinaCodigo(Long.parseLong(valorConsulta));
				      		if(disciplina == null) {
				      			alert("DISCIPLINA NÃO ENCONTRADA!");
				      		}else {
				      			
				      			textArea.setEditable(true);
				      			textFieldNome.setEditable(true);
				      			btnNewButton.setEnabled(true);
				      			textFieldNome.setText(disciplina.getNome());
				      			textArea.setText(disciplina.getDescricao());
				      			consultaTexto.setEditable(false);

				      		}
							repaint();
						}else {
							alert("CODIGO INVALIDO!");
						}
						
					} catch (Exception e2) {
						alert("ERRO NO SISTEMA!"+e2.getMessage());
						textArea.setEditable(true);
		      			textFieldNome.setEditable(true);
		      			consultaTexto.setEditable(true);
		      			textArea.setText("");
		      			consultaTexto.setText("");
		      			textFieldNome.setText("");
		      		

					}
					
					
					
				}		
		});
		
			btnNewButton.setBounds(220, 400, 240, 23);
			btnNewButton2.setBounds(400, 40, 240, 23);
			btnNewButton.setEnabled(false);
			textArea.setEditable(false);
			textFieldNome.setEditable(false);
			panel.add(btnNewButton);
			panel.add(btnNewButton2);
			
			return panel;

		}
}