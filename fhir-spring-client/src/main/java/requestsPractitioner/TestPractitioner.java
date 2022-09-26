package requestsPractitioner;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r5.model.Practitioner;

public class TestPractitioner {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR5();

      // Create a client
      IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/");

      // Read a patient with the given ID
       Practitioner practitioner1 = client.read().resource(Practitioner.class).withId("https://hapi.fhir.org/baseR4/Practitioner/7012034").execute();

       //Print the output
       String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(practitioner1);
       System.out.println(string);


   }
}


