package Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Utilitarios.Utilitario;
import daos.Dao_Disciplina;
import daos.Dao_Professor;
import daos.Dao_Turma;
import entidades.Disciplina;
import entidades.Professor;
import entidades.Turma;


public class Tela_Diretor_Turma_Cadastro {

	
	protected static final Throwable ErroInternoTratavel = null;

	public void alert(String mensagem) {
		JOptionPane.showMessageDialog(null,mensagem);
	
	}
	public void sucess(String mensagem) {
		JOptionPane.showInternalMessageDialog(null, mensagem);
	}
	private Utilitario utilitario = new Utilitario();
	
	public JPanel getPanel() {
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 87, 744, 463);
		panel.setLayout(null);
		
		
		JTextField textField =  new JTextField();
		textField.setBounds(355, 113, 121, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		
		JLabel lblNewLabel = new JLabel("CODIGO DA DISCIPLINA:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(185, 107, 164, 25);
		panel.add(lblNewLabel);
		
		JLabel lblCodigoDoProfessor = new JLabel("CODIGO DO PROFESSOR:");
		lblCodigoDoProfessor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCodigoDoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDoProfessor.setBounds(174, 170, 164, 25);
		panel.add(lblCodigoDoProfessor);
		
		JTextField textField_1 =  new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(355, 176, 121, 25);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("CRIAR TURMA");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				try {
					List<String> msgErro = new ArrayList<String>();
					String codigoDisciplina = textField.getText();
					String codigoProfessor = textField_1.getText();
					
					if(!utilitario.valideCodigo(codigoProfessor)) {throw new Exception("\"ERRO: CODIGO DO PROFESSOR INVALIDO!\"",ErroInternoTratavel);}
					if(!utilitario.valideCodigo(codigoDisciplina)) {throw new Exception("\"ERRO: CODIGO DA DISCIPLINA INVALIDO!",ErroInternoTratavel);}
					
					Dao_Disciplina dao_disciplina = new Dao_Disciplina();
					Dao_Professor dao_professor = new Dao_Professor();
					Dao_Turma  dao_turma = new Dao_Turma();
				
					Professor professor = dao_professor.getProfessorMatricula(Long.parseLong(codigoProfessor));
					Disciplina disciplina = dao_disciplina.getDisciplinaCodigo(Long.parseLong(codigoDisciplina));	
					
					if(professor==null) {throw new Exception("ERRO: PROFESSOR NÃO ENCONTRADO!",ErroInternoTratavel);}
					if(disciplina==null){throw new Exception("ERRO: DISCIPLINA NÃO ENCONTRADA!",ErroInternoTratavel);}
					Turma turma = new Turma(disciplina, professor);
					if(turma == null){throw new Exception("ERRO NO SISTEMA, TURMA NÃO CRIADA!",ErroInternoTratavel);}
						
					Object[] options = { "Sim", "Não" }; 
				    int op =  JOptionPane.showOptionDialog(null,"DISCIPLINA:"+turma.getDisciplina().getNome()+"\nPROFESSOR: "+turma.getProfessor().getNome()+"\n \n DESEJA CRIAR ESSA TURMA? \n \n", "CRIAR TURMA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				    if(op==0) {
				        Long codigoTurma = dao_turma.saveTurma(turma);
				        if(codigoTurma>0) {
				            	sucess("TURMA CRIADA COM SUCESSO! "+codigoTurma);		
				          }else {
				            	alert("ERRO! A TURMA NÃO FOI CRIADA");
				          }
				    }
				  
				        
				}catch(Exception erro ) {
					
					if(erro.getCause() == ErroInternoTratavel) {
						alert(erro.getMessage());
					}else {
						alert("ERRO NO SERVIDOR!"+erro.getMessage());
					}
				} 
				
				
			}
		});
		btnNewButton.setBounds(279, 258, 121, 31);
		panel.add(btnNewButton);
		return panel;
		
	}
}
