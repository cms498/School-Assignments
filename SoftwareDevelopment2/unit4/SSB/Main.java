/**
 * This program houses the main loop for two fighers fighting against eachother, a winner is printed at the end
 * 
 * Author; Chris Shepard
 */

package SSB;

public class Main {
    public static void main(String[] args) {
        System.out.println("The Battle Has Started \n");
        Fighter lonk = new Lonk();
        Fighter manio = new Manio();
        
        while(!lonk.isUnconscious() && !manio.isUnconscious()){
            System.out.println(lonk.getName() + " attacks " + manio.getName());
            int lonkDamage = lonk.attack();
            manio.takeDamage(lonkDamage);
            System.out.println(manio + "\n");
            
            int manioDamage = manio.attack();
            System.out.println(manio.getName() + " attacks " + lonk.getName());
            lonk.takeDamage(manioDamage);
            System.out.println(lonk + "\n");
        }

        if(!lonk.isUnconscious() && manio.isUnconscious()){
            System.out.println(lonk + " Wins!");
        } else if (lonk.isUnconscious() && !manio.isUnconscious()){
            System.out.println(manio + " Wins!");
        } else {
            System.out.println("Its a Draw");
        }
    }
}