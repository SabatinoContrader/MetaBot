export default class User {

idUser: number;
username: string;
password: string;
ruolo: string;
email: string;

    constructor(idUser:number, username:string, password:string, ruolo:string, email:string){
        this.idUser=idUser;
        this.username=username;
        this.password=password;
        this.ruolo=ruolo;
        this.email= email;
    }
}
