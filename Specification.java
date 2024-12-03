public class Specification {
    private Automate automate;

    public Specification() {
        this.automate =new Automate() ;
    }
    public void controleAcces(boolean carteValide,boolean codeCorrect){
            automate.VerificationCarte(carteValide);
        if(automate.getEtat()==Automate.Etat.verification_Carte){
            automate.verificationCode(codeCorrect);
        }
        automate.ActiverAlarme();
    }
    public String getEtat(){
        switch (automate.getEtat()){
            case acces_Accepte :
                return "Accès Accepté";
            case acces_Refuse:
                return "Accès Refusé";
            case alarme_Declanche:
                return "Alarme déclenchée";
            case acces_Bloque:
                return "Accès Bloqué";
            default:
                return "Inconnu veuillez declarer votre identité";
        }
    }
}
