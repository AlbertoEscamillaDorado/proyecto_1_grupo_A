package org.example.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerarIdProgresivo {
    public static Long generarIdProgresivo(){
        long idProgresivo;

        LocalDateTime ldt = LocalDateTime.now();
        idProgresivo = Long.parseLong(ldt.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));

        return idProgresivo;
    }

}
