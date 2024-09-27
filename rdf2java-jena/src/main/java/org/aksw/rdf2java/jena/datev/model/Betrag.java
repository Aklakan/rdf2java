package org.aksw.rdf2java.jena.datev.model;

import org.aksw.jenax.annotation.reprogen.Iri;
import org.aksw.jenax.annotation.reprogen.Namespace;
import org.aksw.jenax.annotation.reprogen.RdfType;
import org.apache.jena.rdf.model.Resource;

@RdfType("https://spec.edmcouncil.org/fibo/ontology/FND/Accounting/CurrencyAmount/MonetaryAmmount")
@Namespace("https://spec.edmcouncil.org/fibo/ontology/FND/Accounting/CurrencyAmmount/")
public interface Betrag
    extends Resource
{

//    @RdfResourceIdAnnotation()
//    private String id;

//    @RdfPropertyAnnotation(propertyName = "https://spec.edmcouncil.org/fibo/ontology/FND/Accounting/CurrencyAmmount/hasAmount")
//    private double wert;
//    @RdfPropertyAnnotation(propertyName = "https://spec.edmcouncil.org/fibo/ontology/FND/Accounting/CurrencyAmount/hasCurrency")
//    private String waehrungskennzeichen;


    @Iri
    Double getWert();
    Betrag setWert(Double value);

    @Iri
    String getWaehrungskennzeichen();
    Betrag setwaehrungskennzeichen(String value);
}
