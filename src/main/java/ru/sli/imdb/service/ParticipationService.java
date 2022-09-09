package ru.sli.imdb.service;

import org.springframework.stereotype.Service;
import ru.sli.imdb.entities.Participation;
import ru.sli.imdb.repository.ParticipationRepository;

@Service
public class ParticipationService {


    private ParticipationRepository participationRepository;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public Participation findById(Integer id) {

        return participationRepository.getById(id);
    }
}
