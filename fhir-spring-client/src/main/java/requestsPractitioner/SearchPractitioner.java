package requestsPractitioner;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Practitioner;

public class SearchPractitioner {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR4();

      // Create a client with connection to a server
      IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");

      // Create a patient
      Practitioner practitioner = new Practitioner();

      Bundle results = (Bundle) client
         .search()
         .forResource(Practitioner.class)
         .returnBundle(Bundle.class)
              .where(Practitioner.NAME.matches().value("Schaar"))
         .returnBundle(Bundle.class)
         .execute();



      //Print the output
      System.out.println("First page: ");
      String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
      System.out.println(string);






   }
}



