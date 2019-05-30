/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zwetti Patrick
 */
public class DataBaseTest {
    
    public DataBaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    /**
     * Test of checkLogin method, of class DataBase.
     * with right password
     */
    @Test
    public void testCheckLogin1() throws Exception {
        System.out.println("checkLogin");
        User loginuser = new User("Patrick", "123", 0);
        DataBase instance = new DataBase();
        boolean expResult = true;
        boolean result = instance.checkLogin(loginuser);
        assertEquals(expResult, result);
        }
       
    /**
     * Test of checkLogin method, of class DataBase.
     * with wrong password 
     */
    @Test
    public void testCheckLogin2() throws Exception {
        System.out.println("checkLogin");
        User loginuser = new User("Patrick", "123456", 0);
        DataBase instance = new DataBase();
        boolean expResult = false;
        boolean result = instance.checkLogin(loginuser);
        assertEquals(expResult, result);
    }
    
    
}
