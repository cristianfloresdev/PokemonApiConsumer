package com.Poke.Team.service;

import com.Poke.Team.entity.Team;
import com.Poke.Team.entity.Trainer;
import com.Poke.Team.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerService
{
    private final TrainerRepository trainerRepository;

    //Crear trainer
    public Trainer createTrainer(String name)
    {
        Trainer trainer = new Trainer();
        trainer.setName(name);

        Team team = new Team();

        trainer.setTeam(team);
        team.setTrainer(trainer);

        return trainerRepository.save(trainer);
    }

    //Listar trainer
    public List<Trainer> getAllTrainers()
    {
        return this.trainerRepository.findAll();
    }

    //Modificar Trainer
    public Trainer updateTrainer(Long id, Trainer trainerReceived)
    {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found"));

        trainer.setName(trainerReceived.getName());

        return trainerRepository.save(trainer);
    }

    //Eliminar Trainer
    public void deleteTrainer(Long id)
    {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found"));
        trainerRepository.delete(trainer);
    }

    //Guardar Trainers
    public Trainer saveTrainer(Trainer trainer)
    {
        Team team = new Team();

        trainer.setTeam(team);
        team.setTrainer(trainer);

        return this.trainerRepository.save(trainer);
    }

    //Buscar trainers
    public Trainer searchTrainerId(Long id)
    {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
    }
}
