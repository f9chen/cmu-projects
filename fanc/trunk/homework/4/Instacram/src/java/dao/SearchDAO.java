/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author f9chen
 */
public interface SearchDAO {

    public String searchInAllCourses(String queryString) throws MyDAOException;

    public String searchInYourCourses(String queryString, String email) throws MyDAOException;
}
