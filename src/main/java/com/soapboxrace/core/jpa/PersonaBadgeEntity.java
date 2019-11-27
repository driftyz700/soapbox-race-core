/*
 * This file is part of the Soapbox Race World core source code.
 * If you use any of this code for third-party purposes, please provide attribution.
 * Copyright (c) 2019.
 */

package com.soapboxrace.core.jpa;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA_BADGE")
@NamedQueries({
        @NamedQuery(name = "PersonaBadgeEntity.findAllBadgesForPersona", query = "SELECT obj FROM PersonaBadgeEntity " +
                "obj WHERE obj.personaEntity.personaId = :personaId"),
        @NamedQuery(name = "PersonaBadgeEntity.findBadgeInSlotForPersona", query = "SELECT obj FROM " +
                "PersonaBadgeEntity obj WHERE obj.personaEntity.personaId = :personaId AND obj.slot = :slot")
})
public class PersonaBadgeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = PersonaEntity.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "persona_id", referencedColumnName = "ID", nullable = false)
    private PersonaEntity personaEntity;

    @ManyToOne(targetEntity = BadgeDefinitionEntity.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "badge_definition_id", referencedColumnName = "ID", nullable = false)
    private BadgeDefinitionEntity badgeDefinitionEntity;

    @Column
    private Integer slot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonaEntity getPersonaEntity() {
        return personaEntity;
    }

    public void setPersonaEntity(PersonaEntity personaEntity) {
        this.personaEntity = personaEntity;
    }

    public BadgeDefinitionEntity getBadgeDefinitionEntity() {
        return badgeDefinitionEntity;
    }

    public void setBadgeDefinitionEntity(BadgeDefinitionEntity badgeDefinitionEntity) {
        this.badgeDefinitionEntity = badgeDefinitionEntity;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}
