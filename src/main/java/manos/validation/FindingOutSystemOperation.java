
package manos.validation;


public class FindingOutSystemOperation {


       public String OperationSystem(){
       String os = System.getProperty("os.name");
       String SO = null;

        
            if (os.startsWith("Windows")) {
         //       
                SO = "Windows";
            } else if (os.startsWith("Linux")) {
           //    
               SO = "Linux";
            } 
      
        
        return SO;
       }
}



