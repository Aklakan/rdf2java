package org.aksw.rdf2java.jena;

import java.util.List;

import org.aksw.jenax.annotation.reprogen.Iri;
import org.aksw.jenax.annotation.reprogen.IriNs;
import org.aksw.jenax.annotation.reprogen.Namespace;
import org.apache.jena.rdf.model.Resource;

@Namespace("http://www.example.org/")
public interface Person
    extends Resource
{
    @IriNs
    String getFirstName();
    Person setFirstName(String firstName);

    @IriNs
    String getLastName();
    Person setLastName(String lastName);

    @Iri("http://www.example.org/friend")
    List<Agent> getFriends();
}
