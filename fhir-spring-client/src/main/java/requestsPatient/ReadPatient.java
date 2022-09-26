package requestsPatient;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r5.model.Patient;

public class ReadPatient {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR5();

      // Create a client with connection to a server
      IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/");

      // Create a patient object
      Patient patient = new Patient();

      // Use available patient ID
      try {
         patient = client.read().resource(Patient.class).withId("https://hapi.fhir.org/baseR4/Patient/7011979").execute();
      }

      catch (ResourceNotFoundException e) {
         System.out.print(e);
         System.out.println("Resource not found!");
         return;
      }

      String string = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(patient);
      String string1 = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
      System.out.println(string1);



   }
}



