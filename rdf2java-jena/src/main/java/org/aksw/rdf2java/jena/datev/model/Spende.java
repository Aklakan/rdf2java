package org.aksw.rdf2java.jena.datev.model;

import org.aksw.jenax.annotation.reprogen.Inverse;
import org.aksw.jenax.annotation.reprogen.Iri;
import org.aksw.jenax.annotation.reprogen.RdfType;
import org.apache.jena.rdf.model.Resource;

@RdfType("http://data.datev.de/spende-ontologie/spende")
public interface Spende
    extends Resource
{
    @Iri("http://data.datev.de/spende-ontologie/hat")
    @Inverse
    Betrag getBetrag();
    Betrag setBetrag(Resource r);
}
