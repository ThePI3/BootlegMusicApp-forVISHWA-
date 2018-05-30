package main;

import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {
	
	private String databaseSite = "sql3.freesqldatabase.com", databaseName = "sql3240505", databaseUsername = "sql3240505", databasePassword = "EVslmR7Cac";

    @FXML
    private AnchorPane parent;
    
    @FXML
    private TextField uTF, pTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void login_app(ActionEvent event) {
    	jbdconnector();
    }
    public void jbdconnector()
    {
    	Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + databaseSite + "/" + databaseName , databaseUsername , databasePassword);
			PreparedStatement ps = con.prepareStatement("Select * from " + databaseName + ".LoginTable where username = ? and password = ?");
			ps.setString(1, uTF.getText());
			ps.setString(2, String.valueOf(pTF.getText()));
    		ResultSet result = ps.executeQuery();
    		if(result.next()){
    			//JOptionPane.showMessageDialog(null, "Login Successesfull");
    			//frmAdminControlPanel.setVisible(false);
    			//AdminGUI nc = new AdminGUI();
    			//nc.frame.setVisible(true);
   		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}


