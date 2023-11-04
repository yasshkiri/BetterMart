export class Claim {
    idClaim  : Number;
    dateC : Date;
    descriptionC : String;
    productType: String;
    claimType:String;
    etat: boolean;
    delivery: Number;
    customer: Number;
    CommandLigness: Number;
    publication: Number;

    constructor(){
        this.idClaim=0;
        this.dateC= new Date();
        this.descriptionC="";
        this.productType="";
        this.claimType="";
        this.etat=false;
        this.delivery=0;
        this.customer=0;
        this.CommandLigness=0;
        this.publication=0;

    }
    
}
