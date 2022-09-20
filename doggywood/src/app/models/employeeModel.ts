

 export class EmployeeModel  {
        id: number;
		eType: number;
		firstName: string;
		lastName:string;
		phone: string;
		email: string;
		password: string;

    constructor(
        id: number,
        eType: number,
        firstName: string,
        lastName: string,
        phone: string,
        email: string,
        password: string,
    ) {
        this.id = id;
        this.eType = eType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

}
