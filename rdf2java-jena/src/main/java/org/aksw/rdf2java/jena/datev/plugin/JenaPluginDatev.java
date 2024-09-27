package org.aksw.rdf2java.jena.datev.plugin;

import org.aksw.jenax.reprogen.core.JenaPluginUtils;
import org.aksw.rdf2java.jena.datev.model.Betrag;
import org.aksw.rdf2java.jena.datev.model.Bilanzdaten;
import org.aksw.rdf2java.jena.datev.model.Spende;
import org.apache.jena.enhanced.BuiltinPersonalities;
import org.apache.jena.enhanced.Personality;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.sys.JenaSubsystemLifecycle;

public class JenaPluginDatev
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
        JenaPluginUtils.registerResourceClasses(p, Bilanzdaten.class, Spende.class, Betrag.class);
    }
}
