package aplicacao;

import java.awt.Button;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Aluno;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class main extends Application{
	
		

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox box = new VBox();
		Button a = new Button("AC");
		Scene cenaUnica = new Scene(box);
		primaryStage.setScene(cenaUnica);
		primaryStage.show();
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Aluno a1 = new Aluno("ICARO");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("escola");
		//EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		//em.persist(a1);
		//em.getTransaction().commit();
			
		launch(args);
		
	}

	

}
