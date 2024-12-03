public class Automate { // modeliser les etats et transitions;
    public enum Etat{  etat_Initial,
     verification_Carte,
     verification_Code,
     acces_Accepte,
    acces_Refuse,
     alarme_Declanche,
     acces_Bloque;}
    public int tentatives;
    public Etat etat_Carte;
    public String check;

    public Automate() {
        this.tentatives = 0;
        this.etat_Carte =Etat.etat_Initial;
    }
    public void VerificationCarte(boolean carteValide){
       if(etat_Carte==Etat.etat_Initial){
           if (carteValide) {
               etat_Carte = Etat.verification_Code;
               System.out.println("Carte Validé");
               check="Carte Validé";
           }
       }
    }
    public void verificationCode(boolean codeCorrect) {
        if (etat_Carte == Etat.verification_Code) {
            if ( codeCorrect) {
                System.out.print(Etat.acces_Accepte);
            } else {
                System.out.println("Code erroné veuillez saisir un autre code");
                for (tentatives = 1; tentatives < 3; tentatives++) {
                    System.out.println("Tentative " + tentatives+":");
                    if (codeCorrect) {
                        etat_Carte = Etat.acces_Accepte;
                    }else{
                        etat_Carte=Etat.acces_Refuse;
                    }
                    if (tentatives >=3) {
                        etat_Carte = Etat.acces_Bloque;
                    }
                }
            }
        }
    }
    public void ActiverAlarme(){
        if (etat_Carte == Etat.acces_Refuse && tentatives >= 3) {
                etat_Carte = Etat.alarme_Declanche; }
            System.out.println(Etat.alarme_Declanche);

    }
    public Etat getEtat(){
        return etat_Carte;
    }
}
