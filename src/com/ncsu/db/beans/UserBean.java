package com.ncsu.db.beans;

public class UserBean {

	String id="";
	String password="";
	char type=' ';

	public void setId(String loginname)
	{
		id=loginname;
	}

	public String getName()
	{
		return id;
	}

	public void setPasswd(String loginpassword)
	{
		password=loginpassword;
	}

	public String getPasswd()
	{
		return password;
	}

	public void setType(char usertype)
	{
		type=usertype;
	}

	public char getType(char usertype)
	{
		return type;
	}

}
