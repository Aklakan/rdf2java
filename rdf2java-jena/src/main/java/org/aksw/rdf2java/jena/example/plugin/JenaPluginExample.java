package org.aksw.rdf2java.jena.example.plugin;

import org.aksw.jenax.reprogen.core.JenaPluginUtils;
import org.aksw.rdf2java.jena.example.model.Agent;
import org.aksw.rdf2java.jena.example.model.Person;
import org.aksw.rdf2java.jena.example.model.Pet;
import org.apache.jena.enhanced.BuiltinPersonalities;
import org.apache.jena.enhanced.Personality;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.sys.JenaSubsystemLifecycle;

public class JenaPluginExample
    implements JenaSubsystemLifecycle
{

    @Override
    public void start() {
        init();
    }

    @Override
    public void stop() {
    }

    public static void init() {
        init(BuiltinPersonalities.model);
    }

    public static void init(Personality<RDFNode> p) {
        JenaPluginUtils.registerResourceClasses(p, Pet.class, Person.class, Agent.class);
    }
}
