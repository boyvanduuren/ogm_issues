package com.github.boyvanduuren.recursivenode.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

public class Entity {

    private Long id;
    private String name;

    @Relationship(type = "REL", direction = "OUTGOING")
    private Entity rel;

    @Relationship(type = "REL", direction = "INCOMING")
    private Set<Entity> childRels = new HashSet<>();

    public Entity() {}

    public Entity(String name) {
        this.name = name;
    }

    public Entity setRel(Entity entity) {
        entity.childRels.add(this);
        rel = entity;

        return this;
    }
}
