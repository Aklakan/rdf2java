package org.aksw.rdf2java.jena.datev.model;

import org.aksw.jenax.annotation.reprogen.Iri;
import org.aksw.jenax.annotation.reprogen.Namespace;
import org.aksw.jenax.annotation.reprogen.RdfType;
import org.apache.jena.rdf.model.Resource;

@RdfType("http://data.datev.de/bilanzergebnis-ontologie/bilanzergebnis")
@Namespace("http://data.datev.de/bilanzergebnis-ontologie/")
public interface Bilanzdaten
    extends Resource
{

//    @RdfResourceIdAnnotation()
//    private String id;

    @Iri("hatBetrag")
    Betrag getBetrag();
    Bilanzdaten setBetrag(Resource r);

    default Betrag getOrSetBetrag() {
        Betrag result = getBetrag();
        if (result == null) {
            result = getModel().createResource().as(Betrag.class);
            setBetrag(result);
        }
        return result;
    }

    @Iri("hatSpende")
    Spende getSpende();
    Bilanzdaten setSpende(Resource r);

    default Spende getOrSetSpende() {
        Spende result = getSpende();
        if (result == null) {
            result = getModel().createResource().as(Spende.class);
            setSpende(result);
        }
        return result;
    }
}
