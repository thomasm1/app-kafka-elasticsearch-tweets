export class Note{ 

    n_message: string;
    n_id: number;
    a_id: number;
    p_id: number;

    constructor(n_message :string, n_id :number, a_id: number, p_id :number) {
        this.n_message = n_message;
        this.n_id = n_id;
        this.a_id = a_id;
        this.p_id = p_id;
    } 
}