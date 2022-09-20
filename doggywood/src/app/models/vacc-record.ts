export class VaccRecord{

int: number;
petId: number;
vacName: string;
vacTime: number;
vacDate: string;

constructor(int: number, petId: number, vName: string, vTime: number, vDate: string){

    this.int = int;
    this.petId = petId;
    this.vacName = vName;
    this.vacTime = vTime;
    this.vacDate = vDate;
}
}