/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pabbo;
public class InvalidTTLException extends Exception  {
    private String ttlSent;
	
	//Creates a blank InvalidLengthException with no arguements.
	private InvalidTTLException()
	{
		
	}

	//Creates an InvalidLengthException that takes in the invalid String.
	public InvalidTTLException(String inString)
	{
		this.ttlSent = inString;
	}
	
	//Returns the inString of an InvalidLengthException.
	public String getTTLSent()
	{
		return this.ttlSent;
	}
	
	//Returns InvalidLengthException as a String.
	public String toString()
	{
		String returnString;
		
		returnString = this.ttlSent + " is an invalid format TTL!\n";
		
		return returnString;
	}
}
