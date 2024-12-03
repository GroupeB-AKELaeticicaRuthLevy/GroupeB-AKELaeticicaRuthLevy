import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class MainAutomate {
    private List<Carte> listeCarte;

    public static void main(String[] args) {
        final int matricule = 152637;
        final int codeAdequat = 1234;
        Specification specification = new Specification();
        Automate automate = new Automate();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n~~~~~~~~ACCES~~~~~~~~");
            System.out.println("Veuillez entrer votre matricule");
            int nM = scanner.nextInt();
            System.out.println("Veuillez entrer le code d'accès");
            int cV = scanner.nextInt();
            int nouveauCode = 0;
            boolean carteValide = (nM == matricule);
            boolean codeCorrect = (cV == codeAdequat);

            automate.VerificationCarte(carteValide);
            if (automate.check.equalsIgnoreCase("Carte Validé")) {
                   if(codeCorrect){ //automate.verificationCode(codeCorrect);
                       System.out.print(Automate.Etat.acces_Accepte); }
                    else if(carteValide && cV!=codeAdequat){
                        System.out.println("Code erroné veuillez saisir un autre code");
                        for (int tentatives = 0; tentatives <= 3; tentatives++) {
                           if(tentatives<3){
                               System.out.println("Tentative " + tentatives+":");
                            nouveauCode = scanner.nextInt();
                            if (nouveauCode==codeAdequat) {
                               System.out.println(Automate.Etat.acces_Accepte);
                            }else{
                                System.out.println( Automate.Etat.acces_Refuse);
                            }}
                            else if(tentatives ==3 && nouveauCode!=codeAdequat) {
                                System.out.println("Trop de tentative echouées , le compte sera bloqué dans:");
                                for(int i=10;i>=1;i--){
                                    System.out.println(i+" secondes");
                                    try{
                                        Thread.sleep(1000);
                                    }
                                    catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println( Automate.Etat.acces_Bloque+"\n ~~~~Alarme Déclenchée~~~~");
                            }
                        }
                    }
            } else if(nM!=matricule && cV!=codeAdequat){
                    System.out.println("~~~~ALARME DECLENCHEE~~~~");

                }
        }while (true);
    }
}