package main.entities;


import java.util.Map;

public class User   {

    private int userId;
    private long id;
    private String lastName;
    private String firstName;
    private String userName;
    private String password;
    private int userType;
    private int groups;
    private String email;
    private String phone;
    private String cusUrl;

    public User() {
        super();
    }
    //f=0,m=1,o=2
    public User(int userId, long id, String lastName, String firstName, String userName, String password, int userType, int groups, String email, String phone, String cusUrl) {
        super();
        this.userId = userId;
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.groups = groups;
        this.email = email;
        this.phone = phone;
        this.cusUrl = cusUrl;
    }

    // overloaded for getUsersByCArs() call to DB
    public User(int userId,   String userName ) {
        super();
        this.userId = userId;
        this.userName = userName;
    }
    public User(  String userName, String password ) {
        super();
        this.userName = userName;
        this.password = password;
    }
    // overloaded for OFFER/ Groups must be multi-purpose
    public User(int userId,   String userName, String password, int userType, int groups) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.groups = groups;
    }

    // overloaded For REGISTER userId is AutoIncrement, lastname, firstname, email, phone, cusurl
    public User(  String userName, String password, String lastName, String firstName, int userType, int groups, String email, String phone, String cusUrl) {
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

    //	 overloaded without Id  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User( int userId, String userName, String password, String lastName, String firstName,  int userType, int groups, String email, String phone, String cusUrl) {
        super();
        this.userId =  userId;
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



    public User(int userId,   String userName, String password) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    // Contstructor for EDIT PROFILE (options available for user)
    public User(String password, String lastName, String firstName, int groups, String email, String phone, String cusUrl) {
        super();
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groups = groups;
        this.email = email;
        this.phone = phone;
        this.cusUrl = cusUrl;
    }

    public User(int i, int userType, int groups, String userName, String password, String email) {
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "User [userId=" + userId + ", id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
                + ", userName=" + userName + ", password=" + password + ", userType=" + userType
                + ", groups=" + groups + ", email=" + email + ", phone=" + phone + ", cusUrl=" + cusUrl + "]";
    }


}