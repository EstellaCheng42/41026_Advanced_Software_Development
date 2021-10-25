import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import opal.dao.CardManagementDao;
import opal.dao.SecurityRequestDao;
import opal.entity.OpalCard;
import opal.entity.SecurityRequest;
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
public class requestTest {

    SecurityRequestDao requestDao;

    public requestTest() throws ClassNotFoundException, SQLException {
        this.requestDao = new SecurityRequestDao();
    }

    @Test
    public void testGetAllRequests() throws SQLException {
         ArrayList<SecurityRequest> requestList = requestDao.GetAllRequests();
        assertTrue(requestList.size() > 0);
    }

    @Test
    public void testCreate() throws SQLException {
    }
    
    @Test
    public void testUpdate() throws SQLException {
        System.out.println("Running testUpdate...");
        requestDao.UpdateRequest(8);
        SecurityRequest updatedRequest = requestDao.SearchbyId(8);
        assertTrue(updatedRequest.getStatus().equals("Confirmed"));
    }
    
    @Test
    public void testDelete() throws SQLException {
         System.out.println("Running testDelete...");
         SecurityRequest newrequest = new SecurityRequest();
         newrequest.setCardNo("123456");
         SecurityRequest deletedRequest = requestDao.SearchbyId(newrequest.getRequestId());
         
         requestDao.DeleteRequest("deletedRequest.getRequestId()");
         assertNull(deletedRequest);
    }       
}