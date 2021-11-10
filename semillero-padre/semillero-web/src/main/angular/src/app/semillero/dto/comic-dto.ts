export class ComicDTO {
    
    private _id: number;
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    private _nombre: string;
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
    
    private _tematicaEnum: string;
    public get tematicaEnum(): string {
        return this._tematicaEnum;
    }
    public set tematicaEnum(value: string) {
        this._tematicaEnum = value;
    }

    private _precio: number;
    public get precio(): number {
        return this._precio;
    }
    public set precio(value: number) {
        this._precio = value;
    }

    constructor(){

    }

    public toString() : string { 
        return "";
    }
}