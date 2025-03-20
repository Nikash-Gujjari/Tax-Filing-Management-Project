export class Cpa {

    cpa_id: number;
    first_name: string;
    last_name: string;
    email: string;
    username: string;
    hashed_password: string;
    role: string;


    constructor(cpa_id:number, first_name:string, last_name:string, email: string, username: string, hashed_password:string, role:string) {
        this.cpa_id = cpa_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.hashed_password = hashed_password;
        this.role = role;
    }
}