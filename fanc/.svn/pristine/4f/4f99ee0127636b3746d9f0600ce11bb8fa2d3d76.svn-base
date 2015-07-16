/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formbeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f9chen
 */
public class RegistrationForm {

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmemail() {
        return confirmemail;
    }

    public void setConfirmemail(String confirmemail) {
        this.confirmemail = confirmemail;
    }

	private String fname;
        private String lname;
	private String password;
	private String confirmpassword;
        private String email;
        private String confirmemail;
	
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (fname == null || fname.length() == 0) {
			errors.add("First Name is required");
		}
                
                if (lname == null || lname.length() == 0) {
			errors.add("Last Name is required");
		}
                 if (email == null || email.length() == 0) {
			errors.add("email is required");
		}
                 if (confirmemail == null || confirmemail.length() == 0) {
			errors.add("confirmEmail is required");
		}

		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}

		if (confirmpassword == null || confirmpassword.length() == 0) {
			errors.add("Confirm Pwd is required");
		}
		
		
		
		if (!password.equals(confirmpassword)) {
			errors.add("Password and Confirm Pwd do not match");
		}
                if (!email.equals(confirmemail)) {
			errors.add("Email and Confirm email do not match");
		}
		if (errors.size() > 0) return errors;
		return errors;
	}
	
//	public boolean isPresent() {
//		if (fname != null) return true;
//		if (password != null) return true;
//		if (confirmPassword != null) return true;
//		return false;
//	}
}
