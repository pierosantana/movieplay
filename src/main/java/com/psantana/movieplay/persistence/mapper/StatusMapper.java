package com.psantana.movieplay.persistence.mapper;

import org.mapstruct.Named;

public class StatusMapper {
    @Named("stringToStatus")
    public static Boolean stringToStatus (String estado){
        if(estado == null) return false;
        if(estado.equalsIgnoreCase("D")) return true;
        return false;
    }

    @Named("statusToString")
    public static String statusToString(Boolean status){
        if(status == null) return "N";
        if(status == true) return "D";
        return "N";
    }
}
