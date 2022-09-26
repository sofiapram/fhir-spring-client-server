package requestsPractitioner;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.PreconditionFailedException;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r5.model.Bundle;

public class DeletePractitioner { public static void main(String[] args) {

    // Create a context
    FhirContext ctx = FhirContext.forR4();

    // Create a client with connection to a server
    IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");

    // Get practitioner object
    Practitioner practitioner= client.read().resource(Practitioner.class).withId("https://hapi.fhir.org/baseR4/Practitioner/7012034").execute();

    try {
        MethodOutcome response = client
                .delete()
                .resource(practitioner)
                .execute();

        System.out.println("Löschen erfolgreich." );
        System.out.println(response.getId());
    } catch (PreconditionFailedException e) {
        System.err.println(e);
    }
}
}
