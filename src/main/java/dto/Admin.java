package dto;

public class Admin 
{
	private int AdminId;
	private String AdminName;
	private Long AdminContact;
	private String AdminEmail;
	private String AdminPassword;
	
	
	public int getAdminId() 
	{
		return AdminId;
	}
	public void setAdminId(int adminId) 
	{
		this.AdminId = adminId;
	}
	public String getAdminName() 
	{
		return AdminName;
	}
	public void setAdminName(String adminName) 
	{
		this.AdminName = adminName;
	}
	public Long getAdminContact() 
	{
		return AdminContact;
	}
	public void setAdminContact(Long adminContact) 
	{
		this.AdminContact = adminContact;
	}
	public String getAdminEmail() 
	{
		return AdminEmail;
	}
	public void setAdminEmail(String adminEmail) 
	{
		this.AdminEmail = adminEmail;
	}
	public String getAdminPassword() 
	{
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) 
	{
		this.AdminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", AdminName=" + AdminName + ", AdminContact=" + AdminContact
				+ ", AdminEmail=" + AdminEmail + ", AdminPassword=" + AdminPassword + "]";
	}
	
	
}
