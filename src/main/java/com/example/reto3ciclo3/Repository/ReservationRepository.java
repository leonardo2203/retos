package com.example.reto3ciclo3.Repository;

import com.example.reto3ciclo3.Modelo.Client;
import com.example.reto3ciclo3.Modelo.Reservation;
import com.example.reto3ciclo3.Repository.CrudRepository.ReservationCrudRepository;
import com.example.reto3ciclo3.personalized.CountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> result = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for (int i=0; i< report.size();i++){
            result.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return result;
    }

    public List<Reservation> getReservationPeriod (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public  List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
}
