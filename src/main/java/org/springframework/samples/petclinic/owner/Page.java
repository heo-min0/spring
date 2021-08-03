package org.springframework.samples.petclinic.owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    private String lastName;
    private String firstName;

    private int currentPage;
    private int totalPage;
    private int startPage;
    private int endPage;

}
