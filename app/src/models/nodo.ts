export class NodoDTO {

    idNodo: number;
    text: string;
    nodoPadre: NodoDTO;
    tipoNodo: string;
    path: string;
    contatore: number

    constructor(idNodo: number, text: string, nodoPadre: NodoDTO, tipoNodo: string, path: string,contatore: number) {
        this.idNodo = idNodo;
        this.text = text;
        this.nodoPadre = nodoPadre;
        this.tipoNodo = tipoNodo;
        this.path = path;
        this.contatore = contatore;
    
    }
}
export default NodoDTO