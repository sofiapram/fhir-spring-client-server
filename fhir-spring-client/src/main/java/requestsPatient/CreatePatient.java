package requestsPatient;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.*;

public class CreatePatient {

   public static void main(String[] args) {

      // Create a context
      FhirContext ctx = FhirContext.forR4();

      // Create a client
      IGenericClient client = ctx.newRestfulGenericClient("http://hapi.fhir.org/baseR4");

      // Create a patient
      Patient newPatient = new Patient();
// Create an extension and add it to the String

      // Configure the patient with  information
      newPatient
         .addName()
         .setFamily("Pramstrahler")
         .addGiven("Sofia")
         .addGiven("Mira");
      newPatient
         .addIdentifier()
         .setSystem("http://acme.org/mrn")
         .setValue("999999");


      newPatient.
         setGender(Enumerations.AdministrativeGender.FEMALE);
      newPatient.
         setBirthDateElement(new DateType("1999-08-27"));
      // Create an extension and add it to the String
      Extension parent = new Extension("http://example.com#parent", new StringType("Schaar"));
      newPatient.addExtension(parent);

      // Create the resource on the server
      MethodOutcome outcome = client.create().resource(newPatient).execute();

      // Log the ID that the server assigned
      IIdType id = outcome.getId();
      System.out.println("Created patient with generated ID: " + id);



   }
}



