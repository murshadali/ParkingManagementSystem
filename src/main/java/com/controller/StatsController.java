
package com.controller;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import com.view.Stats;
import com.model.StatsModel;
public class StatsController {
    public void displayStatsController(Stats stats){
        StatsModel statsmodel= new StatsModel();
        int totalv = statsmodel.totalVehicleToday();
        if(totalv>0){
            stats.setTotalVehicles(totalv);
        } 
        int dayEarning = statsmodel.todayEarning();
        if(dayEarning>0){
            stats.setTotalEarnings(dayEarning);
        }
        
        int availableSlot = statsmodel.availableSlotCount();
        if(availableSlot>0){
            stats.setAvailableSlots(availableSlot);
        }
        
        int occupiedSlot = statsmodel.occupiedSotCount();
        if(occupiedSlot>0){
            stats.setOccupiedSlots(occupiedSlot);
        }
        System.out.println("inside stats controller");
        
    }
}
