export class Appointment {

    id :number;
    custId :number;
    petId :number;
    empId :number;
    date :string;
    weight :number;
    timeSlot :number;
    description :string;

    constructor(id :number, custId :number, petId :number, empId :number, date :string, weight :number, timeSlot :number, description :string) {
        this.id = id;
        this.custId = custId;
        this.petId = petId;
        this.empId = empId;
        this.date = date;
        this.weight = weight;
        this.timeSlot = timeSlot;
        this.description = description;
        }
}
