package bootathon;
import java.io.*; 

class Cookie implements java.io.Serializable 
{ 
	public String username; 
	public String password; 

	// Default constructor 
	public Cookie(String a, String b) 
	{ 
		username = a; 
		password = b; 
	} 

}