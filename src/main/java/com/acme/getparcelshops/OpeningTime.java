package com.acme.getparcelshops;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpeningTime {

    private Integer day;
    private String from;
    private String to;
    private String closedDuring;
}
