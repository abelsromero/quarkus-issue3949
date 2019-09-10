package org.abelsromero.quarkus.repository;

import org.abelsromero.quarkus.model.Conference;
import org.abelsromero.quarkus.orm.AbstractBaseRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConferenceRepository extends AbstractBaseRepository<Conference> {

}
