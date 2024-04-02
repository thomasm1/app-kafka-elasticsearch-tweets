package app.mapl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Data
public class Authority {
    private static String value;
    private static List<String> values = new ArrayList<>();
    public Authority(String value) {
        this.value = value;
    }




    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }


}
