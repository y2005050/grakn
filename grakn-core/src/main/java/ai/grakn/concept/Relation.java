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

package ai.grakn.concept;


import ai.grakn.exception.PropertyNotUniqueException;

import javax.annotation.CheckReturnValue;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <p>
 *     Encapsulates relationships between {@link Thing}
 * </p>
 *
 * <p>
 *     A relation which is an instance of a {@link RelationType} defines how instances may relate to one another.
 *     It represents how different entities relate to one another.
 *     Relations are used to model n-ary relationships between instances.
 * </p>
 *
 * @author fppt
 *
 */
public interface Relation extends Thing {
    //------------------------------------- Modifiers ----------------------------------
    /**
     * Creates a relation from this instance to the provided resource.
     *
     * @param resource The resource to which a relationship is created
     * @return The instance itself
     */
    @Override
    Relation resource(Resource resource);

    //------------------------------------- Accessors ----------------------------------

    /**
     * Retrieve the associated Relation Type for this Relation.
     * @see RelationType
     *
     * @return The associated Relation Type for this Relation.
     */
    @Override
    RelationType type();

    /**
     * Retrieve a list of all Instances involved in the Relation, and the Role Types they play.
     * @see Role
     *
     * @return A list of all the role types and the instances playing them in this relation.
     */
    @CheckReturnValue
    Map<Role, Set<Thing>> allRolePlayers();

    /**
     * Retrieves a list of every {@link Thing} involved in the {@link Relation}, filtered by {@link Role} played.
     * @param roles used to filter the returned instances only to ones that play any of the role types.
     *                  If blank, returns all role players.
     * @return a list of every {@link Thing} involved in the {@link Relation}.
     */
    @CheckReturnValue
    Stream<Thing> rolePlayers(Role... roles);

    /**
     * Expands this Relation to include a new role player which is playing a specific role.
     *
     * @param role The Role Type of the new role player.
     * @param thing The new role player.
     * @return The Relation itself.
     *
     * @throws PropertyNotUniqueException if the concept is only allowed to play this role once.
     */
    Relation addRolePlayer(Role role, Thing thing);

    //------------------------------------- Other ---------------------------------
    @Deprecated
    @CheckReturnValue
    @Override
    default Relation asRelation(){
        return this;
    }

    @Deprecated
    @CheckReturnValue
    @Override
    default boolean isRelation(){
        return true;
    }
}
