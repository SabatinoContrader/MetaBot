import { UserDTO } from "./user";
import { NodoDTO } from "./nodo";

export class ChatbotDTO {

    idChatbot: number;
    nomeChatbot: string;
    user: UserDTO;
    nodoPadre: NodoDTO;

    constructor(idChatbot: number, nomeChatbot: string, user: UserDTO, nodoPadre: NodoDTO) {
        this.idChatbot = idChatbot;
        this.nomeChatbot = nomeChatbot;
        this.user = user;
        this.nodoPadre = nodoPadre;
    }
}
export default ChatbotDTO