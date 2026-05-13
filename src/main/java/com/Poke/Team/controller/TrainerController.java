package com.Poke.Team.controller;

import com.Poke.Team.entity.Trainer;
import com.Poke.Team.repository.TeamRepository;
import com.Poke.Team.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("poke-app") //http://localhost:8081/poke-app/trainers
@RequiredArgsConstructor
public class TrainerController
{
    private static final Logger log = LoggerFactory.getLogger(TrainerController.class);

    private final TrainerService trainerService;

    //Obtenemos la lista de trainers
    @GetMapping("/trainers") // /trainers
    public List<Trainer> getTrainers()
    {
        List<Trainer> trainers = this.trainerService.getAllTrainers();
        log.info("Get Trainers successful");

        trainers.forEach(trainer -> log.info(trainer.toString()));

        return trainers;
    }

    //Creamos la function para crear Trainers
    @PostMapping("/trainers")
    public Trainer addTrainer(@RequestBody Trainer trainer)
    {
        log.info(" add Trainer: " + trainer);
        return this.trainerService.saveTrainer(trainer);
    }

    //Creamos la function para eliminar trainer
    @DeleteMapping("/trainers/{id}")
    public void deleteTrainer(@PathVariable Long id)
    {
        trainerService.deleteTrainer(id);
    }

    //Creamos la function modificar Trainer
    @PutMapping("/trainers/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody Trainer trainerRecived)
    {
        return trainerService.updateTrainer(id, trainerRecived);
    }
}
