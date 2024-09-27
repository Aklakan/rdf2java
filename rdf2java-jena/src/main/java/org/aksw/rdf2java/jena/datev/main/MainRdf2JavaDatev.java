package org.aksw.rdf2java.jena.datev.main;

import org.aksw.rdf2java.jena.datev.model.Bilanzdaten;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class MainRdf2JavaDatev {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        Bilanzdaten bilanzdaten = model.createResource().as(Bilanzdaten.class);

        // bilanzdaten.get
    }
}
