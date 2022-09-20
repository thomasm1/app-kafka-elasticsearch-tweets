export class Pet {
 
    id: number;
    custId: number;
    petName: string;
    birthDate: string;
    weight: number;
    color: string;
    type: number;
    breed: string;
    neuter: number;
    description: string;
    petUrl: string;
 
    constructor(
        id: number,
        custId: number,
        petName: string,
        birthDate: string,
        weight: number,
        neuter: number,
        type: number,
        breed: string,
        description: string,
    ) {

        this.id = id;
        this.custId = custId;
        this.petName = petName;
        this.birthDate = birthDate;
        this.weight = weight;
        this.neuter=neuter;
        this.type = type;
        this.breed = breed;
        this.description = description;
    } 

}
