package org.aksw.rdf2java.jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;

public class MainRdf2JavaJena {
    public static void main(String[] args) {
        // JenaPluginUtils.registerResourceClasses(Pet.class, Person.class, Agent.class);

        Model model = ModelFactory.createDefaultModel();

        Person person = model.createResource().as(Person.class);

        person.setFirstName("John");
        person.setLastName("Doe");

        RDFDataMgr.write(System.out, person.getModel(), RDFFormat.TURTLE_PRETTY);


        Pet pet  = model.createResource().as(Pet.class);

        pet.setName("Waldi");
        person.getFriends().add(pet);

        RDFDataMgr.write(System.out, pet.getModel(), RDFFormat.TURTLE_PRETTY);
    }
}
