package requestsPatient;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Patient;

public class SearchPatient {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR5();

      // Create a client with connection to a server
      IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080");

      // Create a patient
      Patient patient = new Patient();

      Bundle results = (Bundle) client
         .search()
         .forResource(Patient.class)
         .returnBundle(Bundle.class)
              .where(Patient.FAMILY.matches().value("Pramstrahler"))
         .returnBundle(Bundle.class)
         .execute();



      //Print the output
      System.out.println("First page: ");
      String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
      System.out.println(string);






   }
}



