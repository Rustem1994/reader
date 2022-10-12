package org.rustem.reader.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
//@ToString
public class Task implements Serializable {

    private String name;
    private String status;

    private String text;

    private String word;

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", text='" + text + '\'' +
                ", word='" + word + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (((Task) obj).getName().equals(name)&&((Task) obj).getStatus().equals(status)){
            return true;
        }
        return false;
    }
}
