package com.pradeep.deserializetester.Model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Hacker {
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Object name;
    public String age;
}
