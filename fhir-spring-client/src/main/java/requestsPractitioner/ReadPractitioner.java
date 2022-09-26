package requestsPractitioner;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r5.model.Practitioner;


public class ReadPractitioner {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR5();

      // Create a client with connection to a server
      IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/");

      // Create a practitioner object
      Practitioner practitioner= new Practitioner();


      // Use available practitioner ID
      try {
         practitioner = client.read().resource(Practitioner.class).withId("https://hapi.fhir.org/baseR4/Practitioner/7012034").execute();
      }

      catch (ResourceNotFoundException e) {
         System.out.print(e);
         System.out.println("Resource not found!");
         return;
      }

      String string = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(practitioner);
      String string1 = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(practitioner);
      System.out.println(string1);



   }
}



