package requestsPractitioner;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.*;

public class CreatePractitioner {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR4();

      // Create a client
      IGenericClient client = ctx.newRestfulGenericClient("http://hapi.fhir.org/baseR4");

      // Create a practitioner
      Practitioner newPractitioner = new Practitioner();


      // Configure the practitioner with  information

      newPractitioner.addName(). addGiven("Schaar");
      newPractitioner
              .addIdentifier();
      newPractitioner.setGender(Enumerations.AdministrativeGender.FEMALE);


      newPractitioner.
         setBirthDateElement(new DateType("1968-08-12"));


      // Create the resource on the server
      MethodOutcome outcome = client.create().resource(newPractitioner).execute();

      // Log the ID that the server assigned
      IIdType id = outcome.getId();
      System.out.println("Created practitioner with generated ID: " + id);



   }
}



