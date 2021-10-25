import java.sql.SQLException;
import java.util.List;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import opal.dao.CardManagementDao;
import opal.entity.OpalCard;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chengming
 */
public class cardTest {

    CardManagementDao cardDao;

    public cardTest() throws ClassNotFoundException, SQLException {
        this.cardDao = new CardManagementDao();
    }

    @Test
    public void testGetAllCards() throws SQLException {
        List<OpalCard> list = cardDao.getAllCards();
        assertTrue(list.size() > 0);
    }

    @Test
    public void testCreate() throws SQLException {
        System.out.println("Running testCreate...");

        OpalCard opalcard = new OpalCard(8, "888888", "3333", "Lily", "Adult");
        cardDao.AddCard(opalcard);

        OpalCard acard = cardDao.SearchbyId(opalcard.getCardId());
        assertTrue(opalcard.getCardId() > 0);
    }
    @Test
    public void testUpdate() throws SQLException {
        System.out.println("Running testUpdate...");
        OpalCard opalcard = new OpalCard(8, "888888", "3333", "Emelia", "Adult");
        cardDao.UpdateCard(opalcard);
        
        OpalCard updatedcard = cardDao.SearchbyId(8);
        assertTrue(opalcard.getnickname().equals("Emelia"));
    }
    
    @Test
    public void testDelete() throws SQLException {
         System.out.println("Running testDelete...");
         OpalCard deletecard = cardDao.SearchbyId(8);
         cardDao.DeleteCard("8");
         assertNull(deletecard);
    }   
}