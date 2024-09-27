package org.aksw.rdf2java.jena.datev.main;

import java.io.IOException;
import java.util.Iterator;

import org.aksw.jenax.graphql.sparql.v2.api.high.GraphQlExec;
import org.aksw.jenax.graphql.sparql.v2.api.high.GraphQlExecFactory;
import org.aksw.jenax.graphql.sparql.v2.api.high.GraphQlExecUtils;
import org.aksw.jenax.graphql.sparql.v2.io.GraphQlIoBridge;
import org.aksw.jenax.model.foaf.domain.api.FoafPerson;
import org.aksw.jenax.ron.RdfArray;
import org.aksw.jenax.ron.RdfElement;
import org.aksw.jenax.ron.RdfElementVisitorRdfToJsonNt;
import org.aksw.jenax.ron.RdfObject;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.sparql.exec.QueryExec;
import org.apache.jena.sparql.path.P_Path0;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class MainRdf2JavaGraphQl {
    public static void main(String[] args) throws IOException {
        Model model = RDFDataMgr.loadModel("example.ttl");
        RDFDataMgr.write(System.out, model, RDFFormat.TURTLE);

        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        String queryStr = """
            query People
                @prefix(map: {
                  foaf: "http://xmlns.com/foaf/0.1/"
                  eg: "http://www.example.org/"
                })
            {
              people @pattern(of: "SELECT DISTINCT ?s { ?s a foaf:Person }") {
                id @bind(of: "?s")
                firstName @one @rdf(ns: "foaf")
                lastName  @one @rdf(ns: "foaf")
                name      @one @rdf(ns: "foaf")
                knows          @rdf(ns: "foaf")
              }
            }
            """;

        GraphQlExecFactory graphql = GraphQlExecFactory.of(() -> QueryExec.newBuilder().graph(model.getGraph()));
        try (GraphQlExec<P_Path0> gExec = graphql.newBuilder().document(queryStr).buildForRon()) {
            Iterator<RdfElement> it = gExec.getDelegate().asIterator(GraphQlIoBridge.bridgeRonToRdfElement());

            while (it.hasNext()) {
                RdfElement elt = it.next();
                RdfObject rdfObject = elt.getAsObject();

                RdfArray people = rdfObject.get("people").getAsArray();
                for (RdfElement item : people) {

                    FoafPerson person = item.getAsObject().as(FoafPerson.class);
                    System.out.println("START PERSON");
                    person.listProperties().forEach(x -> System.out.println("Stmt: " + x));
                    // RDFDataMgr.write(System.out, person.getModel(), RDFFormat.TURTLE_PRETTY);
                    System.out.println("END PERSON");


                    RdfElementVisitorRdfToJsonNt converter = new RdfElementVisitorRdfToJsonNt();
                    JsonElement json = rdfObject.accept(converter);

                    String str = gson.toJson(json);
                    System.out.println(str);
                }
            }
        }

        try (GraphQlExec<String> gExec = graphql.newBuilder().document(queryStr).buildForJson()) {
            GraphQlExecUtils.writePretty(System.out, gExec);
        }
    }
}
