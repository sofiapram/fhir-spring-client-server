package requestsPractitioner;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.annotation.OperationParam;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.PreconditionFailedException;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r4.model.Practitioner;

import java.util.Date;

public class UpdatePractitioner {
    public static void main(String[] args) {

        // Create a context
        FhirContext ctx = FhirContext.forR4();

        // Create a client with connection to a server
        IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");

        // Get practitioner object
       Practitioner practitioner= client.read().resource(Practitioner.class).withId("https://hapi.fhir.org/baseR4/Practitioner/7012034").execute();

        System.out.println("version id: "+ practitioner.getIdElement().getVersionIdPart());
        //System.out.println(practitioner.getGender());
        practitioner.setGender(Enumerations.AdministrativeGender.MALE);
        //System.out.println(practitioner.getGender());
        try {
            MethodOutcome outcome = client
                    .update()
                    .resource(practitioner)
                    .execute();
            System.out.println("Update erfolgreich." );
            System.out.println(outcome.getId());
        } catch (PreconditionFailedException e) {
            System.err.println(e);
        }
    }
}
