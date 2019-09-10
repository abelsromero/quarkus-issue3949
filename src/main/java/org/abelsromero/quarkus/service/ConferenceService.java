package org.abelsromero.quarkus.service;

import lombok.extern.slf4j.Slf4j;
import org.abelsromero.quarkus.dto.ResultsCollection;
import org.abelsromero.quarkus.model.Conference;
import org.abelsromero.quarkus.repository.ConferenceRepository;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public String create(Conference conference) {
        final LocalDateTime now = LocalDateTime.now();
        conference.setCreatedOn(now);
        conference.setUpdatedOn(now);
        return conferenceRepository.save(conference).toString();
    }

    public ResultsCollection<Conference> filter() {
        return new ResultsCollection<>(conferenceRepository.findAll(Conference.class));
    }

    public Optional<Conference> findById(String id) {
        return Optional.ofNullable(conferenceRepository.findById(Long.valueOf(id), Conference.class));
    }

    public void delete(String id) {
        final Conference conference = new Conference();
        conference.setId(Long.valueOf(id));
        conferenceRepository.delete(conference, Conference.class);
    }
}
