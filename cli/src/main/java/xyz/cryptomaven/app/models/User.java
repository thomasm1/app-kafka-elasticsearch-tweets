package xyz.cryptomaven.app.models;

import java.util.Map;
import java.util.Objects;

public class User {

    private int userId; //#1
    private String userName;
    private String password;
    private String lastName;
    private String firstName;
    private int groups;
    private int userType;
    private String email;
    private String phone;
    private String cusUrl;
    private String photoPath;
    private String userGroup;
    private int isActive;
    private int contactType; // ContactType contactType
    private String id;

    public User() {
        super();
    }

    //f=0,m=1,o=2
    public User(int userId, String userName, String password, String lastName, String firstName,
                int groups,
                int userType,
                String email,
                String phone,
                String cusUrl,
                String photoPath,
                String userGroup,
                int isActive,
                int contactType, // ContactType contactType
                String id) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.groups = groups;
        this.email = email;
        this.phone = phone;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.userGroup = userGroup;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;

    }


    // overloaded for getUsersByCArs() call to DB
    public User(int userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    // overloaded for OFFER/ Groups must be multi-purpose
    public User(int userId, String userName, String password, int groups, int userType) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.groups = groups;
    }

    // overloaded For REGISTER userId is AutoIncrement, lastname, firstname, email, phone, cusurl
    public User(String userName, String password, String lastName, String firstName, int groups, int userType, String email, String phone, String cusUrl) {
        super();
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.groups = groups;
        this.email = email;
        this.phone = phone;
        this.cusUrl = cusUrl;
    }

    //	 overloaded WITHOUT userId  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User(String userName, String password, String lastName, String firstName,
                int groups, int userType, String email, String phone, String cusUrl,
                 String photoPath,
                String userGroup,
                int isActive,
                int contactType, // ContactType contactType
                String id) {
        super();
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.groups = groups;
        this.email = email;
        this.phone = phone;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.userGroup = userGroup;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;
    }

    public User(int userId, String userName, String password) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    // Contstructor for EDIT PROFILE (options available for user)
    public User(String pw, String lName, String fName, int userType, int groups, String email, String phone, String url) {
        super();
        this.password = pw;
        this.lastName = lName;
        this.firstName = fName;
        this.userType = userType;
        this.groups = groups;
        this.email = email;
        this.phone = phone;
        this.cusUrl = url;
    }

    public User(String password, String smith, String tom, int i, int i1, String s, String s1, String s2, String photoPath, String userGroup, int i2, int i3, String id) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCusUrl() {
        return cusUrl;
    }

    public void setCusUrl(String cusUrl) {
        this.cusUrl = cusUrl;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getContactType() {
        return contactType;
    }

    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && getUserName().equals(user.getUserName()) && getPassword().equals(user.getPassword()) && Objects.equals(getId(), user.getId());
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
                + ", userName=" + userName + ", password=" + password + ", groups=" + groups + ", userType=" + userType
                + ", email=" + email + ", phone=" + phone + ", cusUrl=" + cusUrl + "]";
    }


}