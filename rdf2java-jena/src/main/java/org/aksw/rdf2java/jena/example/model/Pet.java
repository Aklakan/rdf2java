package org.aksw.rdf2java.jena.example.model;

import java.util.Optional;

import org.apache.jena.enhanced.EnhGraph;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.sparql.vocabulary.FOAF;


public class Pet
    extends ResourceImpl
    implements Agent
{
    public static final Property NAME = FOAF.name;

    public Pet(Node n, EnhGraph m) {
        super(n, m);
    }

    public String getName() {
        return Optional.of(getProperty(NAME)).map(Statement::getString).orElse(null);
    }

    public Pet setName(String name) {
        removeAll(NAME);
        if (name != null) {
            addLiteral(NAME, name);
        }
        return this;
    }
}
