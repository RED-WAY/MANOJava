
package manos.validation;


public class FindingOutSystemOperation {


       public String OperationSystem(){
       String os = System.getProperty("os.name");
       String SO = null;

        try {
            if (os.startsWith("Windows")) {
         //       
                SO = "Windonws";
            } else if (os.startsWith("Linux")) {
           //    
               SO = "Linux";
            } 
        } catch (Exception ex) {
            System.out.println("Deu Ruim");
          
        }
        
        return SO;
       }
}



