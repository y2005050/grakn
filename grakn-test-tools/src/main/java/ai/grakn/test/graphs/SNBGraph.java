/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016  Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Grakn. If not, see <http://www.gnu.org/licenses/gpl.txt>.
 */

package ai.grakn.test.graphs;

import ai.grakn.GraknGraph;
import ai.grakn.test.GraphContext;

import java.util.function.Consumer;

/**
 * SNBGraph
 * 
 * @author Sheldon
 *
 */
public class SNBGraph extends TestGraph {

    public static Consumer<GraknGraph> get() {
        return new SNBGraph().build();
    }

    @Override
    protected void buildOntology(GraknGraph graph) {
        GraphContext.loadFromFile(graph, "ldbc-snb-ontology.gql");
        GraphContext.loadFromFile(graph, "ldbc-snb-product-ontology.gql");
    }

    @Override
    protected void buildRules(GraknGraph graph) {
        GraphContext.loadFromFile(graph, "ldbc-snb-rules.gql");
    }

    @Override
    protected void buildInstances(GraknGraph graph) {
        GraphContext.loadFromFile(graph, "ldbc-snb-data.gql");
    }
}
