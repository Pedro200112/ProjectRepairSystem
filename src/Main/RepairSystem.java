
package Main;

import Controle.ControleLogin;
import Modelo.Conexao;
/*SERVIDOR MYSQL -> EMILY*/
import java.sql.Connection;

/*XAMPP -> PEDRO
import com.mysql.jdbc.Connection;*/


public class RepairSystem {

   
    public static void main(String[] args) {
  
        //Cria conexão
        Connection conexao = Conexao.getConexao();
        
        //Chama controle login que abre a tela login
        ControleLogin CL = new ControleLogin();
        
    }
    
}
