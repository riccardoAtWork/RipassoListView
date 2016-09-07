package com.example.docente.ripassolistview;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by DOCENTE on 05/09/2016.
 */
public class Reservation {
    private Date reserved;
    private Date start;
    private List<String> players;
    private boolean payed;


    public Reservation(Date reserved, Date start, List<String> players, boolean payed) {
        this.reserved = reserved;
        this.start = start;
        this.players = players;
        this.payed = payed;

    }


    public Date getReserved() {
        return reserved;
    }

    public boolean isPayed() {
        return payed;
    }

    public List<String> getPlayers() {
        return players;
    }

    public Date getStart() {
        return start;
    }

    public boolean isSingle() {
        return players.size() <= 2;
    }


    public static Reservation[] sample() {
           Reservation[] reservations = new Reservation[2];
           List<String> players = Arrays.asList(new String[] {"pippo", "pluto"});
           reservations[0] = new Reservation(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), players, true );
           players = Arrays.asList(new String[] {"pippo", "pluto", "minnie", "clarabella"});
           reservations[1] =  new Reservation(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), players, false );
           return reservations;
    }
}
