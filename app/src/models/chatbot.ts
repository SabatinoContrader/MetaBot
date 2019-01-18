import User from "./user";

export default class Chatbot {


idChatbot: number;
nomeChatbot: string;
user:  string;
nodoPadre:  string;

    constructor(idChatbot: number, nomeChatbot: string, user: string, nodoPadre: string){
        this.idChatbot=idChatbot;
        this.nomeChatbot=nomeChatbot;
        this.user=user;
        this.nodoPadre=nodoPadre;
    }
}
