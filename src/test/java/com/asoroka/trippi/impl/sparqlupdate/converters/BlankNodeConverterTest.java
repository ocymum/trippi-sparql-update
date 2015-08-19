
package com.asoroka.trippi.impl.sparqlupdate.converters;

import static org.apache.jena.graph.NodeFactory.createBlankNode;
import static org.trippi.impl.RDFFactories.createResource;

import org.apache.jena.ext.com.google.common.base.Converter;
import org.apache.jena.graph.Node_Blank;
import org.jrdf.graph.BlankNode;
import org.jrdf.graph.GraphElementFactoryException;

public class BlankNodeConverterTest extends TestConversionAndInversion<BlankNode, Node_Blank> {

    private static final BlankNodeConverter bnodeConverter = new BlankNodeConverter();

    private static final BlankNode testBlankNode;

    private static final Node_Blank testNodeBlank;

    static {
        try {
            testBlankNode = createResource();
            testNodeBlank = (Node_Blank) createBlankNode(testBlankNode.getID());
        } catch (final GraphElementFactoryException e) {
            throw new AssertionError();
        }
    }

    @Override
    protected Converter<BlankNode, Node_Blank> converter() {
        return bnodeConverter;
    }

    @Override
    protected BlankNode from() {
        return testBlankNode;
    }

    @Override
    protected Node_Blank to() {
        return testNodeBlank;
    }
}
