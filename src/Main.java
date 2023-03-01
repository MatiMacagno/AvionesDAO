import com.company.DAO.AvionDAOh2;
import com.company.Entities.Avion;
import com.company.Service.AvionService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        AvionService avionService = new AvionService();
        avionService.setAvionIDAO(new AvionDAOh2());
        avionService.buscarTodosLosAviones();

    }

}
