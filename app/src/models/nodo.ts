export class NodoDTO {

    idNodo: number;
    text: string;
    nodoPadre: NodoDTO;
    tipoNodo: string;
    path: string;

    constructor(idNodo: number, text: string, nodoPadre: NodoDTO, tipoNodo: string, path: string) {
        this.idNodo = idNodo;
        this.text = text;
        this.nodoPadre = nodoPadre;
        this.tipoNodo = tipoNodo;
        this.path = path;
    }
}
export default NodoDTO