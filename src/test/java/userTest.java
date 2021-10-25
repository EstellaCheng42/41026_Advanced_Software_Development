
import java.sql.SQLException;
import static junit.framework.Assert.assertTrue;
import opal.dao.UserDao;
import opal.entity.User;
import org.junit.Test;
import java.lang.String;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chengming
 */
public class userTest {

    UserDao userDao;

    public userTest() throws ClassNotFoundException, SQLException {
        this.userDao = new UserDao();
    }

    @Test
  public void testCreate() throws SQLException{
      System.out.println("Running test...");
      
      User user = new User(6,"asdf","dsad","asdf","sadsaf","fsdfsd");
      userDao.addUser(user);
      User users = userDao.SearchbyId(user.getId());
      assertTrue(user.getId()>0);
  }

}
