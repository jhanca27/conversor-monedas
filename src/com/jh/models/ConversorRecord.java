package com.jh.models;


public record ConversorRecord(String base_code, 
                        String target_code,
                        String conversion_rate,
                        String conversion_result,
                        String time_last_update_utc) {
    
}
