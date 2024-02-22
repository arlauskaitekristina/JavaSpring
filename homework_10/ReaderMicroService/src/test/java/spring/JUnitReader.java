package spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JUnitReader {
    private Long id;
    private String firstName;
    private String lastName;
}
